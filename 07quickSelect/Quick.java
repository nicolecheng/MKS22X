import java.util.*;

public class Quick{

    private static boolean DEBUG = true;

    private static int partition(int[]data, int left, int right){
	
	int ind = (int)(Math.random()*(right-left))+left;
	int val = data[ind];
	debug("index = "+ind+", value = "+val);
	debug("bounds = "+left+":"+right);
	debug(retArray(data));

	// swippity swappity (init)
	data[ind]=data[right];
	data[right]=val;

	int templeft = left;
	int tempright = right-1;
	int hold;
	
	while(templeft!=tempright){
	    if(data[templeft]<val){
		templeft++;
	    }else{ // switch vals at bounds
		hold = data[templeft];
		data[templeft]=data[tempright];
		data[tempright]=hold;
		tempright--;
	    }
	}

	if(tempright>=val){
	    data[right]=data[tempright];
	    data[tempright]=val;
	    ind = tempright;
	}else{
	    data[right]=data[tempright+1];
	    data[tempright+1]=val;
	    ind = tempright+1;
	}

	debug(retArray(data));	
	debug("final index = "+ind);
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

    public static void printArray(int[]data){
	System.out.print("[");
	for(int i = 0; i < data.length-1; i++){
	    System.out.print(data[i]+",");
	}
	System.out.print(data[data.length-1]+"]");
    }

    public static String retArray(int[]data){
	String s = "[";
	for(int i = 0; i < data.length-1; i++){
	    s += data[i]+",";
	}
	s += data[data.length-1]+"]";
	return s;
    }

    public static void main (String[]args){
	int[]a={7,2,1,4,5,8,12,0,-6,3,7};
	Quick.partition(a,5,10);
    }

}
