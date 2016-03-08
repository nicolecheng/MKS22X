public class MergeSort{
    
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


    public static void merge(int[]aryA, int[]aryB, int[]list){
	
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
    
    public static boolean lessThan(int a, int b){
	return (a < b);
    }

    public static void printList(int[]j){
	System.out.print("{");
	if(j.length>0){
	    for(int i = 0; i < j.length-1; i++){
		System.out.print(j[i]+",");
	    }
	    System.out.print(j[j.length-1]);
	}
	System.out.print("}");
    }
    
    public static void main(String[]args){

	int[]a = {1,-7,10,14,6,8,8,3};
	int[]b = {-2,3,54,21,9,0,32,47};
	int[]ret = MergeSort.mergesort(a);
	MergeSort.printList(ret);
    }
    
}
