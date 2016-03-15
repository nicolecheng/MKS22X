public class MyLinkedList{

    LNode start;
    int size;
    /*
    
    public MyLinkedList(){
	size = 0;
	start = new LNode();
	LNode current = start;
    }

    public int size(){
	int ret = 0;
	while(current.getNext() != null){
	    ret++;
	    current = current.getNext();
	}
	return ret;
    }


    public boolean add(int value){
	if(size==0){
	    set(0,value);
	}else{
	    while(current.next()!=null){
		current = current.getNext();
	    }
		current.setNext(value);
	}
	size++;
	return true;
    }

    public boolean add(int index, int value){
	size++;
	return true;
    }


    public String toString(){
	String s="[";
	for(int i = 0; i < size-1; i++){
	    s+=start.get(i)+",";
	}
	if(size>0){
	    s+=start.get(size-1);
	}
	return s + "]";
    }
    */
    private class LNode{

	LNode next;
	int value;

	public LNode(int value){
	    this.value = value;
	}

	public boolean getNext(){
	    
	}

    }

    public static void main(String[]args){
	LNode n = new LNode();
    }
    
}
