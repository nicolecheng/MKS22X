public class MyLinkedList{

    private static boolean DEBUG = false;
    
    LNode start;
    LNode end;
    int size;
    
    public MyLinkedList(){
	size = 0;
    }

    public int get(int index){ // O(index)
	try{ // catch exception if index > = size
	    LNode current = start;
	    for(int i = 0; i < index; i++){
		current = current.getNext();
	    }
	    return current.getValue();
	}catch(Exception e){
	    System.out.println("index out of bounds in get(index)");
	}
	return -1;
    }

    public boolean set(int index, int newValue){ // O(index)
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

    public int size(){ // O(1), provided there's a size variable
	return size;
    }

    public int remove(int index){ // O(i) bc you don't need to shift it -- just repoint
	try{ // catch exception if index >= size
	    LNode current = start;
	    if(index==0){
		int num = start.getValue();
		current = current.getNext();
		start = current;
		size--;
		return num;
	    }else{
		for(int i = 0; i < index-1; i++){
		    current = current.getNext();
		}
		int num = current.getNext().getValue();
		if(index<size-1){
		    LNode hold = current.getNext().getNext();
		    current.setNext(hold);
		}
		size--;
		return num;
	    }
	}catch(Exception e){
	    System.out.println("index out of bounds in remove(index)");
	}
	return -1;
    }

    // modifying from the front -> O(1); modifying from the back -> O(size)
    public boolean add(int index, int value){
	
	if(index > size){
	    return false;
	}else if(index==size){
	    add(value);
	}else if(index==0){
	    LNode current = start;
	    LNode hold = new LNode(value);
	    start = hold;
	    start.setNext(current);
	    size++;
	}else{ // create new node, pointing to start
	    LNode current = start;
	    for(int i = 0; i < index-1; i++){
		current = current.getNext();
	    }
	    LNode next = new LNode(value);
	    LNode hold = current.getNext();
	    current.setNext(next);
	    next.setNext(hold);
	    size++;
	}
	return true;
    }

    public boolean add(int value){ // Make this O(1) by keeping track of the last node
	if(size==0){
	    start = new LNode(value);
	    end = start;
	}else{
	    LNode next = new LNode(value);
	    end.setNext(next);
	    end = end.getNext();
	}
	size++;
	return true;
    }

    public int indexOf(int value){ // O(n)
	int ind = 0;
	LNode current = start;
	while(current!=null && current.getNext()!=null){
	    if(current.getValue()==value){
		return ind;
	    }else{
		current = current.getNext();
		ind++;
	    }
	}
	return -1;
    }       
    
    public String toString(){
	LNode current = start;
	String s="[";
	if(size>0){s+=current.getValue()+",";}
	int n = 1;
	while(n < size && current.getNext() != null){
	    current = current.getNext();
	    s += current.getValue();
	    n++;
	    if(current.getNext()!=null && n < size){s+= ",";}
	}
	return s + "]";
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

    /*
    
    public static void main(String[]args){
	
	
	MyLinkedList m = new MyLinkedList();
	m.add(8); // [8]
	m.add(3); // [8,3]
	m.add(5); // [8,3,5]
	m.set(0,1); // [1,3,5]
	m.add(7); // [1,3,5,7]
	m.add(3,-1); // [1,3,5,-1,7]
	m.add(0,2); // [2,1,3,5,-1,7]
	System.out.println(m);
	m.remove(1); // [2,3,5,-1,7]
	m.add(5,10); // [2,3,5,-1,7,10]
	m.remove(4); // [2,3,5,-1,10]
	m.remove(4);// [2,3,5,-1]
	System.out.println(m);
	
    }

    */
    
}
