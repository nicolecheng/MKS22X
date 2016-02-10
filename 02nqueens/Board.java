public class Board{

    int[][]board;
    int row;
    int col;

    public Board(int n){
	board = new int[n][n];
	for (int r = 0; r < n; r++){
	    for (int c = 0; c < n; c++){
		board[r][c] = 0;
	    }
	}
    }

    public void addQueen(){
	if (board[row][col]<0){
	    if (row>=board.length-1){ // at end of column
		removeQueen(); // abort
	    }else{
		row++;
		addQueen(); // try to add queen in next slot
	    }
	}else{
	    board[row][col]=1; // yes plant the queen
	    for (int i = col+1; i < board.length; i++){ // across
		board[row][i] -= 1;
		for (int m = row+1; m < board.length; m++){ // diagonally down
		    board[m][i] -= 1;
		}
		for (int n = row-1; n >= 0; n--){ // diagonally up
		    board[n][i] -= 1;
		}
	    }
	}
    }

    public void removeQueen(){



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
	Board b = new Board(2);
	System.out.println(b.toString());



    }
    
}
