import.java.util.*;

public class BetterMaze{
    private class Node{
	char value;
	Node last;

	public Node(){
	}

	public Node getPrev(){
	    return last;
	}
	
	public char getValue(){
	    return value;
	}

	public void setPrev(Node t){
	    last = t;
	}

	public void setValue(char c){
	    value = c;
	}

    }
    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate = false;

    public BetterMaze(){
	for (int r = 0; r < maze.length;r++){
	    for (int c = 0; c < maze[r].length;c++){
		for (char x = 0; x < maze.length*maze[x].length;x++){
		    maze[r][c] = x;
		}
	    }
	}
    }


    /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
         
    }    
    
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

    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        /** IMPLEMENT THIS **/      
    }   


   /**initialize the frontier as a stack and call solve
    **/ 
    public boolean solveDFS(){  
        /** IMPLEMENT THIS **/  
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    public boolean solve(){  
        /** IMPLEMENT THIS **/  
    }    
     
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){ animate = b; }    



    
    
}
