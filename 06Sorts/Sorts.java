// Nicole Cheng
// apcs pd6
// Sorts Revamped
// 2016-03-06

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

    // ********************************************************************************************************
    
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
		    printArray(data);	
		}
	    }
	}
    }

    // ********************************************************************************************************
    
    public static void selectionSort(int[]data){
	if (data.length > 1){
            int index = 0;
	    while (index < data.length){
		int min = data[index];
		int minInd = index;
		for (int i = index; i < data.length; i++){
		    if (data[i] < min){
			min = data[i];
			minInd = i;
		    }
		}
		data[minInd] = data[index];
		data[index] = min;
		index++;
		printArray(data);	
	    }
	}
    }

    // ********************************************************************************************************

    public static void bubbleSort(int[]data){
	int sorted = data.length; // from which index is it sorted?
	int hold = 0;
	while (sorted > 0){
	    for (int i = 0; i < sorted-1; i++){
		if (data[i] > data[i+1]){
		    hold = data[i+1];
		    data[i+1] = data[i];
		    data[i] = hold;
		}
	    }
	    sorted --;
	    printArray(data);
	}
    }

    // ********************************************************************************************************

     public static int[] mergesort(int[]data){
	
	if(data.length<2){ // already sorted!
	    return data;
	}
	
	int[]a=new int[data.length/2];
	int[]b=new int[data.length-a.length];
	
	for(int i = 0; i < a.length; i++){
	    a[i]=data[i];
	}
	for(int i = 0; i <b.length; i++){
	    b[i]=data[i+a.length];
	}

	// keep breaking down each side
	mergesort(a);
	mergesort(b);

	// actually merge them together
	merge(a,b,data);
	
	return data;
	
    }


    private static void merge(int[]aryA, int[]aryB, int[]list){
	
	int len = aryA.length+aryB.length;
	int a = 0;
	int b = 0;
	int count = 0;

	// while there are still things to compare...
	while(a<aryA.length && b<aryB.length){
	    if(lessThan(aryA[a],aryB[b])){
		list[count]=aryA[a];
		a++;
		count++;
	    }else{
		list[count]=aryB[b];
		b++;
		count++;
	    }
	}

	// copy over the rest of the lists 
	for(int i = a; i < aryA.length; i++){
	    list[count]=aryA[i];
	    count++;
	}
	for(int i = b; i < aryB.length; i++){
	    list[count]=aryB[i];
	    count++;
	}
	
    }
    
    private static boolean lessThan(int a, int b){
	return (a < b);
    }
    
    // ********************************************************************************************************

    public static int[] fillRandom(int[] ary){
	for (int i = 0; i < ary.length; i++){
	    ary[i] = (int)(Math.random() * 10000 / (Math.random() * 100));
	}
        return ary;
    }

    public static void swap(int[]a1, int i1, int i2){
	int hold = a1[i2];
	a1[i2] = a1[i1];
	a1[i1] = hold;
    }

    // ********************************************************************************************************

    public static String name(){
	return "6,Cheng,Nicole"; 
    }
    
    // ********************************************************************************************************
    
    public static void main(String[]args){

        int[]a = {1,-7,10,14,6,8,8,3};
	int[]ret = mergesort(a);
	// printArray(ret);
		
    }

}
