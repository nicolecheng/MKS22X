import java.util.*;

public class Driver{
    
    public static void main(String[]args){
	MyLinkedList m = new MyLinkedList();
	ArrayList<Integer> n = new ArrayList<Integer>();
	
	long start,end;

	// add(int val)
	start = System.currentTimeMillis();
        //code to test here on ArrayList n
	for(int i = 0; i < 100000; i++){
	    n.add(i);
	}
	end = System.currentTimeMillis();
	System.out.println("add(i) Time: " + (end-start)/1000.0 + " seconds for ArrayList");
	start = System.currentTimeMillis();
        //same code to test here on linked list m
	for(int i = 0; i < 100000; i++){
	    m.add(i);
	}
	end = System.currentTimeMillis();
	System.out.println("add(i) Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	// get(int ind)
	start = System.currentTimeMillis();
        //code to test here on ArrayList n
	for(int i = 0; i < 100000; i++){
	    n.get(i);
	}
	end = System.currentTimeMillis();
	System.out.println("get(i) Time: " + (end-start)/1000.0 + " seconds for ArrayList");
	start = System.currentTimeMillis();
        //same code to test here on linked list m
	for(int i = 0; i < 100000; i++){
	    m.get(i);
	}
	end = System.currentTimeMillis();
	System.out.println("get(i) Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	// set(int ind, int newVal)
	start = System.currentTimeMillis();
        //code to test here on ArrayList n
	int k = 100000;
	for(int i = 0; i < 100000; i++){
	    n.set(i,k);
	    k++;
	}
	end = System.currentTimeMillis();
	System.out.println("set(i,v) Time: " + (end-start)/1000.0 + " seconds for ArrayList");
	start = System.currentTimeMillis();
        //same code to test here on linked list m
	k = 100000;
	for(int i = 0; i < 100000; i++){
	    m.set(i,k);
	    k++;
	}
	end = System.currentTimeMillis();
	System.out.println("set(i,v) Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	// remove(int ind)
	start = System.currentTimeMillis();
        //code to test here on ArrayList n
	for(int i = 0; i < 50000; i++){
	    n.remove(i);
	}
	end = System.currentTimeMillis();
	System.out.println("remove(i) Time: " + (end-start)/1000.0 + " seconds for ArrayList");
	start = System.currentTimeMillis();
        //same code to test here on linked list m
	for(int i = 0; i < 50000; i++){
	    m.remove(i);
	}
	end = System.currentTimeMillis();
	System.out.println("remove(i) Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	// add(int ind, int val)
	start = System.currentTimeMillis();
        //code to test here on ArrayList n
	for(int i = 0; i < 100000; i++){
	    k = (int)Math.random()*1000;
	    n.add(i,k);
	}
	end = System.currentTimeMillis();
	System.out.println("add(i,v) Time: " + (end-start)/1000.0 + " seconds for ArrayList");
	start = System.currentTimeMillis();
        //same code to test here on linked list m
	for(int i = 0; i < 100000; i++){
	    k = (int)Math.random()*1000;
	    m.add(i,k);
	}
	end = System.currentTimeMillis();
	System.out.println("add(i,v) Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	// indexOf(int val)
	start = System.currentTimeMillis();
        //code to test here on ArrayList n
	for(int i = 0; i < 100000; i++){
	    n.indexOf(i);
	}
	end = System.currentTimeMillis();
	System.out.println("indexOf(v) Time: " + (end-start)/1000.0 + " seconds for ArrayList");
	start = System.currentTimeMillis();
        //same code to test here on linked list m
	for(int i = 0; i < 100000; i++){
	    m.indexOf(i);
	}
	end = System.currentTimeMillis();
	System.out.println("indexOf(v) Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	// size()
	start = System.currentTimeMillis();
        //code to test here on ArrayList n
	n.size();
	end = System.currentTimeMillis();
	System.out.println("size() Time: " + (end-start)/1000.0 + " seconds for ArrayList");

	start = System.currentTimeMillis();
        //same code to test here on linked list m
        m.size();
	end = System.currentTimeMillis();
	System.out.println("size() Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

    }
    
}
