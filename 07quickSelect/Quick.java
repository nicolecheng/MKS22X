import java.util.*;

public class Quick{

    private static boolean DEBUG = true;
    
    private static int[] partition(int[]data, int left, int right){
	
	int[]ret=new int[2];
	int ind = (int)(Math.random()*(right-left))+left;
	int val = data[ind];

	
	//debug("index = "+ind+", value = "+val);
	//debug("bounds = "+left+":"+right);
	//debug(retArray(data));
	
	
	// swippity swappity (init)
	swap(data,ind,right);

	int duplicates = 0;

	int templeft = left;
	int tempright = right-1;
	
	while(templeft!=tempright){
	    if(data[templeft]==val){
		duplicates++;
		templeft++;
	    }else if(data[templeft]<val){
		templeft++;
	    }else{ // switch vals at bounds
	        swap(data,templeft,tempright);
		tempright--;
	    }
	}

	if(data[tempright]>val){
	    ind = tempright-duplicates-1;
	    ret[0]=ind;
	    ret[1]=ind+duplicates;
	    swap(data,right,ind);
	    for(int i = ind-1; i > 0; i--){
		if(data[i]==val && duplicates > 0){
		    swap(data,i,ind+duplicates);
		    duplicates--;
		}
	    }
	}else{
	    ind = tempright+1;
	    ret[0]=ind-duplicates;
	    ret[1]=ind;
	    swap(data,right,ind);
	    for(int i = ind-1; i > 0; i--){
		if(data[i]==val && duplicates > 0){
		    swap(data,i,ind-duplicates);
		    duplicates--;
		}
	    }
	}

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
	
	int[]A={7,7,4,2,3,0,7,1,-6,12,8,7,5}; // -6,0,1,2,3,4,5,7,7,7,7,8,12
	//int[]b={9,0,-30,74,1}; // -30,0,1,9,74
	//int[]c={200,789,59,84,227,431,10001,927}; // 59,84,200,227,431,789,927,10001

        //quickSort2(A);

	
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
       
	
	int[]ab=new int[1000000];
	for(int i = 0; i < 1000000;i++){
	    ab[i]=0;
	}
	
	long startTime = System.currentTimeMillis();
        quickSort(ab);
	long endTime = System.currentTimeMillis();
	System.out.println("quickSort took " + (endTime - startTime) + " milliseconds");
	
    }

}
