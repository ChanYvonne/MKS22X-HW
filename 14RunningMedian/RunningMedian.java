import java.util.*;
@SuppressWarnings("unchecked")
public class RunningMedian<T extends Comparable<T>>{
    private MyHeap<T> max, min;
    private T[] data;
    
    //Create an empty running median set.
    public RunningMedian(){
	data = (T[]) new Comparable[10];
	max = new MyHeap<T>(data,true);
	min = new MyHeap<T>(data,false);
    }  
	
    /*
      When empty: throws new NoSuchElementException()
      Returns the median value
    */
    public double getMedian(){
	if (max == null || min == null){
	    throw new NoSuchElementException();
	}
	if (max.size() == min.size()){
	    return (max.peek() + min.peek())/2;
	}else if (max.size() > min.size()){
	    return max.peek();
	}else{
	    return min.peek();
	}
    }
    
    /* add to the "SmallValue" heap if  x < median, 
	add to the "BigValue" heap otherwise. 
	balance the two heaps so that their size differ by no more than 1. */   
    public void add(Integer x){
	
    }
    
    public String toString(){
	String ans = max.toString() + "\n" + "median: " + getMedian();
    }
	
}
