import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private int size;
    private T[] data;
    private boolean isMax;

    public MyHeap(){
	T[]ary=new T[0]ary;
	MyHeap(ary);
    }

    public MyHeap(T[]x){
	size = x.length+1;
	data = new T[size];
	for(int i = 1; i < size; i++){
	    data[i]=x[i-1];
	}
    }

    private void pushDown(int k){
	//check maxHeap or minHeap
	if(data[k].compareTo(data[k*2])>0){
	    swap(k,k*2);
	}else if(data[k].compareTo(data[k*2+1])<0){
	    swap(k,k*2+1);
	}
    }

    private void swap(int a, int b){
	T hold = data[a];
	data[a]=data[b];
	data[b]=hold;
    }

    private void pushUp(int k){
	//check maxHeap or minHeap
	if(data[k].compareTo(data[k/2])>0){
	    swap(k,k/2);
	}
    }

    private void heapify(){
	
    }

    public T delete(){}

    public void add(T x){}

    private void doubleSize(){}

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

	}
