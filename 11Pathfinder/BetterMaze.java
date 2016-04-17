import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
	Coordinate value;
	Node last;

	public Node(Coordinate c, Node prev){
	    value = new Coordinate(c.getX(),c.getY());
	    last = prev;
	}

	public Node getPrev(){
	    return last;
	}
	
	public int getCol(){
	    return value.getY();
	}

	public int getRow(){
	    return value.getX();
	}

	public Coordinate getValue(){
	    return value;
	}

	public void setPrev(Node prev){
	    last = prev;
	}

	public void setValue(Coordinate c){
	    value = c;
	}

	public boolean hasPrev(){
	    return !(last == null);
	}

    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol,steps;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(Node n){
	int[] solved  = new int[steps*2];
	Node temp = new Node(n.getValue(),n.getPrev());
	for (int x = 0; temp.hasPrev();x+=2){
	    if (x != 0){
		temp = temp.getPrev();
	    }
	    solved[x] = temp.getCol();
	    solved[x+1] = temp.getRow();
	}
	return solved;
    }

    public int[] reverse(int[] coor){ //to put coordinates in order
	int[] solved = new int[steps*2];
	for (int x = solved.length-1; x >= 0; x--){
	    solved[solved.length-1-x] = coor[x];
	}
	return solved;
    }

    public int[] solutionCoordinates(){
	return reverse(solution);
    }
    
    /*
    public String getCoordinate(char c){
	int xcor, ycor;
	for (int x = 0; x < maze.length;x++){
	    for (int i = 0; i < maze[x].length;i++){
		if (maze[x][i] == c){
		    xcor = i;
		    ycor = x;
		}
	    }
	}
	return "(" + xcor + "," + ycor + ")"; 
    }
    */

    public int cols(){
	return maze[0].length;
    }

    public int rows(){
	return maze.length;
    }
    
    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        placesToGo = new FrontierQueue<Node>();
	return solve();
    }   


   /**initialize the frontier as a stack and call solve
    */ 
    public boolean solveDFS(){  
        placesToGo = new FrontierStack<Node>();
	return solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){
	Coordinate start = new Coordinate(startRow,startCol);
	Node temp = new Node(start,null);
	placesToGo.add(temp);
	maze[startRow][startCol] = '.';
	while (placesToGo.hasNext()){
	    if (animate){
		//clearTerminal();
		System.out.println(toString());
	    }
	    temp = placesToGo.next();
	    if (maze[temp.getRow()][temp.getCol()] == 'E'){
		//System.out.println("solution found here:"+ temp.getRow()+","+temp.getCol());
		solution = solutionCoordinates(temp);
		return true;
	    }
	    process(temp);
	    steps++;
	    maze[temp.getRow()][temp.getCol()] = '.';
	}
	return false;
    }
    
    public void process(Node n){
	int x = n.getRow();
	int y = n.getCol();
	
	if (canMoveTo(x+1,y)){
	    placesToGo.add(new Node(new Coordinate(x+1,y),n));
	}
	if (canMoveTo(x-1,y)){
	    placesToGo.add(new Node(new Coordinate(x-1,y),n));
	}
	if (canMoveTo(x,y+1)){
	    placesToGo.add(new Node(new Coordinate(x,y+1),n));
	}
	if (canMoveTo(x,y-1)){
	    placesToGo.add(new Node(new Coordinate(x,y-1),n));
	}
    }

    public boolean canMoveTo(int xcor, int ycor){
	return maze[xcor][ycor] == ' ' || maze[xcor][ycor] == 'E';
    }

   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){
	animate = b;
    }   

    public BetterMaze(String filename){
	animate = false;
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
    }

    //--------------animation stuff-------------------------------
    
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
    
    public static void main(String[] args){
	String filename = "";
	if (args.length > 0){
	    filename = args[0];
	}else{
	    System.out.println("Please include filename");
	    System.exit(0);
	}
	
	BetterMaze test = new BetterMaze(filename);
	test.clearTerminal();
	test.setAnimate(true);
	test.solveBFS();
	System.out.println(test);
	System.out.println(Arrays.toString(test.solutionCoordinates()));
	
	
	BetterMaze test2 = new BetterMaze(filename);
	test2.clearTerminal();
	test2.setAnimate(true);
	test2.solveDFS();
	System.out.println(test2);
	System.out.println(Arrays.toString(test2.solutionCoordinates()));
    }
    
}
