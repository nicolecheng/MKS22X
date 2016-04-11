public class FrontierStack<T> extends MyStack<T> implements Frontier<T>{

    MyStack<T>frontier = new MyStack<T>(); // [1,2,3,4,5,6]
    
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
