import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private int size;
    private T[] data;
    private boolean isMax;

    public MyHeap(){
        size = 0;
	data = (T[]) new Comparable[size+1];
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

    //do this last
    public MyHeap(boolean isMax){
	this();
	this.isMax = isMax;
    }
    public MyHeap(T[] array, boolean isMax){
	this(array);
	this.isMax = isMax;
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
	    while((ok(k*2) && data[k].compareTo(data[k*2])<0) ||
		  (ok(k*2+1) && data[k].compareTo(data[k*2+1])<0)){
		if(data[k*2+1].compareTo(data[k*2])>0){
		    swap(k,k*2+1);
		    k = k*2+1;
		}else{
		    swap(k,k*2);
		    k = k * 2;
		}
	    }
	}else{
	    while((ok(k*2) && data[k].compareTo(data[k*2])>0) ||
		  (ok(k*2+1) && data[k].compareTo(data[k*2+1])>0)){
		if(data[k*2+1].compareTo(data[k*2])>0){
		    swap(k,k*2);
		    k *= 2;
		}else{
		    swap(k,k*2+1);
		    k = k*2+1;
		}
	    }
	}
    }

    public boolean ok(int ind){
	if(ind <= size && ind > 0 && data[ind]!=null){
	    return true;
	}
	return false;
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
	    if(ok(k/2) && data[k].compareTo(data[k/2])>0){
		swap(k,k/2);
	        pushUp(k/2);
	    }
	}else{
	    while(ok(k/2) && data[k].compareTo(data[k/2])<0){
		swap(k,k/2);
		k = k/2;
	    }
	}
    }

    private void heapify(){
	for(int i = size/2; i > 0; i--){
	    pushDown(i);
	}
    }

    public T delete(){ // remove the root
	T hold = data[1];
	data[1] = data[size];
	data[size] = null;
	pushDown(1);
	size--;
	return hold;
    }

    public T remove(){ // remove the root
	T hold = data[1];
	data[1] = data[size];
	data[size] = null;
	pushDown(1);
	size--;
	return hold;
    }


    public void add(T x){
	size++;
	if(size>=data.length){
	    doubleSize();
	}
	data[size] = x;
	pushUp(size);
    }

    private void doubleSize(){
	T[]a = (T[]) new Comparable[size*2-1];
	for(int i = 0; i < size; i++){
	    a[i] = data[i];
	}
	data = a;
    }

    public String toString(){
	String s = "[";
	for(int i = 1; i <= size; i++){
	    s+=data[i];
	    if(i < size){
		s+=", ";
	    }
	}
	return s+"]";
    }

    /*
    public static void main(String[]args){

	Integer[]a = new Integer[5];
	for(int i = 0;i < a.length; i++){
	    a[i] = i;
	}
	MyHeap<Integer> m = new MyHeap<Integer>(a);
	System.out.println(m.isMax); // false
	System.out.println(m); // [0, 1, 2, 3, 4]
	m.heapify();
	System.out.println(m);
	m.add(6);
	m.add(-6);
	m.add(7);
	m.add(2);
	m.add(4);
	System.out.println(m);
	m.remove();
	System.out.println(m);

    }
    */
}
