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
	return col < cols && row < rows && col >= 0 && row >= 0;
    }

    public boolean solve(){
	for (int x = 0; x < rows; x++){
	    for (int i = 0; i < cols; i++){
		if (helpSolve(i,x,1)){
		    return true;
		}
	    }
	}
	return false;
    }

    public boolean addKnight(int row, int col, int step){
	if (board[row][col] == 0){
	    board[row][col] = step;
	    return true;
	}
	return false;
    }

    public boolean helpSolve(int col, int row, int steps){
	//boolean ans = false;
	if (steps == rows*cols+1){
	    return true;
	}
	if (!(isValidMove(col,row))){
	    return false;
	}
	
	//System.out.println(toString());
	//System.out.println(col+" "+ row+"\n");

	if (addKnight(row, col, steps)){
	    if (helpSolve(col+1,row+2,steps+1) ||
		helpSolve(col+2,row+1,steps+1) ||
		helpSolve(col+2,row-1,steps+1) ||
		helpSolve(col+1,row-2,steps+1) ||
		helpSolve(col-1,row-2,steps+1) ||
		helpSolve(col-2,row-1,steps+1) ||
		helpSolve(col-2,row+1,steps+1) ||
		helpSolve(col-1,row+2,steps+1)){
		return true;
	    }
	    board[row][col] = 0; //for backtracking
	    //helpSolve(row,col,steps-1);
	}
	return false;
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
	for (int x = 5; x < 8; x++){
	    KnightBoard test = new KnightBoard(x);
	    System.out.println(test.solve());
	    test.printSolution();
	}
	KnightBoard test2 = new KnightBoard(3,5);
	System.out.println(test2.solve());
	test2.printSolution();
	
	KnightBoard test3 = new KnightBoard(5,6);
	System.out.println(test3.solve());
	test3.printSolution();

	KnightBoard test4 = new KnightBoard(3,7);
	System.out.println(test4.solve());
	test4.printSolution();
	
	KnightBoard test5 = new KnightBoard(3,10);
	System.out.println(test5.solve());
	test5.printSolution();

	KnightBoard test6 = new KnightBoard(3);
	System.out.println(test6.solve());
	test6.printSolution();
    }
}
