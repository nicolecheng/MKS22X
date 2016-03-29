public class ParenDemo<T> extends MyStack<T>{

    public static boolean isMatching(String s){
	MyStack<String> m = new MyStack<String>();
	String t;
	for(int i = 0; i < s.length(); i++){
	    if(i < s.length()-1){
		t = s.substring(i,i+1);
	    }else{
		t = s.substring(i);
	    }
	    if(t.equals("{")||t.equals("(")||t.equals("[")||t.equals("<")){
		m.push(t);
	    }else{
	        if(m.isEmpty()){
		    return false;
	        }else if(t.equals("}")){
		    if(!m.peek().equals("{")){
			    return false;
		    }else{
			m.pop();
		    }
		}else if(t.equals("]")){
		    if(!m.peek().equals("[")){
			    return false;
		    }else{
			m.pop();
		    }
		}else if(t.equals(">")){
		    if(!m.peek().equals("<")){
			    return false;
		    }else{
			m.pop();
		    }
		}else if(t.equals(")")){
		    if(!m.peek().equals("(")){
			    return false;
		    }else{
			m.pop();
		    }
		}
	    }
	}
	return true;
    }



    public static void main(String[]args){

	String input = "";

	if (args.length > 0)
	    input = args[0];

	System.out.println(isMatching(input));

    }
}
