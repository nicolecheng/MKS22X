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
		h+=Math.max(left.height(),right.height());
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

	public String toString(){
	    return "";
	}

	private boolean contains(T value){
	    if(data.equals(value)){
		return true;
	    }else{
		if(left==null && right==null){
		    return false;
		}else if(left==null && right!=null){
		    return right.contains(value);
		}//etc
	    return false;
	}
	
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	//call the root's methods
	//check for empty first!
	if(root==null){
	    return 0;
	}
	return root.height();
    }

    public void add(T value){
	if(root==null){}
	//check for empty before you do things with root.
    }

    public String toString(){
	if(root==null){}
	//check for empty before you do things with root.
	return "";
    }

    public boolean contains(T value){
	if(root==null){}
	//check for empty before you do things with root.
	return false;
    }

}
