import java.util.*;
import java.io.*;

public class Silver{
    private int[][] field;
    private int rows, cols, time;
    private int[] begin;

    public Silver(int row, int col, char[][] grass, int step, int[] spot){
	field = new int[row][col];
        begin = new int[spot.length];
	rows = row;
	cols = col;
	time = step;
        for (int x = 0; x < row; x++){
	    for (int i = 0; i < col; i++){
		if (grass[x][i] == '*'){
		    field[x][i] = -1;
		}
		else{
		    field[x][i] = 0;
		}
	    }
	}
	for (int i = 0; i < spot.length; i++){
	    begin[i] = spot[i];
	}
    }

    public void replicate(int[][] temp, int[][] grass){
	for (int r = 0; r < rows; r++){
	    for (int c = 0; c < cols; c++){
		temp[r][c] = grass[r][c];
	    }
	}
    }

    public int solve(){
	field[begin[0]-1][begin[1]-1] = 1;
	int[][] temp = new int[rows][cols];
        replicate(temp,field);
	for (int x = 0; x < time; x++){
	    for (int r = 0; r < rows; r++){
		for (int c = 0; c < cols; c++){
		    if (!(field[r][c] == -1)){
			if (field[r][c] == 0){
			    temp[r][c] = calcSteps(r,c);
			    //System.out.println(calcSteps(r,c));
			}else{
			    temp[r][c] = 0;
			}
		    }
		}
	    }
	    replicate(field,temp);
	    //System.out.println(toString());
	}
	return field[begin[2]-1][begin[3]-1];
    }

    public int calcSteps(int row, int col){
	int sum = 0;
	if (row - 1 >= 0 && !(field[row-1][col] == -1)){
	    sum+= field[row-1][col];
	}
	if (row + 1 < rows && !(field[row+1][col] == -1)){
	    sum+= field[row+1][col];
	}
	if (col - 1 >= 0 && !(field[row][col-1] == -1)){
	    sum+= field[row][col-1];
	}
	if (col + 1 < cols && !(field[row][col+1] == -1)){
	    sum+= field[row][col+1];
	}
	return sum;
    }
    
    public String toString(){
	String ans = "";
	for (int x = 0; x < rows; x++){
	    for (int i = 0; i < cols; i++){
		if (field[x][i] == -1){
		    ans += "* ";
		}else{
		    ans+= Integer.toString(field[x][i]) + " ";
		}
	    }
	    ans+= "\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	String s = "4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	
	try{
	    Scanner in = new Scanner(new File("ctravel.in"));
	    //Scanner in = new Scanner(s);
	    for (int w = 0; w < 3; w++){
	    int row = Integer.parseInt(in.next());
	    int col = Integer.parseInt(in.next());
	    int time = Integer.parseInt(in.next());
	    //System.out.println(elevation);
	    char [][] sample = new char[row][col];
	    for (int x = 0; x < row; x++){
		String line = in.next();
		for (int i = 0; i < col; i++){			
		    sample[x][i] = line.charAt(i);
		    //System.out.println(sample[x][i]);
		}
	    }
	    String empty = in.nextLine(); //random empty string for purpose of debugging - DO NOT REMOVE THIS LINE
	    int[] layout = new int[4];
	    for (int x = 0; x < 4; x++){
		layout[x] = Integer.parseInt(in.next());
		//System.out.println(layout[x]);
	    }
	    /*
	      for (int x = 0; x < commands.length; x++){
		//System.out.println(commands[x]);
	    }
	    */
	    String empty2 = in.nextLine(); //random empty string for purpose of debugging - DO NOT REMOVE THIS LINE
	    Silver test = new Silver(row,col,sample,time,layout);
	    //System.out.println(test);
	    System.out.println(test.solve() + ",6,Chan,Yvonne");
	    }
	}catch (FileNotFoundException e){
	    e.printStackTrace();
	}
    }
}
