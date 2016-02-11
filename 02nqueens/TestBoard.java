public class TestBoard{

    int[][]board;
    int row;
    int col;

    public TestBoard(int n){
	board = new int[n][n];
    }

    public boolean addQueen(){
	if (board[row][col]<0){
	    if (row>=board.length-1){ // at end of column
		//removeQueen(); // abort -- no room in this column
		return false;
	    }else{
		row++;
		addQueen(); // try to add queen in next slot
	    }
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
	return true;
    }

    public boolean removeQueen(){
	col--;
	for (int i = 0; i < board.length; i++){
	    if (board[i][col]==1){ // queen to remove
		row = i;
	    }
	}
	if (board[row][col]!=1){return false;
	}else{
	    board[row][col]=3;//-1; // queen cannot be here
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
    }

    public boolean fill(){
	for (col = 0; col < board.length; col++){
	    if (openSlot()){
		System.out.println(toString());
		if(!addQueen()){
		    removeQueen();
		}
	    }else{
		return false;
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
	TestBoard b = new TestBoard(3);
	//b.addQueen();
	//System.out.println(b.toString());
	//b.removeQueen();
	b.fill();
	System.out.println(b);	
    }
    
}
