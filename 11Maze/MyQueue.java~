import java.util.*;

public class MyQueue<T> extends MyLinkedList<T>{

    /**
     * Adds the given item to the rear of the queue.
     */
    public void enqueue(T item){
	add(item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue(){
	if(isEmpty()){
	    throw new NoSuchElementException("no existe");
	}else{
	    return remove(0);
	}
    }
	    

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if(isEmpty()){
	    throw new NoSuchElementException("peekaboo not found");
	}else{
	    return get(0);
	}
    }

    /**
     * Returns the number of items currently in the queue.
     */
    public int size(){
	return super.size(); 
    }

    /**
     * Returns whether the queue is empty or not.
     */
    public boolean isEmpty(){
	return (size()==0);
    }

    /*
    public static void main(String[]args){

	MyQueue<Integer> s = new MyQueue<Integer>();
	System.out.println(s.isEmpty());
	s.enqueue(7);
	s.enqueue(9);	
	s.enqueue(-1);
	System.out.println(s);
	s.dequeue();
	s.enqueue(2);
	System.out.println(s);
	System.out.println(s.peek());

    }
    */

}
