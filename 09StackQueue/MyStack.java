import java.util.*;

public class MyStack<T> extends MyLinkedList<T>{
    
    // private MyLinkedList<T> data;

    /**
     * Adds the given item to the top of the stack.
     */
    public void push(T item){
	add(0,item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop(){
	if(isEmpty()){
	    throw new NoSuchElementException("no existe");
	}else{
	    return remove(0);
	}
    }

    /**
     * Returns the top item from the stack without popping it.
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
     * Returns the number of items currently in the stack.
     */
    public int size(){
	return super.size(); // heh. supersize me. 
    }

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty(){
	return (size()==0);
    }
    
    /* 
    public static void main(String[]args){

	MyStack<Integer> s = new MyStack<Integer>();
	System.out.println(s.isEmpty());
	s.push(7);
	s.push(9);	
	s.push(-1);
	System.out.println(s);
	s.pop();
	s.push(2);
	System.out.println(s);
	System.out.println(s.peek());

    }
    */
}
