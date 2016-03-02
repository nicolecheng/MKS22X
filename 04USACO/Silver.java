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
    char[][]grid;
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
			grid = new char[rows][cols];
		    }else if(arg==2){
			steps = Integer.parseInt(a.next());
		    }
		    lineNum++;
		}
		debug(""+rows+" "+cols+" "+steps);
	    }else if(lineNum<rows+1){
		for(int c = 0; c < cols; c++){
		    if(c==cols-1){
			if(line.substring(c).equals(".")){
			    grid[lineNum-1][c] = '.';
			}else if(line.substring(c).equals("*")){
			    grid[lineNum-1][c] = '.';
			}
		    }else{
			if(line.substring(c,c+1).equals(".")){
			    grid[lineNum-1][c] = '.';
			}else if(line.substring(c,c+1).equals("*")){
			    grid[lineNum-1][c] = '.';
			}
			//grid[lineNum-1][c] = line.substring(c,c+1);
		    }
		}
	    }else{
		Scanner m = new Scanner(line);
		arg = 0;
		if(arg==0){
		    startX = Integer.parseInt(m.next());
		}else if(arg==1){
		    startY = Integer.parseInt(m.next());
		}else if(arg==2){
		    endX = Integer.parseInt(m.next());
		}else if(arg==3){
		    endY = Integer.parseInt(m.next());
		}else{
		    System.out.println("um this is supposed to be an unreachable statement");
		}
	    }
	}
	//	debug(""+rows+" "+cols+" "+steps+" "+startX+" "+startY+" "+endX+" "+endY);
	return false;
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

    
    public void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }

    public static void main(String[]args){
	
	Silver fox = new Silver();
	fox.printGrid();
	System.out.println("printttt");

	
    }

}
