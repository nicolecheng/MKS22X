import java.util.*;

public class Recursion implements hw01{

    public Recursion(){}
    
    // 1.1 You are adding a method to return your name: format: "Last,First" as it appears on your school documentation.
    public String name(){
	return("Cheng,Nicole");
    }

    // 1.2 You are solving 1 problem recursively:

    double guess = 1;

    // ** You MUST make a helper function, because you have to keep track of both n, and your guess in the recursion.
    // This means that you need a function with two parameters, even though the sqrt function only takes 1 parameter.
    
    public boolean goodEnough(double n, double g){
	return (Math.abs(g*g-n)/n<=.00001);
    }
    
    public double sqrt(double n){
	// The following method will throw an IllegalArgumentException when n < 0.  
	if (n<0){
	    throw new IllegalArgumentException("you cannot sqrt a neg number");	}
	if (n==0||n==1){return n;}
	if (goodEnough(n,guess)){
	    return guess;
	}else{
	    //System.out.println(( n / guess + guess) / 2);
	    guess = ( n / guess + guess) / 2;
	    return sqrt(n);
	}
    }    

    public static void main (String[]args){
	Recursion b = new Recursion();
	System.out.println(b.sqrt(100));
	System.out.println(b.sqrt(9));
	System.out.println(b.sqrt(0));
	System.out.println(b.sqrt(50));
	System.out.println(b.sqrt(64));
    }
    
}
