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
    int startX, startY, endX, endY;

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
	int lineNum = 0;
	int arg = 0;
	while(in.hasNextLine()){
	    line = in.nextLine();
	    if(lineNum==0){
		Scanner a = new Scanner(line);
		while(a.hasNext()){
		    if(arg==0){
			rows = Integer.parseInt(a.next());
		    }else if(arg==1){
			cols = Integer.parseInt(a.next());
			grid = new int[rows][cols];
		    }else if(arg==2){
			steps = Integer.parseInt(a.next());
		    }else if(arg<rows*cols+3){
			grid[(arg-3)/cols][(arg-3)%cols] = Integer.parseInt(a.next());
		    }else if(arg==rows*cols+3){
			startX = Integer.parseInt(a.next());
		    }else if(arg==rows*cols+4){
			startY = Integer.parseInt(a.next());
		    }else if(arg==rows*cols+5){
			endX = Integer.parseInt(a.next());
		    }else if(arg==rows*cols+6){
			endY = Integer.parseInt(a.next());
		    }else{
			System.out.println("um this is supposed to be an unreachable statement");
		    }
		}
		//load vars
		//rows = ;
		//cols = ;
		//grid = new int[rows][cols];
		//lineNum++;
	    }else{
		for(int i = 0; i < line.length(); i++){
		    //grid[line-1][i]=line.substring(i,i+1);
		}
	    }
	}
	return false;
    }

    public void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }

}
