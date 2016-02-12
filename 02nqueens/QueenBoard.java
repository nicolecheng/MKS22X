public class QueenBoard{
    private static boolean DEBUG = false;
    private int[][]board;
    private int[]queens;
    
    public QueenBoard(int size){
	board = new int[size][size];
	queens = new int[size]; // keeps track of which row the queen is in in each row
	for (int i = 0; i < board.length; i++){
	    queens[i] = -1; // initialize to no queens
	}
    }

    private void debug(String s){
	if (DEBUG){
	    System.out.println(s);
	}
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve(){
	return solveH(0);
    }

    /**
     *Helper method fr solve. 
     */
    private boolean solveH(int col){
	debug(toString());
        if (col >= board.length) {
	    return true;
	}
	for (int row = 0; row < board.length; row++) {
	    if (board[row][col]==0){
		addQueen(row,col);
		if (solveH(col+1)) {
		    return true;
		}else{
		    removeQueen(queens[col],col);
		}
	    }
	}
	return false;
    }

    public void printSolution(){
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	*/
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		if(board[r][c]==1){
		    ans += "Q  ";
		}else if(board[r][c]==0){
		    ans += "_  ";
		}else{
		    ans += "   ";
		}
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }

    /********Do Not Edit Below This Line**********************************/

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	queens[col] = row;
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = -1; // 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	queens[col] = -1;
	return true;
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"  ";
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	QueenBoard b = new QueenBoard(4);
	/*
	  System.out.println(b);
	  b.addQueen(3,0);
	  b.addQueen(0,1);
	  System.out.println(b);
	  b.removeQueen(3,0);
	  System.out.println(b);*/
	//System.out.println(b);
	b.solve();
	b.printSolution();
    }
    
    
}
