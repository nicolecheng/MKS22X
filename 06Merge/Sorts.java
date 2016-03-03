// Nicole Cheng
// apcs pd7
// hw16
// 2014-11-15

public class Sorts{
    public static void printArray(int[]data){
	//print the array like:  [ 1, 2, 3, 4]
	String ret = "[ ";
	for (int i = 0; i < data.length; i++){
	    ret += data[i];
	    if (i != data.length-1){
		ret += ", ";
	    }
	}
	System.out.println(ret + "]");
    }
    
    public static void insertionSort(int[]data){
	//your code here to make data re-order its elements
	//from least to greatest just like we did in class
	//same algorithm as the way you created your OrderedSuperArray

	if (data.length > 1){
	
	    int index = 1; // where are we up to?
	    int insert = 0;
	    int hold = data[index];
	
	    while (index < data.length){
		if (data[index] >= data[index-1]){
		    index++;
		}else{
		    hold = data[index];
		    insert = index-1;
		    while (hold < data[insert] && insert > 0 && hold < data[insert-1]){
			insert--;
		    }
	    
		    for (int i = index; i > insert; i--){
			data[i] = data[i-1];
		    }
		    data[insert] = hold;
		    index++;		
		}
	    }
	}
    }

    public static void main(String[]args){
	int[] arrayName = { 8, 6, 7, 5, 3, 0, 9};
	Sorts.printArray( arrayName);
	Sorts.insertionSort( arrayName);
	Sorts.printArray( arrayName);
	
	int[] e = {};
	Sorts.printArray( e);
	Sorts.insertionSort( e);
	Sorts.printArray( e);
	
	int[] ae = { 8, 8, 8, 8, 8};
	Sorts.printArray( ae);
	Sorts.insertionSort( ae);
	Sorts.printArray( ae);

	int[] a = { 9, -9, 6, 3, 17};
	Sorts.printArray( a);
	Sorts.insertionSort( a);
	Sorts.printArray( a);

	int[] ar = { 0};
	Sorts.printArray( ar);
	Sorts.insertionSort( ar);
	Sorts.printArray( ar);

	int[] array = { 15, 14, 13, 12, 11, 10};
	Sorts.printArray( array);
	Sorts.insertionSort( array);
	Sorts.printArray( array);
    }
}
