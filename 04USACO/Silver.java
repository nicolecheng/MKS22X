// Test case 1, result = 114384
// Test case 2, result = 81891116

import java.util.Scanner;
import java.io.*;

public class Silver{

    private boolean DEBUG = true;
    
    String scan = "";
    int rows;
    int cols;
    int steps;
    int[][]grid;

    public Silver(){
	importFile();
	loadGrid();
    }

    public boolean importFile(){
	File f = new File("ctravel.in");
	try{
	    Scanner s = new Scanner(f);
	    while(s.hasNextLine()){
		scan += s.nextLine() + "\n";
	    }
	    //debug(scan);
	    //debug("scanner in -- success");
	    return true;
	}catch(Exception e){
	    e.printStackTrace(System.out);
	    System.out.println("scanner fail");
	    return false;
	}
    }

    public boolean loadGrid(){
	Scanner in = new Scanner(scan);
	String line = "";
	int line = 0;
	while(in.hasNextLine()){
	    line = in.nextLine();
	    if(line==0){
		//load vars
		//rows = ;
		//cols = ;
		//grid = new int[rows][cols];
		//line++;
	    }else{
		for(int i = 0; i < line.length(); i++){
		    //grid[line-1][i]=line.substring(i,i+1);
		}
	    }
    }

    public void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }

}
