import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    private MyStack<T> data;

    public FrontierStack(){
	data = new MyStack<T>();
    }

    public void add(T element){
	data.push(element);
    }

    public T next(){
	return data.pop();
    }

    public boolean hasNext(){
	return !data.isEmpty();
    }

}
