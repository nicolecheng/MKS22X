public class MergeSort{
    
    public static int[] mergesort(int[]data){
	if(data.length<2){return data;}
	int[]a=new int[data.length/2];
	int[]b=new int[data.length-a.length];
	for(int i = 0; i < data.length; i++){
	    if(i<a.length){
		a[i]=data[i];
	    }else{
		b[i-a.length]=data[i];
	    }
	}
	a=mergesort(a);
	b=mergesort(b);
	data=merge(a,b);
	return data;
    }


    public static int[] merge(int[]aryA, int[]aryB){
	int len = aryA.length+aryB.length;
	int[]list = new int[len];
	int a = 0;
	int b = 0;
	if(len==1){
	    if(aryA.length==1){
		list[0]=aryA[0];
		return list;
	    }else{
		list[0]=aryB[0];
		return list;
	    }
	}else if(len==2){
	    if(aryA.length==1){
		if(lessThan(aryA[0],aryB[0])){
		    list[0]=aryA[0];
		    list[1]=aryB[0];
		    return list;
		}else{
		    list[0]=aryB[0];
		    list[1]=aryA[0];
		}
	    }
	}
	while(a+b<len-2){
	    if(a==aryA.length){
		for(int r = b; r < aryB.length; r++){
		    list[a+b] = aryB[b];
		    b++;
		}
	    }else if(b==aryB.length){
		for(int r = a; r < aryA.length; r++){
		    list[a+b] = aryA[a];
		    a++;
		}
	    }else if(lessThan(aryA[a],aryB[b])){
		list[a+b]=aryA[a];
		a++;
	    }else{
		list[a+b]=aryB[b];
		b++;
	    }		
	}
	return list;
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

	int[]a = {1,7,10,14};
	int[]b = {-2,3,4,21,32,47};
	//MergeSort m = new MergeSort(a);
	//m.printList(a);
	//System.out.println();
	//m.printList(b);
	//System.out.println();
	MergeSort.printList(merge(a,b));
	int[]ret = MergeSort.mergesort(b);
	MergeSort.printList(ret);
    }
    
}
