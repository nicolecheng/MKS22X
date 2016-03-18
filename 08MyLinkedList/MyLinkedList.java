public class MyLinkedList{

    private static boolean DEBUG = false;
    
    LNode start;
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

    public int remove(int index){
	try{ // catch exception if index >= size
	    int num;
	    LNode hold;
	    LNode current = start;
	    for(int i = 0; i < index; i++){
		current = current.getNext();
	    }
	    num = current.getValue();
	    for(int i = index; i < size-1; i++){
		hold = current.getNext();
		current.setValue(hold.getValue());
		current = current.getNext();
	    }
	    size--;
	    return num;
	}catch(Exception e){
	    System.out.println("index out of bounds in remove(index)");
	}
	return -1;
    }

    public boolean add(int index, int value){
	if(index > size){
	    return false;
	}else if(index==size){
	    add(value);
	}else{
	    // create new node, pointing to start
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
	}
	return true;
    }

    public boolean add(int value){ // Make this O(1) by keeping track of the last node
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
    
    public static void main(String[]args){
	
	
	MyLinkedList m = new MyLinkedList();
	m.add(8); // [8]
	m.add(3); // [8,3]

	//m.remove(3); // catch exception
	//System.out.println(m);
	
	m.add(5); // [8,3,5]
	m.set(0,1); // [1,3,5]
	m.add(7); // [1,3,5,7]
	m.add(3,-1); // [1,3,5,-1,7]
	m.add(0,2); // [2,1,3,5,-1,7]
	// debug(m.get(3)); // 5
	m.add(6,10); // [2,1,3,5,-1,7,10]
	// debug(m.indexOf(3)); // 2
	// debug(m.indexOf(4)); // -1
	m.remove(4); // [2,1,3,5,7,10]
	m.remove(5);// [2,1,3,5,7]
	System.out.println(m);
	

    }
    
}