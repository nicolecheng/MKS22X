import java.util.*;

public class Quick{

    private static boolean DEBUG = true;

    private static int partition(int[]data, int left, int right) {
	int ind = (int)(Math.random()*(right-left))+left;
	debug(ind);
	return ind;
    }
    // choose a random partition element at a location from left to right inclusive.
    // partition the array such that the randomly chosen element divides all values smaller and larger than it. 
    // smaller elements on the left side of the partition, larger on the right side
    // return the index of the partition element. 
    // this allows your quickselect method to decide where to go next.

    // Quick Select will now give the kth smallest value, so the k corresponds to the index of the array! Save you one subtraction!

	
    public static int quickselect(int[]data, int k){
	return 5;
    }
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length

    private static void debug(String s){
	if(DEBUG)
	    System.out.println(s);
    }
    private static void debug(int m){
	if(DEBUG)
	    System.out.println(m);
    }

    public static void main (String[]args){
	int[]a={7,2,1,4,5,8,12,0,-6,3};
	Quick.partition(a,5,10);
    }

}
