public class FrontierQueue<T> implements Frontier<T>{

    MyQueue<T>frontier;

    public FrontierQueue(){
	frontier = new MyQueue<T>();
    }
    
    public void add(T element){
	frontier.enqueue(element);
    }
    
    public T next(){
	return frontier.dequeue();
    }
    
    public boolean hasNext(){
	return !frontier.isEmpty();
    }
    
}
