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

    public boolean solve(){
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
