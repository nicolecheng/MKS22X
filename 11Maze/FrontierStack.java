public class FrontierStack<T> implements Frontier<T>{

    MyStack<T>frontier;

    public FrontierStack(){
	frontier = new MyStack<T>();
    }
	
    public void add(T element){
	frontier.push(element);
    }
    
    public T next(){
	return frontier.pop();
    }
    
    public boolean hasNext(){
	return !frontier.isEmpty();
    }

    /*
    public static void main(String[]args){
	FrontierStack<Integer> m = new FrontierStack<Integer>();
	System.out.println(m.hasNext());
	m.add(7);
	System.out.println(m.hasNext());
	System.out.println(m.next());
	System.out.println(m.hasNext());
    }
    */
    
}
