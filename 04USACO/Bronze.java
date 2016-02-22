import java.util.Scanner;
import java.io.*;

public class Bronze{

    private boolean DEBUG = true;

    int[][]grid;
    int rows;
    int cols;
    int elevation;
    int num;

    public Bronze(){
	importFile();
	grid = new int[rows][cols];
    }

    public boolean importFile(){
	File f = new File("makelake.in");
	try{
	    Scanner s = new Scanner(f);
	    debug("success");
	    int arg = 0;
	    while(s.hasNext()){
		String ct = s.next();
		int current = Integer.parseInt(ct);
		//debug(ct);
		if(arg==0){
		    rows = current-1;
		}else if (arg==1){
		    cols = current-1;
		}else if(arg==2){
		    elevation = current;
		}else if(arg==3){
		    num = current;
		}else{
		    //grid = new int[rows][cols];
		    for(int r = 0; r < rows; r++){
			for(int c = 0; c < cols; c++){
			    grid[r][c] = current;
			}			
		    }
		}
		arg++;
		//grid = int[
	    }
	    //while(s.hasNext()){
		
	    return true;
	}catch(Exception e){
	    System.out.println("invalid file");
	    return false;
	}
    }

    public void printGrid(){
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
	        System.out.print(grid[r][c]);
	    }
	    System.out.println();
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
	//b.importFile();
	b.printGrid();

    }

}
