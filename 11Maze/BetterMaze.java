
import java.util.*;
import java.io.*;

public class BetterMaze{
    private boolean DEBUG = false;

    private class Node{
	int id,x,y;
	Node prev;

	public Node(int id, Node prev){
	    this.id = id;
	    this.prev = prev;
	    x = id%cols;
	    y = id/cols;
	}

	public Node(int x, int y, Node prev){
	    this.x = x;
	    this.y = y;
	    this.prev = prev;
	    id = y * cols + x;
	}

	public int getID(){
	    return id;
	}

	public int getX(){
	    return x;
	}

	public int getY(){
	    return y;
	}

	public void setID(int i){
	    this.id = i;
	}

	public Node getPrev(){
	    return prev;
	}

	public boolean hasPrev(){
	    return prev != null;
	}

    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false
    private int rows, cols;
    private Node sol;
    private int steps;
    private boolean solved;

    /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     **/
    public int[] solutionCoordinates(){
	this.solution = new int[steps*2];
        /** IMPLEMENT THIS **/
	Node temp = new Node(sol.getID(), sol.getPrev());
	int count = 0;
	while(temp.hasPrev()){
	    if(count!=0){
		temp = temp.getPrev();
	    }
	    solution[count] = temp.getX();
	    count++;
	    solution[count] = temp.getY();
	    count++;
	    
	}
	// need to reverse int[]
	return solution;
    }    


    /**initialize the frontier as a queue and call solve
     **/
    public boolean solveBFS(){  
        /** IMPLEMENT THIS **/
	placesToGo = new FrontierQueue<Node>();
	return solve();
    }   


    /**initialize the frontier as a stack and call solve
     */ 
    public boolean solveDFS(){  
        /** IMPLEMENT THIS **/
	placesToGo = new FrontierStack<Node>();
	return solve();
    }    

    /**Search for the end of the maze using the frontier. 
       Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){  
        /** IMPLEMENT THIS **/ 
	Node n = new Node(startCol,startRow,null);;
	placesToGo.add(n);
	while(placesToGo.hasNext()){
	    n = placesToGo.next();
	    if(maze[n.getY()][n.getX()]=='E'){
		debug("SOLVED");
		return true;
	    }
	    processNode(n);
	    // credits to noah for animation snippet
	    if (animate) {
		clearTerminal();
		System.out.println(toString());
		try {
		    Thread.sleep(300);
		}
		catch (Exception e) {
		    System.out.println("waiting failed");
		}
	    }
	    steps++;
	}
	return true;
    }    

    private boolean canMove(Node n){
	return (maze[n.getY()][n.getX()]==' ');
    }
    private boolean canMove(int x, int y){
	return maze[y][x]==' ';
    }

    private boolean foundEnd(Node n){
	return (maze[n.getY()][n.getX()]=='E');
    }

    private void processNode(Node n){
	int x = n.getX();
	int y = n.getY();
	if(canMove(x,y+1)){
	    debug("down");
	    placesToGo.add(new Node(x,y+1,n));
	}
	if(canMove(x,y-1)){
	    debug("up");
	    placesToGo.add(new Node(x,y-1,n));
	}
	if(canMove(x+1,y)){
	    debug("right");
	    placesToGo.add(new Node(x+1,y,n));
	}
	if(canMove(x-1,y)){
	    debug("left");
	    placesToGo.add(new Node(x-1,y,n));
	}
	maze[y][x]='*';
    }

    private void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }
     
    /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  /** IMPLEMENT THIS **/
	animate = b;
    }    


    public BetterMaze(String filename){
	animate = false;
	solved = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
	rows = maxr;
	cols = maxc;
    }


    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 

    public static void main(String[] args) {
		BetterMaze a = new BetterMaze("data1.dat");
		a.setAnimate(true);
		System.out.println(a.solveDFS());
		
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
			System.out.println("waiting failed");
		}
		
		BetterMaze a2 = new BetterMaze("data1.dat");
		a2.setAnimate(true);
		System.out.println(a2.solveBFS());
		
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
			System.out.println("waiting failed");
		}
		/*
		BetterMaze b = new BetterMaze("data2.dat");
		b.setAnimate(true);
		System.out.println(b.solveDFS());
		
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
			System.out.println("waiting failed");
		}
		
		BetterMaze b2 = new BetterMaze("data2.dat");
		b2.setAnimate(true);
		System.out.println(b2.solveBFS());
		*/
	}
    
}
