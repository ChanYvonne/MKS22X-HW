import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;

    public MyHeap(){
	data = (T[]) new Comparable[1];
    }
   
    public MyHeap(T[] array){
	data = (T[]) new Comparable[array.length+1];
	for (int x = 0; x < array.length;x++){
	    data[x+1] = array[x];
	}
	size = array.length;
	heapify();
    }
   
    private void swap(int a, int b){
	T temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }

    /*pushDown
      precondition: datas[k]'s children are valid heaps
      postconditions:-the element at index k has been 
                     shifted to the correct spot.
                     -data[k] and is a valid heap
   */    
    private void pushDown(int index){
	if (index*2+1 < data.length){
	    if (data[index*2].compareTo(data[index]) < 0){
		swap(index,index*2);
		pushDown(index*2);
	    }
	    if (data[index*2+1].compareTo(data[index]) < 0){
		swap(index,index*2+1);
		pushDown(index*2+1);
	    }
	}
    }

    /*pushUp
      precondition: data is a heap with at most one item
      out of place (element at k)
      postconditions:-the element at index k has been 
                     shifted to the correct spot.
                     -data is a valid heap
   */
    private void pushUp(int index){
	if (index/2 > 0){
	    if (data[index/2].compareTo(data[index]) > 0){
		swap(index,index/2);
		pushUp(index/2);
	    }
	}
    }

    private void heapify(){
	int index = size/2;
	while (index > 0){
	    pushDown(index);
	    index--;
	}
	index = size/2;
	while (index < size){
	    pushUp(index);
	    index++;
	}
    }

    public T delete(){
	return null;
    }
   
    public void add(T x){
	if (size == 0){
	    data[1] = x;
	}
	if (size == data.length-1){
	    doubleSize();
	}
	int index = 1;
	while (index*2+1 < data.length){
	    if (x.compareTo(data[index]) > 0){
		pushDown(index);
		data[index] = x;
		
	    }
	}
	size++;
    }
   
    private void doubleSize(){
	size *= 2;
	T[] temp = (T[])new Comparable[size];
	for (int x = 0; x < data.length; x++){
	    temp[x] = data[x];
	}
	data = temp;
    }
   
    public String toString(){
	String ans = "[";
	for (int x = 0; x < data.length; x++){
	    if (x == data.length-1){
		ans+= data[x];
	    }else{
		ans += data[x] + ", ";
	    }
	}
	return ans + "]";
    }
    
    /*
    //do this last
    public MyHeap(boolean isMax){
   
    }
    public MyHeap(T[] array, boolean isMax){
    this(array);
    }
    */

    public static void main(String[]args){
        Integer[] array = {1,5,24,7,15,3,8,4,10,13,6,30,17,9,28};
	MyHeap<Integer> test = new MyHeap(array);
	System.out.println(test);
    }

}
