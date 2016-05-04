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

	public String toString(){
	    String s = " "+data;
	    if(left==null){
		s+=" _";
	    }else{
	        s+=left.toString();
	    }
	    if(right==null){
	        s+=" _";
	    }else{
		s+=right.toString();
	    }
	    return s;
	}

	private boolean contains(T value){
	    if(data.equals(value)){
		return true;
	    }else{
		if(left==null && right==null){
		    return false;
		}else if(left==null && right!=null){
		    return right.contains(value);
		}else if(left!=null && right==null){
		    return left.contains(value);
		}else{
		    return right.contains(value) || left.contains(value);
		}
	    }
	
	}

	private T remove(T value){
	    T hold = value;
	    Node L = this;
	    if(left!=null && left.equals(value)){
		hold = left.data;
		shift(left);
		//L = L.left;
		//
		left = null;
	    }else if(right!=null && right.equals(value)){
		hold = right.data;
		shift(right);
		right = null;
	    }else{
		if(left!=null){left.remove(value);}
		if(right!=null){right.remove(value);}
	    }
	    return hold;
	}

	private void shift(Node n){
	    Node L = n.left;
	    T val;
	    while(L.right!=null && L.right.right!=null){
		L = L.right;
	    }
	    val = L.right.data;
	    n.set(val);
	    n.left = L.left;
	    L.right = null; // make it disappear from the bottom of the tree
	}
	
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	if(root==null){
	    return 0;
	}else{
	    return root.height();
	}
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
	    return root.toString(); 
	}
    }
	
    public boolean contains(T value){
	if(root==null){
	    return false;
	}else{
	    return root.contains(value);
	}
    }

    public T remove(T value){
	if(root==null || !root.contains(value)){
	    return null;
	}else{
	    return root.remove(value);
	}
    }

    public static void main(String[] args) {
	BSTree<String> t = new BSTree<String>();
		
	t.add("b");
	t.add("a");
	t.add("c");
	t.add("f");
	t.add("e");
	t.add("g");
	t.remove("g");
	System.out.println(t);
	
	//System.out.println("Contains q: " + contains("q"));
	//System.out.println("Contains g: " + contains("g"));
    }

}
