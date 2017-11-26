/*
*
*	Junghoo Kim (Andy)
*	Searches.java
*	This program creates an random size array and gives random 
*	elements in it. It gives the index value of the number
*	user is trying to search.  
*
*/
import java.util.Scanner;
public class Searches{
	public static void main(String args[]){
		//creates an array with random size from 1-1000
		int sizeAr = (int)(Math.random()*1000)+1;
		int[] data = new int[sizeAr];
		for(int i = 0; i < sizeAr; i++){
			data[i] = (int)(Math.random()*sizeAr)+1;
		}

		//prompts user for a number
		System.out.print("There are " + sizeAr + " random numbers from 1-" 
				+ sizeAr + ".\nType the number you are searching: ");
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();

		//search the number, return index
		int index = linearSearch(data, key);
		if(index != -1){
			System.out.println("\nThe number you are looking for is " 
							+ key + ", and has an index of " + index + ".\n");
		}
		else{
			System.out.println("Sorry, the number you are searching is " + key +
				" and it is not in the array.\n");
		}
	}

	public static int linearSearch(int[] a, int key){
		int i = 0;
		while(i < a.length){
			if(a[i] == key)
				return i; //returning index
			i++;
		}
		return -1; //key not in array
	}
}