import java.util.Scanner;
import java.io.*;

public class Bronze{

    private boolean DEBUG = true;

    int[][]grid;
    int rows;
    int cols;
    int elevation;
    int num; // num of inputs
    int[]xcors; // coord for stompystomps
    int[]ycors;
    int[]stomps; // stomp by how much?

    public Bronze(){
	importFile();
	//grid = new int[rows][cols];
    }

    public boolean importFile(){
	File f = new File("makelake.in");
	try{
	    Scanner s = new Scanner(f);
	    debug("success");
	    int arg = 0;
	    int r = 0;
	    int c = 0;
	    while(s.hasNext()){
		String ct = s.next();
		int current = Integer.parseInt(ct);
		//debug(ct);
		if(arg==0){
		    rows = current;
		}else if (arg==1){
		    cols = current;
		    grid = new int[rows][cols];
		}else if(arg==2){
		    elevation = current;
		}else if(arg==3){
		    num = current;
		    xcors = new int[num];
		    ycors = new int[num];
		    stomps = new int[num];
		}else if(arg<(rows+1)*(cols+1)+3){
		    //grid = new int[rows][cols];
		    grid[r][c] = current;
		    c++;
		    if(c==cols){
			c=0;
			r++;
		    }
		}else{
		    //inputs
		    //for(int i <
		}
		arg++;
		//grid = int[
	    }
	    //while(s.hasNext()){
		
	    return true;
	}catch(Exception e){
	    System.out.println("something went wrong!");
	    return false;
	}
    }

    public void printGrid(){
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
	        System.out.print(grid[r][c]);
		System.out.print(" ");
	    }
	    System.out.println();
	}
    }

    public int volume(){
	int v = 0;
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
		if(elevation-grid[r][c]<0){
		    v += (-1 * elevation + grid[r][c]);
		}
	    }	    
	}
	return v*72*72;
    }

    public void printSolution(){
	String sol = ""+volume()+",6,Cheng,Nicole";
	System.out.println(sol);
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
	//b.importFile();
	b.printGrid();

    }

}
