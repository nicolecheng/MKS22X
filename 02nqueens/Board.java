public class Board{

    int[][]board;
    int row;
    int col;

    public Board(int n){
	for (int r = 0; r < n; r++){
	    for (int c = 0; c < n; c++){
		board[r][c] = 0;
	    }
	}
    }

    public void addQueen(){
	if (board[row][col]<0){
	    row++;
	    addQueen();
	}else{
	    board[row][col]=1;
   	}
	for (int i = col+1; i < board.length; i++){
	    
	}


}
