public class Board{

    int[][]board;
    int row;
    int col;
    int dim;

    public Board(int n){
	dim = n;
	int[][]board = new int[n][n];
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
   	}
	for (int i = col+1; i < board.length; i++){
	    
	}
    }

    public void removeQueen(){



    }

    public String toString(){
	String s = "";
	for (int r = 0; r < dim; r++){
	    s += "[";
	    for (int c = 0; c < dim; c++){
		s += "n";//board[r][c] + "   ";
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
