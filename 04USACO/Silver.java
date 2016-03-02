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
    char[][]hold;
    int startX, startY, endX, endY;

    public Silver(){
	importFile();
	loadGrid();
	hold = grid;
	grid[startX][startY]=0;
    }

    public boolean importFile(){
	File f = new File("ctravel.in");
	try{
	    Scanner s = new Scanner(f);
	    while(s.hasNextLine()){
		scan += s.nextLine() + "\n";
	    }
	    return true;
	}catch(Exception e){
	    e.printStackTrace(System.out);
	    System.out.println("scanner fail");
	    return false;
	}
    }

    public boolean loadGrid(){
	String cur = "";
	int row = 0;
	Scanner n = new Scanner(scan);
	rows = Integer.parseInt(n.next());
	cols = Integer.parseInt(n.next());
	steps = Integer.parseInt(n.next());
	grid = new char[rows][cols];
	while(n.hasNext()){
	    cur = n.next();
	    if(row<rows){
	        for(int c = 0; c < cols; c++){
		    grid[row][c] = cur.charAt(c);
		}
	    }else{
		startX = Integer.parseInt(cur);
		startY = Integer.parseInt(n.next());
		endX = Integer.parseInt(n.next());
		endY = Integer.parseInt(n.next());
	    }
	    
	    row++;
	}	
	debug(""+rows+" "+cols+" "+steps+" \n"+startX+" "+startY+" "+endX+" "+endY);
	return true;
    }

    public void solve(){


    }

    public void move(){
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
		if((grid[r][c])!='.' && (grid[r][c])!='*'){
		    add(r,c);
		}
	    }
	}

    }

    public boolean add(int r, int c){
	if(inBounds(r,c-1)){
	    hold[r][c-1] = 
	}
	if(inBounds(r,c+1)){
	}
	if(inBounds(r-1,c)){
	}
	if(inBounds(r+1,c)){
	}
	return true;
    }

    public boolean inBounds(int r, int c){
	return (r > 0 && r < rows && c > 0 && c < cols && grid[r][c] != '*');
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

	
    }

}
