// not actually /my/ linked list
import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
    
    private class LNode{
	
	private T value;
	private LNode next;
	private LNode prev;
	
	public LNode(T v){
	    value = v;
	}
	
	public T getValue(){
	    return value;
	}
	
	public LNode getNext(){
	    return next;
	}

	public LNode getPrev(){
	    return prev;
	}
	
	public T setValue(T v){
	    T old = value;
	    value = v;
	    return old;
	}
	
	public void setNext(LNode n){
	    next = n;
	}

	public void setPrev(LNode n){
	    prev = n;
	}
	
	public String toString(){
	    return value.toString();
	}
	
    }

    LNode head;
    LNode tail;
    int size;
    
    public Iterator<T> iterator(){
	//This uses an anonymous class! You don't need to know this.
	return new Iterator<T>()
	{
	    private LNode current = head;

	    public boolean hasNext(){
		return current != null;
	    }
	    public T next(){
		if(!hasNext()){
		    throw new NoSuchElementException();
		}
		T value = current.getValue();
		current = current.getNext();
		return value;
	    }
	    public void remove(){
		throw new UnsupportedOperationException();
	    }
	};
    }
    
    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p!=null){
	    ans += p.getValue();
	    if(p.getNext()!=null){
		ans += ", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }
   
    public String toString(boolean b){
	return toString()+" head: "+head +", tail: "+tail;
    }
    
    private LNode getNth(int index){
	//check bounds before calling this method!
	LNode temp = head;
	while(index > 0){
	    temp = temp.getNext();
	    index --;
	}
	return temp;
    }
    
    public boolean add(T value){
	if(head == null){
	    head = new LNode(value);
	    tail = head;
	}else{
	    tail.setNext(new LNode(value));
	    LNode temp = tail.getNext();
	    temp.setPrev(tail);
	    tail = temp;
	}
	size++;
	return true;
    }
    
    public T remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
	}
	LNode temp;
	if(index == 0){
	    temp = head;
	    head = head.getNext();
	    size--;
	    if(head == null){
		tail = null;
	    }
	    return temp.getValue();
	}else{
	    LNode p = getNth(index-1);
	    temp = p.getNext();
	    if(tail == temp){
		tail = p;
	    }
	    p.setNext(p.getNext().getNext());
	    temp = p.getNext();
	    temp.setPrev(p);
	    size --;
	    return temp.getValue();
	}
    }
    
    public boolean add(int index, T value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	LNode temp = new LNode(value); 
	if(index==size){
	    return add(value);
	}else if(index == 0){
	    temp.setNext(head);
	    head.setPrev(temp);
	    head = temp;
	    //if(size==0){
	    //	tail = head;
	    //}
	}else{ 
	    LNode p = getNth(index-1);
	    temp.setNext(p.getNext());
	    temp.setPrev(p);
	    temp.getNext().setPrev(temp);
	    p.setNext(temp);
	    //if(tail.getNext() != null){
	    //	tail=tail.getNext();
	    //}
	}
	size++;
	return true;
    }
    
    public int size(){
	return size;
    }
    
    public T get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).getValue();
    }

    public T set(int index, T newValue){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).setValue(newValue);
    }

    public int indexOf(T target){
	LNode temp = head;
	int index = 0;
	while(temp != null){
	    if(temp.getValue().equals(target)){
		return index;
	    }
	    index++;
	    temp = temp.getNext();
	}
	return -1;
    }

    /*
    public void test(int ind){ // testing doubly linked features
	LNode node = getNth(ind);
	System.out.println(node.getPrev().getValue()); // prints val of prev node
    }

    public static void main(String[]args){
	MyLinkedList<Integer> m = new MyLinkedList<Integer>();
	m.add(8);
	m.add(3);
	m.add(9);
	m.add(2);
	m.add(-1);
	m.add(5);
	// 8,3,9,2,-1,5
	m.test(3); // 9
	m.test(2); // 3
	m.test(1); // 8
    }
    */

}
