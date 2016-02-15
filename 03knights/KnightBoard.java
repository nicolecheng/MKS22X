public class KnightBoard{

    private boolean DEBUG = false;
    
    private int[][]board;
   
    public KnightBoard(int size){
	board = new int[size][size];
    }

    public boolean solve(){
	return solveH(0,0,1);
    }

    private boolean solveH(int row, int col, int n){
	//if(!canMove(row,col)){return false;}
	//if(row==0&&col==0&&n==board.length*board.length+1){
	if (board[row][col]!=0){
	    return false;
	}
	
	board[row][col]=n;
	
	if(n == board.length*board.length){//board[row][col]==1){
	    return true;
	}
	//if(n>board.length*board.length){
	//    return false;
	//}
	
	debug(toString());

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
	board[row][col]=0;
	n--;
	return false;
    }

    private boolean canMove(int row, int col){
	if (row >= board.length || col >= board.length ||
	    row < 0 || col < 0 || board[row][col]!=0){
	    return false;
	}else{
	    //debug(""+board[row][col]);
	    //return (board[row][col]==0);
	    return true;
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

    public String toString(){
	String ret = "";
	for (int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		ret+=board[r][c]+" ";
	    }
	    ret+="\n";
	}
	return ret;
    }

    public void debug(String s){
	if (DEBUG){
	    System.out.println(s);
	}
    }

    public static void main(String[]args){
	KnightBoard k = new KnightBoard(6);
	k.solve();
	System.out.println(k);
    }

}
