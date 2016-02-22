import java.util.Scanner;
import java.io.*;

public class Bronze{

    private boolean DEBUG = true;

    int[][]grid;

    public Bronze(){
	importFile();
    }

    public boolean importFile(){
	File f = new File("makelake.in");
	try{
	    Scanner s = new Scanner(f);
	    debug("success");
	    
	    return true;
	}catch(Exception e){
	    System.out.println("invalid file");
	    return false;
	}
    }

    public void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }
    
    /*
file input
print output
    */

    public static void main(String[]args){

	Bronze b = new Bronze();
	b.importFile();

    }

}
