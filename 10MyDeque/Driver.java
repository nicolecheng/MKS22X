// s/o to those who shared their ideas and code on the google classroom thread

import java.util.*;

public class Driver{
    
    public static void main(String[]args){

	MyDeque<Integer> d = new MyDeque<Integer>();
	ArrayDeque<Integer> a = new ArrayDeque<Integer>();

	// Add to the head and to the tail
        
	for (int i = 0; i < 10000; i++) {
	    Integer n = (int)(Math.random()*10000);
	    d.addFirst(n);
	    a.addFirst(n);
	}
		
	for (int i = 0; i < 10000; i++) {
	    Integer n = (int)(Math.random()*10000);
	    d.addLast(n);
	    a.addLast(n);
	}

	/*
	//for(int i = 0; i < 10000; i++){
	for(int i = 0; i < 30; i++){
	    d.addFirst(i);
	    a.addFirst(i);
	}
	*/

	for (int i = 0; i < 5000; i++) {
	//for(int i = 0; i < 15; i++){
	    
	    if (!d.getFirst().equals(a.getFirst())) {
		d.debug();
		System.out.println(d.getFirst()+"\t"+a.getFirst());
		System.out.println("addFirst() failed at: " + i);
		System.exit(0);
	    }
			
	    if (!d.getLast().equals(a.getLast())) {
		System.out.println(d.toString1());
		d.debug();			    
		System.out.println(d);
		System.out.println(a);
		System.out.println(d.getLast()+"\t"+a.getLast());
		System.out.println("addLast() failed at: " + i);
		System.exit(0);
	    }

	    if (!d.removeFirst().equals(a.removeFirst())) {
		System.out.println("removeFirst() failed at: " + i);
		System.exit(0);
	    }

	    if(d.size()!=a.size()){
		System.out.println("unequal sizes -- something went wrong in removeFirst()");
		System.out.println(d);
		d.debug();
		System.exit(0);
	    }

	    if (!d.removeLast().equals(a.removeLast())) {
		System.out.println("removeLast() failed at: " + i);
		System.exit(0);
	    }

	    if(d.size()!=a.size()){
		System.out.println("unequal sizes -- something went wrong in removeLast()");
		System.out.println(d);
		d.debug();
		System.exit(0);
	    }
	    
	    //System.out.println(i);
	}

	System.out.println("HURRAH!");
    }

}
