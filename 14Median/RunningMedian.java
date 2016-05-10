public class RunningMedian extends MyHeap{

    MyHeap MIN, MAX;
    int oddMedian;

    // Create an empty running median set.
    public RunningMedian(){

    }

    // When empty: throws new NoSuchElementException()
    // Returns the median value
    public double getMedian(){
	if(oddMedian!=null){
	    return oddMedian;
	}else{
	    return (double)(MIN.peek()+MAX.peek())/2;
	}
    }

    // add to the "SmallValue" heap if  x < median, 
    // add to the "BigValue" heap otherwise. 
    // balance the two heaps so that their size differ by no more than 1. 
    public void add(Integer n){

    }

}
