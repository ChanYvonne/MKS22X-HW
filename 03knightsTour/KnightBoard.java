public class KnightBoard{
    private int[][] board;
    private int rows, cols;

    public KnightBoard(int size){
	board = new int[size][size];
	rows = size;
	cols = size;
	clear();
    }

    public KnightBoard(int cols, int rows){
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
	return helpSolve(0,0,1);
    }

    public boolean helpSolve(int col, int row, int steps){
	//boolean ans = false;
	if (steps == rows*cols+1){
	    return true;
	}
	if(!(isValidMove(col,row))){
	    return false;
	}
	System.out.println(toString());
	if (isValidMove(col+1,row+2) && board[row+2][col+1] == 0){
	    board[row][col] = steps;
	    return helpSolve(col+1,row+2,steps+1);
	}else if (isValidMove(col+2,row+1) && board[row+1][col+2] == 0){
	    board[row][col] = steps;
	    return helpSolve(col+2,row+1,steps+1);
	}else if (isValidMove(col+2,row-1) && board[row-1][col+2] == 0){
	    board[row][col] = steps;
	    return helpSolve(col+2,row-1,steps+1);
	}else if (isValidMove(col+1,row-2) && board[row-2][col+1] == 0){
	    board[row][col] = steps;
	    return helpSolve(col+1,row-2,steps+1);
	}else if (isValidMove(col-1,row-2) && board[row-2][col-1] == 0){
	    board[row][col] = steps;
	    return helpSolve(col-1,row-2,steps+1);
	}else if (isValidMove(col-2,row-1) && board[row-1][col-2] == 0){
	    board[row][col] = steps;
	    return helpSolve(col-2,row-1,steps+1);
	}else if (isValidMove(col-2,row+1) && board[row+1][col-2] == 0){
	    board[row][col] = steps;
	    return helpSolve(col-2,row+1,steps+1);
	}else if (isValidMove(col-1,row+2) && board[row+2][col-1] == 0){
	    board[row][col] = steps;
	    return helpSolve(col-1,row+2,steps+1);
	}else{
	    return false;
	}
    }

    public String toString(){
	String ans = "";
	for (int x =0; x < board.length;x++){
	    for(int i = 0; i < board[x].length; i++){
		ans += Integer.toString(board[x][i]) + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    public void printSolution(){
	String ans = "";
	for (int x = 0; x < board.length; x++){
	    for (int i = 0; i < board[x].length; i++){
		if (rows*cols >= 10 && board[x][i]/10 == 0){
		    ans += "_" + Integer.toString(board[x][i]) + " ";
		}else{
		    ans += Integer.toString(board[x][i]) + " ";
		}
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }

    public static void main(String[]args){
	KnightBoard test = new KnightBoard(3);
	test.solve();
	test.printSolution();
    }
}
