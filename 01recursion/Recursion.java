import java.util.*;

public class Recursion implements hw01{

    public Recursion(){}
    
    // 1.1 You are adding a method to return your name: format: "Last,First" as it appears on your school documentation.
    public String name(){
	return("Cheng,Nicole");
    }

    // 1.2 You are solving 1 problem recursively:

    // The following method will throw an IllegalArgumentException when n < 0. 

    // sqrt**   

    double guess = 1;
    
    public boolean goodEnough(double n, double g){
	return (Math.abs(g*g-n)/n<=.00001);
    }
    
    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException("you cannot sqrt a neg number");
	}
	if (n==0||n==1){return n;}
	if (goodEnough(n,guess)){
	    return guess;
	}else{
	    //System.out.println(( n / guess + guess) / 2);
	    guess = ( n / guess + guess) / 2;
	    return sqrt(n);
	}
    }


    // Now to think a little:
    // There is a formula to calculate square root
    // Guess any number for the sqrt of n. (like n/2, or even 1)

    // n = 100
    // guess = 1

    // Make a better guess this way: 
    // guess =  ( n / guess + guess) / 2

    // guess = 50.5

    // (then do it again, then do it again)
    // guess = 26.24009900990099
    // guess = 15.025530119986813
    // guess = 10.840434673026925
    // guess = 10.032578510960604
    // guess = 10.000052895642693
    // ...
    // Notice how fast this converges on the correct value (10).

    // ** You MUST make a helper function, because you have to keep track of both n, and your guess in the recursion. This means that you need a function with two parameters, even though the sqrt function only takes 1 parameter.

    public static void main (String[]args){
	Recursion b = new Recursion();
	System.out.println(b.sqrt(100));
	System.out.println(b.sqrt(9));
	System.out.println(b.sqrt(0));
	System.out.println(b.sqrt(50));
	System.out.println(b.sqrt(64));
    }
    
}
