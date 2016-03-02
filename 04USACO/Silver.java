// Test case 1, result = 114384
// Test case 2, result = 81891116
// Test case 3, result = 1

import java.util.Scanner;
import java.io.*;

public class Silver{

    private boolean DEBUG = true;
    
    String scan = "";
    int rows;
    int cols;
    int steps;
    char[][]grid1;
    int[][]grid;
    int[][]hold;
    int startX, startY, endX, endY;

    public Silver(){
	importFile();
	loadGrid();
	grid = new int[rows][cols];
	hold = new int[rows][cols];
	setBoard();
	gridToHold();
	//printHold();
	grid[startX][startY]=1;
    }

    public boolean importFile(){
	File f = new File("ctravel3.in");
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
	grid1 = new char[rows][cols];
	while(n.hasNext()){
	    cur = n.next();
	    if(row<rows){
	        for(int c = 0; c < cols; c++){
		    grid1[row][c] = cur.charAt(c);
		}
	    }else{
		startX = Integer.parseInt(cur)-1;
		startY = Integer.parseInt(n.next())-1;
		endX = Integer.parseInt(n.next())-1;
		endY = Integer.parseInt(n.next())-1;
	    }
	    
	    row++;
	}	
	//debug(""+rows+" "+cols+" "+steps+" \n"+startX+" "+startY+" "+endX+" "+endY);
	return true;
    }

    public void setBoard(){
	for (int r = 0; r < rows; r++){
	    for (int c = 0; c < cols; c++){
		if(grid1[r][c]=='.'){
		    grid[r][c]=0;
		}else if(grid1[r][c]=='*'){
		    grid[r][c]=-1;
		}
	    }
	}
    }

    /*
    public int move(){
	//	for(int i = 0; i < steps; i++){
	    for(int r = 0; r < rows; r++){
		for(int c = 0; c < cols; c++){
		    if(grid[r][c]>0){// && (grid[r][c])!='.' && (grid[r][c])!='*'){
			//debug(""+r+"  "+c);
			//debug(""+grid[r][c]);
			add(r,c);
			//printGrid();
			//printHold();
		    }
		}
	    }
	    //	    grid = hold;
	    //	    }
	return grid[endX][endY];
    }

    public void add(int r, int c){
	if(inBounds(r,c-1)){
	    hold[r][c-1] = (grid[r][c-1])+1;
	}
	if(inBounds(r,c+1)){
	    hold[r][c+1] = (grid[r][c+1])+1;
	}
	if(inBounds(r-1,c)){
	    hold[r-1][c] = (grid[r-1][c])+1;
	}
	if(inBounds(r+1,c)){
	    hold[r+1][c] = (grid[r+1][c])+1;
	}
	hold[r][c]=0;
	printGrid();
	debug("\n");
        //grid = hold;
    }
    */


    public void solve(){
	//printGrid();
	//debug("\n");
	for(int i = 0; i < steps; i++){
	    //holdReset();
	    move();
	    holdToGrid();
	    printHold();
	    //holdReset();
	    //printGrid();
	    debug("\n");
	    //printHold();
	}
    }
    
    public int move(){
	    for(int r = 0; r < rows; r++){
		for(int c = 0; c < cols; c++){
		    if(grid[r][c]!=-1){// && (grid[r][c])!='.' && (grid[r][c])!='*'){
			//debug(""+r+"  "+c);
			//debug(""+grid[r][c]);
			hold[r][c] = add(r,c);			
			//printGrid();
			//debug("\n");
			//printHold();
		    }
		}
	    }
	return grid[endX][endY];
    }

    public int add(int r, int c){
	int sum = 0;
	if(inBounds(r,c-1)){
	    //debug("1l");
	    //debug(""+grid[r][c-1]);
	    sum += (grid[r][c-1]);
	}
	if(inBounds(r,c+1)){
	    //debug(""+grid[r][c+1]);
	    sum += (grid[r][c+1]);
	    //debug("1r");
	}
	if(inBounds(r-1,c)){
	    //debug(""+grid[r-1][c]);
	    sum += (grid[r-1][c]);
	    //debug("1u");
	}
	if(inBounds(r+1,c)){
	    //debug(""+grid[r+1][c]);
	    sum += (grid[r+1][c]);
	    //debug("1d");
	}
	//hold[r][c]=0;
	//printGrid();
	//debug("\n");
        //grid = hold;
	return sum;
    }

    public void holdReset(){
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
		if(hold[r][c]!=-1){
		    hold[r][c]=0;
		}
	    }
	}
    }

    
    public boolean inBounds(int r, int c){
	return (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] != -1);
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

     public void printHold(){
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
	        System.out.print(hold[r][c]);
		System.out.print(" ");
	    }
	    System.out.println();
	}
    }

    public void gridToHold(){
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
		hold[r][c]=grid[r][c];
	    }
	}
    }

    public void holdToGrid(){
        for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
		hold[r][c]=grid[r][c];
	    }
	}
    }
    
    public void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }

    public static void main(String[]args){
	
	Silver fox = new Silver();
	//fox.printHold();
	fox.solve();
	//fox.printGrid();
	//System.out.println(fox.add(0,1)); // 1

	
    }

}
