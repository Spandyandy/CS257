// Routines to sort arrays of integers.
// (c) 1997, 2001 duane a. bailey
// modified by spc

import java.util.Scanner;

public class SelectionSort
{
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
	long sec = System.currentTimeMillis();
	selectionSort(data,n);
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
    public static void selectionSort(int data[], int n)
    // pre: 0 <= n <= data.length
    // post: values in data[0..n-1] are in ascending order
    {
	int numUnsorted = n;
	int index;	// general index
	int max;	// index of largest value
	while (numUnsorted > 0)
	{
	    // determine maximum value in array
	    max = 0;
	    for (index = 1; index < numUnsorted; index++)
	    {
		if (data[max] < data[index]) max = index;
	    }
	    swap(data,max,numUnsorted-1);
	    numUnsorted--;
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
