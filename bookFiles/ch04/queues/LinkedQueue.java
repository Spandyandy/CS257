/**
*	LinkedQueue.java      
*	Implements QueueInterface using a linked list.
*
*	@author Dale, Joyce, Weems Modified by Andy Kim
*/
package ch04.queues;

import support.LLNode;

public class LinkedQueue<T> implements QueueInterface<T>
{
  protected LLNode<T> front;     // reference to the front of this queue
  protected LLNode<T> rear;      // reference to the rear of this queue
  protected int numElements = 0; // number of elements in this queue

  /**
  *  Constructs a queue, set front and rear to null 
  *  @postcondition: create a linked queue, front and rear will be null
  *
  */
  public LinkedQueue()
  {
    front = null;
    rear = null;
  }

  	/**
     * Method to add element to the rear of the queue
     * @param element an array of Type variable.
     * @precondition: the queue is not full
     * @postcondition: adds element to the rear of this queue
     * @throws QueueOverflowException - if queue is full
     */
  public void enqueue(T element)
  // Adds element to the rear of this queue.
  { 
    LLNode<T> newNode = new LLNode<T>(element);
    if (rear == null)
      front = newNode;
    else
      rear.setLink(newNode);
    rear = newNode;
    numElements++;
  }     

  	/**
     * Method to remove front element from this queue.
     * @precondition: the queue is not empty
     * @postcondition: removes front element from this queue and returns it.
     * @throws QueueUnderflowException - if queue is empty    
     */
  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T element;
      element = front.getInfo();
      front = front.getLink();
      if (front == null)
        rear = null;
      numElements--;
      return element;
    }
  }

  	/**
     * Method to check if this queue is empty
     * @postcondition: returns true if this queue is empty; otherwise, return false
     */
  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    return (front == null);
  }
  
 	/**
     * Method to check if this queue is full
     * @postcondition: returns false because a linked queue is never full
     */
  public boolean isFull()
  // Returns false - a linked queue is never full.
  {              
    return false;
  }

  	/**
     * size of the queue
     * @postcondition: returns the number of elements in this queue in int.
     */
  public int size()
  // Returns the number of elements in this queue.
  {
    return numElements;
  }

}

