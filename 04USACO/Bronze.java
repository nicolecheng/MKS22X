import java.util.Scanner;
import java.io.*;

public class Bronze{

    private boolean DEBUG = true;

    String scan="";
    int[][]grid;
    int[]block;
    int rows;
    int cols;
    int elevation;
    int num; // num of inputs
    int[]xcors; // coord for stompystomps
    int[]ycors;
    int[]stomps; // stomp by how much?

    public Bronze(){
	importFile();
	loadGrid();
	block = new int[9]; // 3x3=9 block of cows
	//grid = new int[rows][cols];
    }

    public boolean importFile(){
	File f = new File("makelake.in");
	try{
	    Scanner s = new Scanner(f);
	    while(s.hasNextLine()){
		scan += s.nextLine() + "\n";
	    }
	    //debug(scan);
	    //debug("scanner in -- success");
	    return true;
	}catch(Exception e){
	    e.printStackTrace(System.out);
	    System.out.println("scanner fail");
	    return false;
	}
    }

    public boolean loadGrid(){
	Scanner in = new Scanner(scan);
	int arg = 0;
	int r = 0;
	int c = 0;
	while(in.hasNext()){
	    String ct = in.next();
	    int current = Integer.parseInt(ct);
	    if(arg==0){
		rows = current;
	    }else if (arg==1){
		cols = current;
		grid = new int[rows][cols];
	    }else if(arg==2){
		elevation = current;
	    }else if(arg==3){
		num = current;
		xcors = new int[num];
		ycors = new int[num];
		stomps = new int[num];
	    }else if(arg<(rows)*(cols)+4){
		grid[r][c] = current;
		c++;
		if(c==cols){
		    c=0;
		    r++;
		}
	    }else{
		xcors[0] = current;
		for (int i = 0; i < num; i++){
		    if(i>0){ xcors[i] = Integer.parseInt(in.next());}
		    ycors[i]=(Integer.parseInt(in.next()));
		    stomps[i]=(Integer.parseInt(in.next()));
		}
	    }
	    arg++;
	} 
	//debug(argh(xcors)+"\n"+argh(ycors)+"\n"+argh(stomps));
	return true;
    }

    public boolean lakeMaking(){
	for (int i = 0; i < num; i++){
	    if(xcors[i]>grid[0].length-2){ // still on the field or nah?
		return false;
	    }else{

		for(int r = 0; r < 3; r++){
		    for(int c = 0; c < 3; c++){
			block[r*3+c] = grid[xcors[i]+r-1][ycors[i]+c-1];
		    }
		}
		//for(int m = 0; m < block.length; m ++){
		//    System.out.println(block[m]);
		//}
		return stompy(stomps[i]);
	    }
	}
	return true;
    }

    public boolean stompy(int times){
	
	return true;

    }

    public int max(int[]vals){ // return index of max in array
	int m = vals[0];
	for (int i = 0; i <vals.length; i++){
	    if(vals[i]>m){
		m = i;
	    }
	}
	return m;
    }

    public String argh(int[]ar){ // just returns a 2d array in string form for debugging
	String str = "[";
	for (int i = 0; i < ar.length-1; i++){
	    str+=ar[i]+",";
	}
	str+=ar[ar.length-1]+"]";
	return str;
    }

    public void printGrid(){
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
	        System.out.print(grid[r][c]);
		System.out.print(" ");
	    }
	    System.out.println();
	}
    }

    public int volume(){
	int v = 0;
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
		if(elevation-grid[r][c]<0){
		    v += (-1 * elevation + grid[r][c]);
		}
	    }	    
	}
	return v*72*72;
    }

    public void printSolution(){
	String sol = ""+volume()+",6,Cheng,Nicole";
	System.out.println(sol);
    }
    

    public void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }

    public static void main(String[]args){

	Bronze b = new Bronze();
	//b.importFile();
	b.printGrid();
	b.lakeMaking();

    }

}
