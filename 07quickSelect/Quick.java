import java.util.*;

public class Quick{

    private static boolean DEBUG = false;

    private static int partition(int[]data, int left, int right){
	
	int ind = (int)(Math.random()*(right-left))+left;
	int val = data[ind];
	
	/*
	  debug("index = "+ind+", value = "+val);
	  debug("bounds = "+left+":"+right);
	  debug(retArray(data));
	*/

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

	if(data[tempright]>=val){
	    data[right] = data[tempright];
	    data[tempright] = val;
	    ind = tempright;
	}else{
	    data[right] = data[tempright+1];
	    data[tempright+1] = val;
	    ind = tempright+1;
	}

	return ind;
	
    }
    // choose a random partition element at a location from left to right inclusive.
    // partition the array such that the randomly chosen element divides all values smaller and larger than it. 
    // smaller elements on the left side of the partition, larger on the right side
    // return the index of the partition element. 
    // this allows your quickselect method to decide where to go next.

    // Quick Select will now give the kth smallest value, so the k corresponds to the index of the array! Save you one subtraction!

	
    public static int quickselect(int[]data, int k){
	int left = 0;
	int right = data.length-1;
	int index = partition(data,left,right);
	while(index!=k){
	    if(index<k){
		index=partition(data,index,right);
	    }else{
		index=partition(data,left,index);
	    }
	}
	debug(data[index]);
	return data[index];
    }
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length


    public static void quickSort(int[]data){
	quickSort(data,0,data.length-1);
    }
    
    private static void quickSort(int[]data,int left,int right){
	int ind;
	if(left<right){
	    ind = partition(data,left,right);
	    quickSort(data,left,ind);
	    quickSort(data,ind+1,right);
	}
    }
    private static int[] quickSort2(int[]data){
        quickSort(data,0,data.length-1);
	return data;
    }
    
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

    public static String name(){
	return "6,Cheng,Nicole";
    }
        
    public static void main (String[]args){
	
	int[]a={7,7,4,2,3,0,1,-6,12,8,5}; // -6,0,1,2,3,4,5,7,7,8,12
	int[]b={9,0,-30,74,1}; // -30,0,1,9,74
	int[]c={200,789,59,84,227,431,10001,927}; // 59,84,200,227,431,789,927,10001
	
	/*
	quickselect(a,3); // 2
	quickselect(a,6); // 5
	quickselect(a,1); // 0
	*/

	/*
	debug(retArray(quickSort2(a)));
	debug(retArray(quickSort2(b)));
	debug(retArray(quickSort2(c)));
	*/
	    
    }

}
