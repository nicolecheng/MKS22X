public class BSTree<T extends Comparable<T>>{

    private class Node{

	Node left, right;
	T data;

	private Node(T data){
	    this.data = data;
	}

	private T get(){
	    return data;
	}

	private void set(T val){
	    data = val;
	}

	private Node getLeft(){
	    return left;
	}

	private Node getRight(){
	    return right;
	}

	private int height(){ 
	    int h = 1;
	    if(left==null && right==null){
		return h;
	    }else if(left==null && right!=null){
		h+=right.height();
	    }else if(left!=null && right==null){
		h+=left.height();
	    }else{
		h+=max(left.height(),right.height());
	    }
	    return h;
	}

	private void add(T value){
	    if(value.compareTo(data)<0){
		if(left==null){
		    left = new Node(value);
		}else{
		    left.add(value);
		}
	    }else{
		if(right==null){
		    right = new Node(value);
		}else{
		    right.add(value);
		}
	    }
	}

	private String toString(){
	    return "";
	}

	private boolean contains(T value){
	    return false;
	}
	
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public getHeight(){
	//call the root's methods
	//check for empty first!
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
    }
    public String toString(){
	//check for empty before you do things with root.
	return "";
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	return false;
    }

}
