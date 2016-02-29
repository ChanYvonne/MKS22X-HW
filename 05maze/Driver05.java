public class Driver05{

    public static void main(String[]args){
        Maze f;
	
	for (int x = 1; x < 4; x++){
	    f = new Maze("data" + x + ".dat",true);//true animates the maze.
        
	    f.clearTerminal();
	    f.solve();

	    f.clearTerminal();
	    System.out.println(f);
	}
	
	/*
	f = new Maze("data2.dat",true);//true animates the maze.
        
	f.clearTerminal();
	System.out.println(f.solve());

	f.clearTerminal();
	System.out.println(f);
	*/
    }
}
