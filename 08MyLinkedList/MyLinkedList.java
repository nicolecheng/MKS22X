public class MyLinkedList{
    
    LNode start;
    int size;
    
    public MyLinkedList(){
	size = 0;
    }
    
    public boolean add(int value){
	if(size==0){
	    start = new LNode(value);
	}else{
	    LNode next = new LNode(value);
	    LNode current = start;
	    while(current.getNext()!=null){
		current = current.getNext();
	    }
		current.setNext(next);
	}
	size++;
	return true;
    }
    /*
    public boolean add(int index, int value){
	size++;
	return true;
    }

    */
    
    public String toString(){
	LNode current = start;
	String s="[";
	if(size>0){
	    s+=current.getValue()+",";
	}
        while(current.getNext() != null){
	    current = current.getNext();
	    s += current.getValue();
	    if(current.getNext()!=null){
		s+= ",";
	    }
	}
	return s + "]";
    }
    


    public boolean set(int index, int newValue){
	return true;
    }
    
    private class LNode{

	LNode next;
	int value;

	public LNode(int value){
	    this.value = value;
	}

	public LNode getNext(){
	    return next;
	}

	public boolean setNext(LNode next){
	    this.next = next;
	    return true;
	}

	public int getValue(){
	    return value;
	}

	
	
    }

    public static void main(String[]args){
	MyLinkedList m = new MyLinkedList();
	m.add(8);
	m.add(3);
	System.out.println(m);
    }
    
}
