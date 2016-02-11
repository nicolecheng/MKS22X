public class QueenBoard{
    private int[][]board;
    
    public QueenBoard(int size){
	board = new int[size][size];
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
	int i = 0;
<<<<<<< HEAD
	if (i >= board.length){
	    return true;
	}else if(i < 0){
	    return false;
	}else if (solveH(i)){
	    i++;
	    return solve();
	    //return solveH(i+1);
	}else{
	    i--;
	    //return solve();
	    return solveH(i-1);
	}
	return false;
	//	return false;
=======
	if (i >= board.length){return false;}
	while(i<board.length){
	    if (solveH(i)){
		i++;
	    }else{
		i--;
	    }
	    return solveH(i);
	}
	return true;
>>>>>>> parent of 87cc118... still not working ??
    }

    /**
     *Helper method fr solve. 
     */
   int startRow = 0;
    private boolean solveH(int col){
	System.out.println(toString());
       if(startRow<board.length){
          if (addQueen(startRow,col)){
             startRow=0;
             return true;
          }else{
             startRow++;
             solveH(col);
          }
       }else{
          int hold=0;
          col--;
          	for (int i = 0; i < board.length; i++){
	    if (board[i][col]==1){ // queen to remove
		hold = i;
	    }
	} 
          removeQueen(hold,col);
          startRow = hold+1;
          return solveH(col);
       }
	return false;
    }

    public void printSolution(){
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	*/
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
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
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
	return true;
    }

    public String  toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
<<<<<<< HEAD
	QueenBoard b = new QueenBoard(2);
	/*
	  System.out.println(b);
	  b.addQueen(3,0);
	  b.addQueen(0,1);
	  System.out.println(b);
	  b.removeQueen(3,0);
	  System.out.println(b);*/
	System.out.println(b.solve());
	System.out.println(b);
	b.solve();
=======
	TestBoard b = new TestBoard(4);
	/*
	System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
	System.out.println(b);
	b.removeQueen(3,0);
	System.out.println(b);*/
	System.out.println(b.solve());
	System.out.println(b);

>>>>>>> parent of 87cc118... still not working ??
    }
    
    
}
