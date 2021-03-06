import java.util.*;

public class RunningMedian{

    MyHeap<Integer> MIN, MAX;
    int oddMedian;

    // Create an empty running median set.
    public RunningMedian(){
        MIN = new MyHeap<Integer>();
	MAX = new MyHeap<Integer>(true);
	oddMedian = 0;
    }

    // When empty: throws new NoSuchElementException()
    // Returns the median value
    public double getMedian(){
	if(MIN.size()==0 && MAX.size()==0){
	    throw new NoSuchElementException();
	}
	if(MIN.size()!=MAX.size()){
	    return oddMedian;
	}else{
	    return (double)((int)MIN.peek()+(int)MAX.peek())/2;
	}
    }

    // add to the "SmallValue" heap if  x < median, 
    // add to the "BigValue" heap otherwise. 
    // balance the two heaps so that their size differ by no more than 1. 
    public void add(Integer n){
	if(MIN.size()>0 && MAX.size()>0 && n < getMedian()){
	    MAX.add(n);
	}else{
	    MIN.add(n);
	    if(MIN.size()==1){
		oddMedian=n;
	    }
	}
	while(MAX.size()-MIN.size() > 1){
	    Integer hold = (Integer)MAX.delete();
	    MIN.add(hold);
	}
	while(MIN.size()-MAX.size() > 1){
	    Integer hold = (Integer)MIN.delete();
	    MAX.add(hold);
	}
	if(MIN.size()>MAX.size()){
	    oddMedian = (int)MIN.peek();
	}else if(MAX.size()>MIN.size()){
	    oddMedian = (int)MAX.peek();
	}
    }

    public String toString() {
	return MAX.toString()+" "+MIN.toString();
    }

    public static void main(String[] args) {
	RunningMedian m = new RunningMedian();
	m.add(0);
	m.add(3);
	m.add(3);
	m.add(4);
	m.add(-1);
	m.add(7);
	m.add(2);
	m.add(12);
	m.add(10);
	m.add(8);
	System.out.println(m);
	System.out.println(m.getMedian());
	m.add(5);
	System.out.println(m);
	System.out.println(m.getMedian());
    }

}
