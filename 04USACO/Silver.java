import java.util.*;
import java.io.*;

public class Silver{
    private int[][] field;
    private int rows, cols, time;
    private String[] begin;

    public Silver(int row, int col, int[][] grass, int step, String[] spot){
	field = new int[row][col];
        begin = new String[spot.length];
	rows = row;
	cols = col;
	time = step;
	for (int x = 0; x < row; x++){
	    for (int i = 0; i < col; i++){
	        field[x][i] = grass[x][i];
	    }
	}
	for (int i = 0; i < spot.length; i++){
	    begin[i] = spot[i];
	}
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
	Silver test = new Silver();
	System.out.println(test);
	/*
	String s = "4 6 22 2\n28 25 20 32 34 36\n27 25 20 20 30 34\n24 20 20 20 20 30\n20 20 14 14 20 20\n1 4 4\n1 1 10";
	try{
	    Scanner in = new Scanner(new File("makeLake.in"));
	    //Scanner in = new Scanner(s);
	    int row = Integer.parseInt(in.next());
	    int col = Integer.parseInt(in.next());
	    int elevation = Integer.parseInt(in.next());
	    //System.out.println(elevation);
	    int[][] sample = new int[row][col];
	    int com = Integer.parseInt(in.next());
	    for (int x = 0; x < row; x++){
		for (int i = 0; i < col; i++){
		    sample[x][i] = Integer.parseInt(in.next());
		}
	    }
	    String empty = in.nextLine(); //random empty string for purpose of debugging - DO NOT REMOVE THIS LINE
	    String[] commands = new String[com];
	    commands[0] = in.nextLine();
	    commands[1] = in.nextLine();
	    /*
	      for (int x = 0; x < commands.length; x++){
		//System.out.println(commands[x]);
	    }
	    */
	    Bronze test = new Bronze(row,col,sample,elevation,commands);
	    //System.out.println(test);
	    System.out.println(test.solve() + ",6,Chan,Yvonne");
	}catch (FileNotFoundException e){
	    e.printStackTrace();
	}
    */
    }
}
