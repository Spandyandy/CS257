/**
*	ArrayBoundedQueue.java      
*	Implements QueueInterface with an array to hold the queue elements.
*
*	Two constructors are provided: one that creates a queue of a default
*	capacity and one that allows the calling program to specify the capacity.
*
*	@author Dale, Joyce, Weems Modified by Andy Kim
*/
package ch04.queues;

public class ArrayBoundedQueue<T> implements QueueInterface<T>
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // array that holds queue elements
  protected int numElements = 0;    // number of elements in this queue
  protected int front = 0;          // index of front of queue
  protected int rear;               // index of rear of queue


  /**
  *  Constructs an object array with size of default capacity and set rear equal to capacity-1
  *  @precondition: DEFCAP > 0
  *  @postcondition: an object array called elements and rear = DEFCAP - 1
  *
  */
  public ArrayBoundedQueue() 
  {
    elements = (T[]) new Object[DEFCAP];
    rear = DEFCAP - 1;
  }

  /**
  *  Constructs an object array with size of maxSize and set rear equal to maxSize-1
  *  @param integer maximum size 
  *  @precondition: maxSize > 0
  *	 @postcondition: an object array is assigned to elements and rear = maxSize - 1
  *
  */
  public ArrayBoundedQueue(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
    rear = maxSize - 1;
  }

	/**
     * Method to add element to the rear of the queue if it is not full
     * @param element an array of Type variable.
     * @precondition: queue is not full
     * @postcondition: adds element to the rear of this queue
     * @throws QueueOverflowException
     */
  public void enqueue(T element)
  // Throws QueueOverflowException if this queue is full;
  // otherwise, adds element to the rear of this queue.
  {  
    if (isFull())
      throw new QueueOverflowException("Enqueue attempted on a full queue.");
    else
    {
      rear = (rear + 1) % elements.length;
      elements[rear] = element;
      numElements = numElements + 1;
    }
  }

  	/**
     * Method to removes front element from the queue
     * @precondition: the queue is not empty
     * @postcondition: removes front element from this queue and returns it
     * @throws QueueUnderflowException
     */
  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {   
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T toReturn = elements[front];
      elements[front] = null;
      front = (front + 1) % elements.length;
      numElements = numElements - 1;
      return toReturn;
    }
  }

  	/**
     * Method to check if this queue is empty
     * @postcondition: returns true if this queue is empty; otherwise, return false
     */
  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    return (numElements == 0);
  }

	/**
     * Method to check if this queue is full
     * @postcondition: returns true if this queue is full; otherwise, return false
     */
  public boolean isFull()
  // Returns true if this queue is full; otherwise, returns false.
  {              
    return (numElements == elements.length);
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