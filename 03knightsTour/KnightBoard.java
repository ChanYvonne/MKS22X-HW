public class KnightBoard{
    private board int[][];
    private int rows, cols;

    public Board(int size){
	board = new int[size][size];
	rows = size;
	cols = size;
	clear();
    }

    public Board(int cols, int rows){
	board = new int[rows][cols];
	this.rows = rows;
	this.cols = cols;
	clear();
    }
    
    public void clear(){
	for (int x = 0; x < board.length; x++){
	    for (int i = 0; i < board[x].length; i++){
		board[x][i] = 0;
	    }
	}
    }
    
    public boolean isValidMove(int col, int row){
	return col < cols && row < rows;
    }

    public boolean solve(){
	return helpSolve(0,0);
    }

    public boolean helpSolve(int col, int row, int steps){
	//boolean ans = false;
	if (steps == rows*cols){
	    return true;
	}
	if(!(isValidMove(col,row))){
	    return false;
	}
	for (int x = 0; x < getRows(); x++){
	    for (int i = 0; i < getCols();i++){
		if (isValidStep()){
		    board[x][i]++;
		}
	    }
	}
	return false;
    }
    
    public void printSolution(){
	String ans = "";
	for (int x = 0; x < board.length; x++){
	    for (int i = 0; i < board[x].length; i++){
		if (rows*cols >= 10 && Integer.StringOf(board[x][i]) == 1){
		    ans += "_" + Integer.StringOf(board[x][i]) + " ";
		}else{
		    ans += Integer.StringOf(board[x][i]) + " ";
		}
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }
    
}
