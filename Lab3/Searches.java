public class Searches{

    // contains: search for an item in an array
    // precondition: data != null
    // postcondition: if target is found in array, returns true; otherwise, returns false
    public static <T> boolean contains(T[] data, T target) {
	boolean found = false;
	
	for (int i = 0; i < data.length && !found; i++) {
	    found = (data[i].equals(target)); // same as: if (data[i] == target) found = true;
	}
	return found;    
    }

    // linearSearch: search for an item in an array
    // precondition: data != null
    // postcondition: if target is found in array, returns its index; otherwise, returns -1
    public static <T> int linearSearch(T[] data, T target) {
	int found = -1;
	
	for (int i = 0; i < data.length && (found == -1); i++) {
	    if (data[i].equals(target)) {
		found = i;
	    }
	}
	return found;    
    }
    
    // binarySearch: search for an item in an array
    // precondition: array data is sorted
    // postcondition: if target is found in array, returns true; otherwise, returns false
    public static <T extends Comparable<? super T>> boolean binarySearch(T[] data, T target) {
	int low = 0, high = data.length-1;
     
	while (low<=high){
	    int mid = low + (high-low)/2;
	    if (data[mid].equals(target)){
		return true;
	    } else if (data[mid].compareTo(target)<0){
		low = mid + 1;
	    } else {
		high = mid - 1;
	    }
	}
	return false;
    }


    public static void main(String[] args){
    	Integer[] testInts = {-12, -7, -4, -2, 0, 3, 5, 9, 13, 18, 22, 45};

		String[] months = {"All Saints", "Breslin", "duPont", "Fulford", "Gailor", "Guerry", "McClurg", "Spencer", "Woods"};
		System.out.println(linearSearch(months,"All Saints"));
		System.out.println(binarySearch(months,"All Saints"));
		System.out.println(linearSearch(testInts, 5));
		System.out.println(linearSearch(testInts,22));
    }
}
