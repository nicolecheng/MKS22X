public class FrontierQueue<T> extends MyQueue<T> implements Frontier<T>{

    MyQueue<T>frontier = new MyQueue<T>();
    
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
