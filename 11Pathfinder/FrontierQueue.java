import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    private MyQueue<T> data;

    public FrontierQueue(){
	data = new MyQueue<T>();
    }

    public void add(T element){
	data.enqueue(element);
    }

    public T next(){
	if (data.isEmpty()){
	    throw new NoSuchElementException();
	}
	return data.dequeue();
    }

    public boolean hasNext(){
	return !data.isEmpty();
    }
}
