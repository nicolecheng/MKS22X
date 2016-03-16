public class MyLinkedList{

    private static boolean DEBUG = true;
    
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
    
    public boolean add(int index, int value){
	if(index >= size){
	    return false;
	}else{
	    LNode current = start;
	    LNode next;
	    int hold;
	    int hold2;
	    for(int i = 0; i < index; i++){
		current = current.getNext();
		next = current.getNext();
	    }
	    hold = current.getValue();
	    current.setValue(value);
	    for(int i = index; i < size; i++){
	        if(current.getNext()!=null){
		    next = current.getNext();
		    hold2 = next.getValue();
		    current.setNext(hold);
		    current = current.getNext();
		    hold = hold2;
		}else{
		    add(hold);
		}
	    }
	    return true;
	}
    }
    
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
	if(index >= size){
	    return false;
	}else{
	    LNode current = start;
	    for(int i = 0; i < index; i++){
		current = current.getNext();
	    }
	    current.setValue(newValue);
	}	    
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

	public boolean setNext(int val){
	    next.setValue(val);
	    return true;
	}

	public int getValue(){
	    return value;
	}

	public boolean setValue(int value){
	    this.value = value;
	    return true;
	}
	
    }

    private static void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }
    
    private static void debug(int n){
	if(DEBUG){
	    System.out.println(n);
	}
    }
    
    public static void main(String[]args){
	MyLinkedList m = new MyLinkedList();
	m.add(8); // [8]
	debug(m.size);
	m.add(3); // [8,3]
	debug(m.size);
	m.add(5); // [8,3,5]
	debug(m.size);
	m.set(0,1); // [1,3,5]
	debug(m.size);
	m.add(7); // [1,3,5,7]
	debug(m.size);
	m.add(3,-1); // [1,3,5,-1,7]
	debug(m.size);
	m.add(0,2); // [2,1,3,5,-1,7]
	debug(m.size);
	System.out.println(m);
    }
    
}
