/*
  Any m × n board with m <= n, a closed knight's tour is always possible unless one or more of these three conditions are met:
  m and n are both odd
  m = 1, 2, or 4
  m = 3 and n = 4, 6, or 8.
  (Wikipedia)
*/

public class KnightBoard{

    private boolean DEBUG = false; // buggy buggy bug
    
    private int[][]board;
   
    public KnightBoard(int size){
	board = new int[size][size];
    }

    public KnightBoard(int cols, int rows){ // cols and THEN rows? are you sure, mr k?
	board = new int[rows][cols];
    }

    public boolean solve(){
	return solveH(0,0,1); // starting from spot 0,0 and planting knight #1
    }

    private boolean solveH(int row, int col, int n){
	
	board[row][col] = n; // plant knight
	
	if(n == board.length*board[0].length){ // we've made it
	    return true;
	}

	//debug(toString()); // print every single step of tour

	// here are the eight possible moves
	if(canMove(row+1,col+2) && solveH(row+1,col+2,n+1)){
	    return true;
	}
	if(canMove(row+1,col-2) && solveH(row+1,col-2,n+1)){
	    return true;
	}
	if(canMove(row+2,col+1) && solveH(row+2,col+1,n+1)){
	    return true;
	}
	if(canMove(row+2,col-1) && solveH(row+2,col-1,n+1)){
	    return true;
	}
	if(canMove(row-1,col+2) && solveH(row-1,col+2,n+1)){
	    return true;
	}
	if(canMove(row-1,col-2) && solveH(row-1,col-2,n+1)){
	    return true;
	}
	if(canMove(row-2,col+1) && solveH(row-2,col+1,n+1)){
	    return true;
	}
	if(canMove(row-2,col-1) && solveH(row-2,col-1,n+1)){
	    return true;
	}

	// if all fails, set current to 0 & move back a knight
	// return false and abort current mission
	board[row][col]=0;
	n--;
	return false;
	
    }

    private boolean canMove(int row, int col){
	// destination on board and vacant?
	if (row >= board.length || col >= board[0].length ||
	    row < 0 || col < 0 || board[row][col]!=0){
	    return false;
	}else{
	    return true;
	}
    }

    public void printSolution(){
	System.out.println(toString());
    }

    // bc i wanted a string return version to be available
    public String toString(){
	debug("DIMENSIONS: "+board.length+" x "+board[0].length);
	String ret = "";
	for (int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ret+=board[r][c]+"  ";
	    }
	    ret+="\n";
	}
	return ret+"\n";
    }

    public void debug(String s){
	if (DEBUG){
	    System.out.println(s);
	}
    }

    public static void main(String[]args){
	
	KnightBoard m = new KnightBoard(6,5);
	m.solve();
	m.printSolution();

	/*
	  KnightBoard b = new KnightBoard(5,6);
	  b.solve();
	  b.printSolution();

	  KnightBoard k = new KnightBoard(6);
	  k.solve();
	  System.out.println(k);
	*/
       
    }

}
