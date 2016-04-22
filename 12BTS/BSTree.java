public class BSTree<T extends Comparable<T>>{

    private class Node{

	Node left, right;
	T data;

	public Node(T data){
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

	public void add(T value){
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

	//public String toString(){
	//    return "";
	//}

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
	    if(root==null){
		root = new Node(value);
	    }else{
		root.add(value);
	    }
	}

	public String toString(){
	    String s = "";
	    if(root==null){
		return "";
	    }else{
	       return toString(root); 
	    }
	}

	public String toString(Node start){
	    String s = " "+start.get();
	    if(start.getLeft()==null){
		s+=" _";
	    }else{
	        s+=toString(start.getLeft());
	    }
	    if(start.getRight()==null){
	        s+=" _";
	    }else{
		s+=toString(start.getRight());
	    }
	    return s;
	}
	/*
	public boolean contains(T value){
	    if(root==null){}
	    //check for empty before you do things with root.
	    return false;
	}
	*/

    public static void main(String[] args) {
	BSTree<String> t = new BSTree<String>();
		
	t.add("b");
	t.add("a");
	t.add("c");
	t.add("f");
	t.add("e");
	t.add("g");
	System.out.println(t);
	
	//System.out.println("Contains q: " + contains("q"));
	//System.out.println("Contains g: " + contains("g"));
    }

}
