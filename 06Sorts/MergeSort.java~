public class MergeSort{
    
    int[]data;
    
    public MergeSort(int[]data){
	this.data = data;
    }

    public int[] solve(){//int[]data){
        int[]hold=new int[data.length];
	int count=1;
	int start=0;
	for(int i = 0; i < data.length; i++){
	    int[]a=new int[count];
	    int[]b=new int[count];
	    int[]c=new int[count*2];
	    for(int m = 0; m < count; m++){
		a[m]=data[m+start];
		b[m]=data[m+start+count];
	    }
	    c=merge(a,b);
	    for(int n = 0; n < a.length+b.length; n++){
		hold[n+start]=c[n];
	    }
	    //data=hold;
	    start+=count*2;
	    if(start==data.length){
		start=0;
		count*=2;
	    }
	    //count++;
	}
	return data;
    }

    public int[] merge(int[]aryA, int[]aryB){
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


    public boolean lessThan(int a, int b){
	return (a < b);
    }


    /*
      Preconditions:
      data.length >= 2
      the elements of data are in ascending order (sorted)
      startA <= endA < startB <= endB
      startA >= 0
      endB < data.length
    */
    
    //    void merge(int[]data, int startA, endA, startB, endB)

    public void printList(int[]j){
	System.out.print("{");
	for(int i = 0; i < j.length-1; i++){
	    System.out.print(j[i]+",");
	}
	System.out.print(j[j.length-1]+"}");
    }

    public void printList(){
	System.out.print("{");
	for(int i = 0; i < data.length-1; i++){
	    System.out.print(data[i]+",");
	}
	System.out.print(data[data.length-1]+"}");
    }
    
    public static void main(String[]args){

	int[]a = {1,7,10,14};
	int[]b = {-2,3,4,21,32,47};
	MergeSort m = new MergeSort(a);
	m.printList(a);
	System.out.println();
	//m.printList(b);
	System.out.println();
	m.printList(m.solve());//merge(a,b));
	
    }
    
}
