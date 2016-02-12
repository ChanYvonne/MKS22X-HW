public class KnightBoard{
    private board int[][];

    public Board(int size){
	board = new int[size][size];
	clear();
    }

    public Board(int cols, int rows){
	board = new int[rows][cols];
	clear();
    }
    
    public void clear(){
	for (int x = 0; x < board.length; x++){
	    for (int i = 0; i < board[x].length; i++){
		board[x][i] = 0;
	    }
	}
    }
    
    public int getRows(){
	return board.length;
    }
    
    public int getCols(){
	return board[getRow()-1].length;
    }

    public boolean isValidMove(int col, int row){
	return col < getCols() && row < getRows();
    }

    public boolean solve(){
	return helpSolve(0,0);
    }

    public boolean helpSolve(int col, int row, int steps){
	//boolean ans = false;
	if (steps == getRows()*getCols()){
	    return true;
	}else if(!(isValidMove(col,row))){
	    return false;
	}else{
	    for (int x = 0; x < getRows(); x++){
		for (int i = 0; i < getCols();i++){
		    if (isValidStep()){
			board[x][i]++;
		    }
		}
	    }
	}
	return false;
    }
    
    public void printSolution(){
	String ans = "";
	for (int x = 0; x < board.length; x++){
	    for (int i = 0; i < board[x].length; i++){
		ans += Integer.StringOf(board[x][i]) + " ";
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }
    
}
