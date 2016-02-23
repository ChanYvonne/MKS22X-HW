public Bronze{
    /*
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

    public int solve(){
	int ans = 0;
	return ans;
    }
    */
    public static void main(String[]args){\
	string s = "4 6 22 2
28 25 20 32 34 36
27 25 20 20 30 34
24 20 20 20 20 30
20 20 14 14 20 20
1 4 4
1 1 10";
	try{
	    //Scanner in = new Scanner(new file("makeLatin.in"));
	    Scanner in = new Scanner(s));
	    while (in.hasNext()) {
		Scanner line = new Scanner(in.nextLine());
		while (line.hasNext()){
		    System.out.print(pigLatin(line.next())+" ");
		}
		System.out.println();
	    }
	    //Bronze test = new Bronze(Integer.parseInt(in.next()),Integer.parseInt(in.next()),
	    //System.out.println(test.solve()) + "6,Chan,Yvonne";
	}catch (FileNotFoundException e){
	    e.printStackTrace();
	}
    }
    
}
