public class KnightBoard{

    private int[][]board;
    //private int num; // which step are we up to?

    public KnightBoard(int size){
	board = new int[size][size];
	//num = 1; // starting knight
    }

    public boolean solve(){

	return solveH(0,0,1);

    }

    private boolean solveH(int row, int col, int n){
	if(board[row][col]==1){
	    return true;
	}
	/*if(board[row][col]!=0){
	    return false;
	    }*/
	board[row][col]=n;
	printSolution();
	System.out.println();
        if(canMove(row+1,col+2)){	    
	    if(solveH(row+1,col+2,n+1)){
		return true;
	    }
	}
        if(canMove(row+1,col-2)){	    
	    if(solveH(row+1,col+2,n+1)){
		return true;
	    }
	}
        if(canMove(row+2,col+1)){	    
	    if(solveH(row+1,col+2,n+1)){
		return true;
	    }
	}
        if(canMove(row+2,col-1)){	    
	    if(solveH(row+1,col+2,n+1)){
		return true;
	    }
	}
        if(canMove(row-1,col+2)){	    
	    if(solveH(row+1,col+2,n+1)){
		return true;
	    }
	}
        if(canMove(row-1,col-2)){	    
	    if(solveH(row+1,col+2,n+1)){
		return true;
	    }
	}
        if(canMove(row-2,col+1)){	    
	    if(solveH(row+1,col+2,n+1)){
		return true;
	    }
	}
        if(canMove(row-2,col-1)){	    
	    if(solveH(row+1,col+2,n+1)){ // CHANGE THESE
		return true;
	    }
	}
	return false;
    }

    private boolean canMove(int row, int col){
	if (row >= board.length || col >= board.length){
	    return false;
	}else{
	    return (board[row][col]==0);
	}
    }

    public void printSolution(){
	for (int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		System.out.print(board[r][c]);
	    }
	    System.out.println();
	}
    }

    public static void main(String[]args){
	KnightBoard k = new KnightBoard(6);
	k.solve();
    }

}
