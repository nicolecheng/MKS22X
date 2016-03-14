// special shoutout to those precious souls who helped me on this

import java.util.*;

public class Quick{

    private static boolean DEBUG = false;
    
    private static int[] partition(int[]data, int left, int right){

	if(left==right){
	    int[]ret = {left,right};
	    return ret;
	}

	int[]ret=new int[2];
	int ind = (int)(Math.random()*(right-left+1))+left;
	int val = data[ind];

	/*	
		debug("index = "+ind+", value = "+val);
		debug("bounds = "+left+":"+right);
		debug(retArray(data));
	*/

	int[]hold = new int[data.length];

	for(int i = 0; i < data.length; i++){
	    hold[i]=data[i];
	}

	int templeft = left;
	int tempright = right;

	for(int i = templeft; i <= right; i++){
	     if(data[i]<val){
		hold[templeft]=data[i];
		templeft++;
	    }else if(data[i]>val){
		hold[tempright]=data[i];
		tempright--;
	    }
	}

	// copy over duplicates
	for(int i = templeft; i <= tempright; i++){
	    hold[i] = val;
	}

	// over to data
	for(int i = 0; i < data.length; i++){
	    data[i] = hold[i];
	}
	
	ret[0]=templeft;
	ret[1]=tempright;
	
	//debug(retArray(ret));
	//debug(retArray(data));
	return ret;
	
    }
    

    public static int quickselect(int[] data, int k){
	return quickSelect(data,0,data.length-1,k);
    }
    
    public static int quickSelect(int[] data, int left,int right,int k){
	if(right == left){
	    return data[right];
	}else{	
	    int[]hold = partition(data, left, right);
	    if(hold[1] == k){
		return data[k];
	    }else if(hold[1] > k){
		return quickSelect(data,left,hold[0],k);
	    }else{
		return quickSelect(data,hold[1]+1,right,k);
	    }
	}	
    }
    /*
    private static void quickSort(int[]data,int left,int right){
	int[]ind;
	if(left<right){
	    ind = partition(data,left,right);
	    quickSort(data,left,ind[0]);
	    quickSort(data,ind[1]+1,right);
	}
    }
    
    private static void quickSort(int[]data){
	quickSort(data, 0, data.length-1);
	}*/

        public static void quickSort(int[] data){
	quickSort(data,0,data.length-1);
    }

    public static void quickSort(int[] data, int left, int right){
	if(right-left>0){
	    int[] pos=partition(data,left,right);
	    quickSort(data,left,pos[0]-1);
	    quickSort(data,pos[1]+1,right);
	}
    }

    //*****************************************************************************************************************

    private static int partitionOld(int[]data, int left, int right){
	
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
	
    public static int quickselectOld(int[]data, int k){
	int left = 0;
	int right = data.length-1;
	int index = partitionOld(data,left,right);
	while(index!=k){
	    if(index<k){
		index=partitionOld(data,index,right);
	    }else{
		index=partitionOld(data,left,index);
	    }
	}
	debug(data[index]);
	return data[index];
    }
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length


    public static void quickSortOld(int[]data){
	quickSortOld(data,0,data.length-1);
    }
    
    private static void quickSortOld(int[]data,int left,int right){
	int ind;
	if(left<right){
	    ind = partitionOld(data,left,right);
	    quickSortOld(data,left,ind);
	    quickSortOld(data,ind+1,right);
	}
    }

    private static int[] quickSortOld2(int[]data){ //returns an int array
        quickSortOld(data,0,data.length-1);
	debug(retArray(data));
	return data;
    }

    //*****************************************************************************************************************

    private static void swap(int[] data, int x, int y){
	int n = data[x];
	data[x] = data[y];
	data[y] = n;
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
	System.out.print(data[data.length-1]+"]\n");
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
	
	//int[]A={7,7,4,2,3,0,7,1,-6,12,8,7,5}; // -6,0,1,2,3,4,5,7,7,7,7,8,12
	//int[]B={9,0,-30,74,1}; // -30,0,1,9,74
	//int[]C={200,789,59,84,227,431,10001,927}; // 59,84,200,227,431,789,927,10001
	
	//debug(retArray(partition(A,0,12)));
        //quickSort(A);
	//debug(retArray(A));

	/*
	//LIKE THIS:
	int[] d = new int [4000000];
	int[] c = new int [d.length];

	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    c[i]= d[i];
	}
	
	quickSortOld(d); //or even your old quicksort!!!
	Arrays.sort(c);
	System.out.println("Done: Sorted="+Arrays.equals(d,c));
	*/
	       
	/*
	int[]ab=new int[1000000];
	for(int i = 0; i < 1000000;i++){
	    ab[i]=0;
	}
	*/

	/*
	// 4mil elements
	int[]a = new int[4000000]; // 1, 2, or 3
	int[]b = new int[4000000]; // Integer.MIN_VALUE -> Integer.MAX_VALUE
	 

	for(int i=0;i<4000000;i++){
	    a[i]=(int)(Math.random()*3)+1;
	    if(Math.random()>0.5){
		b[i]=(int)(Math.random()*Integer.MAX_VALUE);
	    }else{
		b[i]=(int)(Math.random()*Integer.MIN_VALUE);
	    }
	}

	
	long startTime = System.currentTimeMillis();
	// debug(retArray(partition(ab,0,999999)));
        Arrays.sort(a);
	long endTime = System.currentTimeMillis();
	System.out.println("Arrays.sort took " + (endTime - startTime) + " milliseconds");
	startTime = System.currentTimeMillis();
        //quickSortOld(a);
	endTime = System.currentTimeMillis();
	System.out.println("quickSortOld took " + (endTime - startTime) + " milliseconds");	
	startTime = System.currentTimeMillis();
        quickSort(a);
	endTime = System.currentTimeMillis();
	System.out.println("quickSort took " + (endTime - startTime) + " milliseconds");	

	System.out.println();

    	startTime = System.currentTimeMillis();
        Arrays.sort(b);
	endTime = System.currentTimeMillis();
	System.out.println("Arrays.sort took " + (endTime - startTime) + " milliseconds");	
	startTime = System.currentTimeMillis();
        quickSortOld(b);
	endTime = System.currentTimeMillis();
	System.out.println("quickSortOld took " + (endTime - startTime) + " milliseconds");	
	startTime = System.currentTimeMillis();
        quickSort(b);
	endTime = System.currentTimeMillis();
	System.out.println("quickSort took " + (endTime - startTime) + " milliseconds");	
	*/
    }

}
