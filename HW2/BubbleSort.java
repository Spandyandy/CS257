// Routines to sort arrays of integers.
// (c) 1997, 2001 duane a. bailey
// modified by spc

import java.util.Scanner;

public class BubbleSort
{
    public static void main(String args[])
    {
	System.out.print("Enter size of array to sort: ");

	// Note: Java 1.5 includes a new class Scanner to read input
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();

	int data[] = new int[n];
	int i;

        // reads array values from the keyboard
	for (i = 0; i < n; i++)
	{
	    data[i] = (int)(Math.random()*n)+1;
	}

        // code to time the bubble sort operation
	long sec = System.currentTimeMillis();
	bubbleSort(data,n);
	sec = System.currentTimeMillis() - sec;
	System.out.println("Sorting completed");
	// prints out the sorting time
	System.out.println("Time to Sort: " + sec / 1000.0);
	System.out.print("Would you like to output the entire sorted arry? (enter y or n): ");
    

    // prints out all the array values
	String s = sc.next();
	char c = s.charAt(0);
	if((c == 'n' || c == 'N') && n >= 100){
		for (i = 0; i < 100; i++)
		{
		    System.out.print(data[i]+" ");
		    if (((i+1) % 15) == 0) System.out.println();
		}
		System.out.println();
   	}
   	else if(c == 'y' || c =='Y' || n < 100){
		for (i = 0; i < n; i++)
		{
		    System.out.print(data[i]+" ");
		    if (((i+1) % 15) == 0) System.out.println();
		}
		System.out.println();
	}
}

    public static void bubbleSort(int data[], int n)
    // pre: 0 <= n <= data.length
    // post: values in data[0..n-1] in ascending order
    {
	int numSorted = 0;	// number of values in order
	int index;		// general index
	while (numSorted < n)
	{
	    // bubble a large element to higher array index
	    for (index = 1; index < n-numSorted; index++)
	    {
		if (data[index-1] > data[index])
		    swap(data,index-1,index);
	    }
	    // at least one more value in place
	    numSorted++;
	}
    }
    public static void swap(int data[], int i, int j)
    // pre: 0 <= i,j < data.length
    // post: data[i] and data[j] are exchanged
    {
	int temp;
	temp = data[i];
	data[i] = data[j];
	data[j] = temp;
    }
	

}	
