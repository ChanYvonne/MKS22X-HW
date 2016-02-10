public class Board{
    private int[][] board;

    public Board(int square){
	board = new int[square][square];
	clear();
    }

    public void clear(){
	for (int x = 0; x < board.length; x++){
	    for (int i = 0; i < board[x].length; i++){
		board[x][i] = 0;
	    }
	}
    }

    public boolean addQueen(int row, int col){
	int rownum = 0;
	int colnum = col;
	if (board[row][col] == 0){
	    for (int j = col; j < board.length; j++){
		board[row][j] --;
	    }
	    for (int x = row + 1; x < board.length; x++){
		colnum++;
		if (colnum < board.length){
		    board[x][colnum]--;
		}
	    }
	    colnum = col + 1;
	    for (int x = row - 1; x >= 0; x--){
		if (colnum < board.length){
		    board[x][colnum]--;
		}
		colnum ++;
	    }
	    board[row][col] = 1;
	}else{
	    return false;
	}
	return true;
    }

    public boolean removeQueen(int row, int col){
        int rownum = 0;
	int colnum = col + 1;
	if (board[row][col] == 1){
	    for (int j = col; j < board.length; j++){
		board[row][j] ++;
	    }
	    for (int x = row + 1; x < board.length; x++){
		if (colnum < board.length){
		    board[x][colnum]++;
		}
		colnum ++;
	    }
	    colnum = col + 1;
	    for (int x = row - 1; x >= 0; x--){
		if (colnum < board.length){
		    board[x][colnum]++;
		}
		colnum ++;
	    }
	    board[row][col] = 0;
	}else{
	    return false;
	}
	return true;
    }

    public boolean solve(){
	    return helpSolve(0);
    }

    public boolean helpSolve(int start){
	int times = 0;
	if (times == board.length){
	    return true;	    
	}else{
	    for (int x = 0; x< board.length; x++){
	  	if (addQueen(x,start)){
		    times ++;
		    helpSolve(start+1);
		}
	    }
	}
	return true;
    }
    
    public String toString(){
	String out = "\n";
        for (int x = 0; x < board.length; x++){
	    for (int i = 0; i < board[x].length; i++){
		if (i == board[x].length-1){
		    out += Integer.toString(board[x][i]);
		}else{
		    out += Integer.toString(board[x][i])+ " ";
		}
	    }
	    out += "\n";
	}
	return out;
    }

    public static void main(String[]args){
	Board test = new Board(5);
	System.out.println(test.solve());
	System.out.println(test);
	/*
	System.out.print(test.addQueen(2,0));
	System.out.println(test);
	System.out.print(test.addQueen(4,1));
	System.out.println(test);
	System.out.print(test.removeQueen(4,1));
	System.out.println(test);
	*/
	
    }
}
