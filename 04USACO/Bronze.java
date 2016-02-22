public Bronze{
    private int[][] board;
    private int rows, col, elevation;
    private int[][] instructions;
    
    public Bronze(int row, int col, int[][] sample, int elev){
	board = new int[row][col];
	instructions = new int[row][col];
	rows = row;
	cols = col;
	for (int x = 0; x < row; x++){
	    for (int i = 0; i < col; i++){
		instructions[x][i] = sample[x][i];
	    }
	}
    }

    public static void main(String[]args){
	try{
	    Scanner in = new Scanner(new file("input.in"));
	}catch{
	    
	}
    }
    
}
