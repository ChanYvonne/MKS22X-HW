import java.util.*;
import java.io.*;

public class Bronze{
    private int[][] hill;
    private int rows, cols, elevation;
    private String[] instructions;
    
    public Bronze(int row, int col, int[][] sample, int elev, String[] instruction){
        hill = new int[row][col];
        instructions = new String[instruction.length];
	rows = row;
	cols = col;
	for (int x = 0; x < row; x++){
	    for (int i = 0; i < col; i++){
	        hill[x][i] = sample[x][i];
	    }
	}
	for (int i = 0; i < instruction.length; i++){
	    instructions[i] = instruction[i];
	}
    }

    public int solve(){
	int depth = 0;
	String com = "";
	int spotRow = 0;
	int spotCol = 0;
	int total = 0;
	int elev = 0;
	for (int x = 0; x < commands.length; x++){
	    command = instructions[x];
	    spotRow = Integer.parseInt(command.substring(0))-1;
	    spotCol = Integer.parseInt(command.substring(2))-1;
	    depth = command.substring(4);
	    elev = hill[spotRow][spotCol];
	    for (int r = spotRow;r < spotRow + 3 && r < rows-2; r++){
		for (int c = spotCol; c < spotCol + 3 && c < rows-2;c++){
		    if (elev-depth < hill[r][c]){
			hill[r][c] = elev-depth; 
		    }
		}
	    }
	}
	for (int x = 0; x < rows; x++){
	    for (int i = 0; i < cols; i++){
		if (elevation-hill[x][i] <= 0){
		    hill[x][i] = -1;
		}else{
		    hill[x][i] = elevation-hill[x][i];
		    total+= hill[x][i];
		}
	    }
	}
	return total*72*72;
    }

    public String toString(){
	String ans = "";
	for (int x = 0; x < rows; x++){
	    for (int i = 0; i < cols; i++){
		if (hill[x][i] == -1){
		    ans+= "-- ";
		}else{
		    ans+= Integer.toString(hill[x][i]) + " ";
		}
	    }
	    ans+= "\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	String s = "4 6 22 2\n28 25 20 32 34 36\n27 25 20 20 30 34\n24 20 20 20 20 30\n20 20 14 14 20 20\n1 4 4\n1 1 10";
	try{
	    Scanner in = new Scanner(new File("makeLake.in"));
	    //Scanner in = new Scanner(s);
	    int row = Integer.parseInt(in.next());
	    int col = Integer.parseInt(in.next());
	    int elevation = Integer.parseInt(in.next());
	    int[][] sample = new int[row][col];
	    int com = Integer.parseInt(in.next());
	    for (int x = 0; x < row; x++){
		for (int i = 0; i < col; i++){
		    sample[x][i] = Integer.parseInt(in.next());
		}
	    }
	    String[] commands = new String[com];
	    for (int x = 0; x < com; x++){
		commands[x] = in.nextLine();
	    }
	    /*
	      while (line.hasNext()){
		System.out.print(line.next()+" ");
	      }
	    */
	    Bronze test = new Bronze(row,col,sample,elevation,commands);
	    System.out.println(test);
	    System.out.println(test.solve() + ",6,Chan,Yvonne");
	}catch (FileNotFoundException e){
	    e.printStackTrace();
	}
    }
    
}
