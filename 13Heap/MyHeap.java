import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private int size;
    private T[] data;
    private boolean isMax;

    public MyHeap(){
        size = 0;
	data = (T[]) new Comparable(size+1);
	//data[0] = 0;
    }
    
    public MyHeap(T[]x){
	size = x.length;
	data = (T[]) new Comparable[size+1]; //data = new T[size];
	for(int i = 0; i < size; i++){
	    data[i+1]=x[i];
	}
	//data[0]=size;
    }

    private void swap(int a, int b){
	T hold = data[a];
	data[a]=data[b];
	data[b]=hold;
    }

    /**pushDown
      precondition: datas[k]'s children are valid heaps
      postconditions:-the element at index k has been 
                     shifted to the correct spot.
                     -data[k] and is a valid heap
   **/

    private void pushDown(int k){
	if(isMax){
	    while((data[k*2]!=null && data[k].compareTo(data[k*2])<0) ||
		  (data[k*2+1]!=null && data[k].compareTo(data[k*2+1])<0)){
		if(data[k*2+1].compareTo(data[k*2])>0){
		    swap(k,k*2+1);
		}else{
		    swap(k,k*2);
		}
	    }
	}else{
	    while((data[k*2]!=null && data[k].compareTo(data[k*2])>0) ||
		  (data[k*2+1]!=null && data[k].compareTo(data[k*2+1])>0)){
		if(data[k*2+1].compareTo(data[k*2])>0){
		    swap(k,k*2);
		}else{
		    swap(k,k*2+1);
		}
	    }
    }

    /**pushUp
       precondition: data is a heap with at most one item
       out of place (element at k)
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data is a valid heap
    **/
    
    private void pushUp(int k){
	if(isMax){
	    while(data[k].compareTo(data[k/2])>0){
		swap(k,k/2);
		k /= 2;
	    }
	}else{
	    while(data[k].compareTo(data[k/2]<0)){
		    swap(k,k/2);
	    }
	}
    }

    private void heapify(){
	
    }

    public T delete(){}

    public void add(T x){
	size++;
	if(size>=data.length){
	    doubleSize();
	}
	data[size] = x;
	pushUp(size);
    }

    private void doubleSize(){
	T[]a = (T[]) new Comparable[size*2+1];
	for(int i = 0; i <= size; i++){
	    a[i] = data[i];
	}
	data = a;
    }

    public String toString(){
	String s = "[";
	for(int i = 1; i < size; i++){
	    s+=data[i];
	    if(i < size-1){
		s+=", ";
	    }
	}
	return s;
    }

    //do this last
    public MyHeap(boolean isMax){}
    public MyHeap(T[] array, boolean isMax){}

    public static void main(String[]args){

        Integer[]a = new Integer[5];
	for(int i =0;i<a.length;i++){
	    a[i] = i;
	}
	MyHeap<Integer> m = new MyHeap<Integer>(a);

    }

}
