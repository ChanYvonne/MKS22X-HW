public class Coordinate{
    int[] coor;

    public Coordinate(int x, int y){
	coor = new int[2];
	coor[0] = x;
	coor[1] = y;
    }
    
    /*
    public void setX(int xNew){
	coor[0] = xNew;
    }

    public void setY(int yNew){
	coor[1] = yNew;
    }
    */

    public int getX(){
	return coor[0];
    }

    public int getY(){
	return coor[1];
    }
}
