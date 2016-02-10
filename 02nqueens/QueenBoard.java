public class QueenBoard{

    private int[][]board;
    //int row;
    //int col;

    public QueenBoard(int n){
	board = new int[n][n];
	/*row = 0;
	col = 0;
	for (int r = 0; r < n; r++){
	    for (int c = 0; c < n; c++){
		board[r][c] = 0;
	    }
	    }*/
    }

    public boolean addQueen(int row, int col){
	if (board[row][col]!=0){
	    return false;
	    //	    if (row>=board.length-1){ // at end of column
		//removeQueen(); // abort -- no room in this column
	    // }else{
	    //	row++;
	    //	addQueen(); // try to add queen in next slot
	    //}
	}else{
	    board[row][col]=1; // yes plant the queen
	    for (int i = col+1; i < board.length; i++){ // across
		board[row][i] -= 1;
	    }
	    for (int m = 1; row+m < board.length && col+m <board.length; m++){ // diagonally down
		board[row+m][col+m] -= 1;
	    }
	    for (int n = 1; row-n >= 0 && col + n < board.length; n++){ // diagonally up
		board[row-n][col+n] -= 1;
	    }
	    return true;
	}
    }

    public boolean removeQueen(int row, int col){
	//col--;
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col]=-1; // queen cannot be here
	for (int i = col+1; i < board.length; i++){ // across
	    board[row][i] += 1;
	}
	for (int m = 1; row+m < board.length && col+m <board.length; m++){ // diagonally down
	    board[row+m][col+m] += 1;
	}
	for (int n = 1; row-n >= 0 && col + n < board.length; n++){ // diagonally up
	    board[row-n][col+n] += 1;
	}
	return true;
    }

    public void solve(){
	int col = 0;
	for (int row = 0; row < board.length && col < board[row].length; row++){
	    if (addQueen(row,col)){
		col++;
		row = 0;
		addQueen(row,col);
	    }else{
		col--;
		for (int i = 0; i < board.length; i++){
		    if (board[i][col]==1){ // queen to remove
			row = i;
		    }
		}
		if(removeQueen(row,col)){
		    row++;
		    addQueen(row,col);
		}
	    }
	}
    }

    public String toString(){
	String s = "";
	for (int r = 0; r < board.length; r++){
	    s += "[   ";
	    for (int c = 0; c < board.length; c++){
		s += board[r][c] + "   ";
	    }
	    s += "]\n";
	}
	return s;
    }
    
    public static void main(String[]args){
	QueenBoard b = new QueenBoard(3);
	//b.addQueen();
	//System.out.println(b);
	//b.removeQueen();
	b.solve();
	System.out.println(b.toString());	
    }
    
}
