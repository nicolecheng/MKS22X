import java.util.*;

public class MyDeque<T>{

    T[]data;
    int start,end; // start and end indices
    int size;

    @SuppressWarnings("unchecked")	    
    public MyDeque(){
	data = (T[]) new Object[10];
	start = 0;
	end = 0;
	size = 0;
    }
    

    // 0b. You need a private method to grow the array and copy over the values.
    @SuppressWarnings("unchecked")	    
    private void grow(){
	T[]hold = (T[]) new Object[size*2];
	int m = 0;
	for(int i = 0; i < size; i++){
	    if(start+i<size){
		hold[i] = data[start+i];
		m++;
	    }else{
		hold[i] = data[i-m];
	    }
	}
	data = hold;
	start = 0;
	end = size;
	size *= 2;
    }

    private boolean isFull(){
	if(start == end){
	    return false;
	}else if(end > start){
	    if(start > 0 || end < size){
		return true;
	    }else{
		return false;
	    }
	}else{
	    return (start-end > 1);
	}
    }

    
    // 1. void addFirst(T value),  2. void addLast(T value)
    // -When the array is full, re-size, then add. 
    // -No exceptions are required since you will re-size.

    public void addFirst(T value){
	if(isFull()){
	    grow();
	}
	if(start==0){
	    start = size-1;
	}else{
	    start--;
	}
	data[start] = value;
	size++;
    }

    public void addLast(T value){
	if(isFull()){
	    grow();
	}
	if(end==size-1){
	    end = 0;
	}else{
	    end++;
	}
	data[end] = value;
	size++;
    }        

    
    // 3. T removeFirst(), 4. T removeLast()  
    // -NoSuchElementException is thrown when there are no elements.

    public void removeFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}else{
	    if(start==size-1){
		start = 0;
	    }else{
		start++;
	    }
	    size--;
	}
    }

    public void removeLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}else{
	    if(end==0){
		end = size-1;
	    }else{
		end--;
	    }
	    size--;
	}
    }

    
    // 5. T getFirst(), 6. T getLast()
    // -NoSuchElementException is thrown when there are no elements. 

    public T getFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public T getLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[end];
    }

    public String toString(){
	String s = "";
	int m = 0;
	for(int i = 0; i < size; i++){
	    if(start+i<size){
		s += data[start+i];
		m++;
	    }else{
		s += data[i-m];
	    }
	}
	return s;
    }
    
    public static void main(String[]args){
	MyDeque<Integer> m = new MyDeque<Integer>();
	//System.out.println(m);
    }
    
}
