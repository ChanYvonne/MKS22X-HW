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
	
	public int getRow(){
	    return value.getY();
	}

	public int getCol(){
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
    public int[] solutionCoordinates(){
	if (solveBFS() || solveDFS()){
	    solution = new int[steps*2];
	    Node temp = new Node(placesToGo.next().getValue(),placesToGo.next().getPrev());
	    for (int x = 0; temp.hasPrev();x+=2){
		if (x != 0){
		    temp = temp.getPrev();
		}
		solution[x] = temp.getCol();
		solution[x+1] = temp.getRow();
	    }
	    return solution;
	}
	return new int[1];
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
	Coordinate temp = new Coordinate(startRow,startCol);
	placesToGo.add(new Node(temp,null));
	maze[startRow][startCol] = '.';
	while (placesToGo.hasNext()){
	    Node spot = placesToGo.next();
	    Node[] neighbors = process(spot);
	    for (Node x : neighbors){
		if (x != null){
		    if (maze[x.getRow()][x.getCol()] == 'E'){
			solutionCoordinates();
			return true;
		    }
		    placesToGo.add(x);
		    maze[x.getRow()][x.getCol()] = '.';
		    steps++;
		}
		if (animate){
		    System.out.println(toString());
		}
	    }
	}
	return false;
    }

    public Node[] process(Node x){
	Node[] neighbors = new Node[4];
	int index = 0;
	Coordinate tempv;
	if (x.getRow() != rows()-1){
	    tempv = new Coordinate(x.getRow()+1,x.getCol());
	    if (canMoveTo(new Node(tempv,x))){
		neighbors[index] = new Node(tempv,x);
		index++;
	    }
	}
	if (x.getRow() != 0){
	    tempv = new Coordinate(x.getRow()-1,x.getCol());
	    if (canMoveTo(new Node(tempv,x))){
	        neighbors[index] = new Node(tempv,x);
		index++;
	    }
	}
	if (x.getCol() != cols()-1){
	    tempv = new Coordinate(x.getRow(),x.getCol()+1);
	    if (canMoveTo(new Node(tempv,x))){
	        neighbors[index] = new Node(tempv,x);
		index++;
	    }
	}
	if (x.getCol() != 0){
	    tempv = new Coordinate(x.getRow()+1,x.getCol()-1);
	    if (canMoveTo(new Node(tempv,x))){
		neighbors[index] = new Node(tempv,x);
		index++;
	    }
	}
	
	return neighbors;
    }

    public boolean canMoveTo(Node c){
	//System.out.println(c.getRow());
	//System.out.println(c.getCol());
	return maze[c.getRow()][c.getCol()] == ' ' || maze[c.getRow()][c.getCol()] == 'E';
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
	test.clearTerminal();
	
	BetterMaze test2 = new BetterMaze(filename);
	test.setAnimate(true);
	test.solveDFS();
	System.out.println(test);
	System.out.println(Arrays.toString(test2.solutionCoordinates()));
    }
    
}
