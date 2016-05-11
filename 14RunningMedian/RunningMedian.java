import java.util.*;
@SuppressWarnings("unchecked")
public class RunningMedian{
    private MyHeap<Integer> max, min;
    
    //Create an empty running median set.
    public RunningMedian(){
	max = new MyHeap<Integer>(true);
	min = new MyHeap<Integer>();
    }  
	
    /*
      When empty: throws new NoSuchElementException()
      Returns the median value
    */
    public double getMedian(){
	if (max.size() == 0 && min.size() == 0){
	    throw new NoSuchElementException();
	}
	if (max.size() == min.size()){
	    return (max.peek() + min.peek())/2.0;
	}else if (max.size() > min.size()){
	    return  max.peek();
	}else{
	    return  min.peek();
	}
    }
    
    /* add to the "SmallValue" heap if  x < median, 
	add to the "BigValue" heap otherwise. 
	balance the two heaps so that their size differ by no more than 1. */   
    public void add(Integer x){
	if (max.size() == 0){
	    max.add(x);
	}else if(min.size() == 0){
	    min.add(x);
	}else{
	    if (x*1.0 < getMedian()){
		max.add(x);
	    }else{
		min.add(x);
	    }
	}
	while (min.size() -  max.size() > 1){
	    if (min.size() > max.size() + 1){
		Integer temp = min.delete();
		max.add(temp);
	    }
	    if (min.size() + 1 < max.size()){
		Integer temp = max.delete();
		min.add(temp);
	    }
	}
    }
    
    public String toString(){
	return min.toString() + "\n" + max.toString()+ "\nmedian: " + getMedian();
    }

    public static void main(String args[]){
	RunningMedian test = new RunningMedian();
	//System.out.println(test);
	test.add(5);
	System.out.println(test);
	test.add(10);
	test.add(2);
	test.add(19);
	test.add(-4);
	test.add(0);
	test.add(11);
	test.add(13);
	test.add(24);
	test.add(50);
	test.add(32);
	test.add(49);
	System.out.println(test);
    }
}
