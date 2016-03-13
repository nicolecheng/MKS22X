import java.util.*;

public class Quick{

    private static boolean DEBUG = true;

    private static int[] partition(int[]data, int left, int right){
	
	int[]ret=new int[2];
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

	int duplicates = 1;

	int templeft = left;
	int tempright = right-1;
	int hold;
	
	while(templeft!=tempright){
	    if(data[templeft]==val){
		duplicates++;
	    }else if(data[templeft]<val){
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
	    for(int i = duplicates-1; i > 0; i--){
		data[ind-1]=val;
	    }
	    ret[0]=ind-duplicates+1;
	    ret[1]=ind;
	}else{
	    data[right] = data[tempright+1];
	    data[tempright+1] = val;
	    ind = tempright+1;
	    for(int i = 1; i < duplicates; i++){
		data[ind+i]=val;
	    }
	    ret[0]=ind;
	    ret[1]=ind+duplicates-1;
	}

	return ret;
	//return ind-(duplicates/2); // middle index of duplicates (if any)

    }

    /*
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

    private static void QuickSort(int[]data,int left,int right){
	int ind;
	if(left<right){
	    ind = partition(data,left,right);
	    QuickSort(data,left,ind);
	    QuickSort(data,ind+1,right);
	}
    }

    private static int[] QuickSort2(int[]data){ //returns an int array
        QuickSort(data,0,data.length-1);
	debug(retArray(data));
	return data;
	}*/

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


    public static void QuickSortOld(int[]data){
	QuickSortOld(data,0,data.length-1);
    }
    
    private static void QuickSortOld(int[]data,int left,int right){
	int ind;
	if(left<right){
	    ind = partitionOld(data,left,right);
	    QuickSortOld(data,left,ind);
	    QuickSortOld(data,ind+1,right);
	}
    }

    private static int[] QuickSortOld2(int[]data){ //returns an int array
        QuickSortOld(data,0,data.length-1);
	debug(retArray(data));
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
	
	printArray(partition(a,0,10));

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

	/*
	// 4mil elements
	int[]A; // 1, 2, or 3
	int[]B; // Integer.MIN_VALUE -> Integer.MAX_VALUE
	 

	for(int i=0;i<4000000;i++){
	A[i]=(int)(Math.random()*3)+1;
	if(Math.random()>0.5){
	B[i]=(int)(Math.random()*Integer.MAX_VALUE);
	}else{
	B[i]=(int)(Math.random()*Integer.MIN_VALUE);
	}
	}
	*/
	/*
	int[]ab=new int[1000000];
	for(int i = 0; i < 1000000;i++){
	    ab[i]=0;
	}
	
	long startTime = System.currentTimeMillis();
        QuickSort2(a);
	long endTime = System.currentTimeMillis();
	System.out.println("quickSort took " + (endTime - startTime) + " milliseconds");
	*/ 
    }

}
