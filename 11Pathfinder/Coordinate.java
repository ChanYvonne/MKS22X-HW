public class Coordinate{
    int xcor,ycor;

    public Coordinate(int x, int y){
	xcor = x;
	ycor = y;
    }

    public void setX(int xNew){
	xcor = xNew;
    }

    public void setY(int yNew){
	ycor = yNew;
    }

    public int getX(){
	return xcor;
    }

    public int getY(){
	return ycor;
    }
}
