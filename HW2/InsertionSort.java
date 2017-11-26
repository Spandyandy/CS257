// Routines to sort arrays of integers.
// (c) 1997, 2001 duane a. bailey
// Modified (c) 2004 Stephen P. Carl

import java.util.Scanner;

public class InsertionSort
{
    static int compares;
    public static void main(String args[])
    {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter size of array to sort: ");
	int n = sc.nextInt();
	int data[] = new int[n];
	int i;

	for (i = 0; i < n; i++)
	{
	    data[i] = (int)(Math.random()*n)+1;
	}
	compares = 0;

	long sec = System.currentTimeMillis();
	insertionSort(data,n);
	sec = System.currentTimeMillis() - sec;
	System.out.println("Sorting completed");
	// prints out the sorting time
	System.out.println("Time to Sort: " + sec / 1000.0);
	System.out.print("Would you like to output the entire sorted arry? (enter y or n): ");
    
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


    public static void insertionSort(int data[], int n)
    // pre: 0 <= n <= data.length
    // post: values in data[0..n-1] are in ascending order
    {
	int numSorted = 1;	// number of values in place
	int index;		// general index
	while (numSorted < n)
	{
	    // take the first unsorted value
	    int temp = data[numSorted];
	    // ...and insert it among the sorted:
	    for (index = numSorted; index > 0; index--)
	    {
		compares++;
		if (temp < data[index-1])
		{
		    data[index] = data[index-1];
		} else {
		    break;
		}
	    }
	    // reinsert value
	    data[index] = temp;
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
