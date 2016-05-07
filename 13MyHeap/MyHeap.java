import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;

    public MyHeap(){
	data = (T[]) new Comparable[size];
    }
   
    public MyHeap(T[] array){
	data = (T[]) new Comparable[array.length+1];
	for (int x = 0; x < array.length;x++){
	    data[x+1] = array.get(x);
	}
	heapify();
    }
   
    private void swap(int a, int b){
	T temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }

    private void pushDown(int index){
	if (data[index*2].compareTo(data[index]) > 0){
	    swap(index,index*2);
	}else{
	    swap(index,index*2+1);
	}
    }
   
    private void pushUp(int index){
	if (data[index/2].compareTo(data[index]) < 0){
	    swap(index,index/2);
	}
    }

    private void heapify(){
       
    }

    public T delete(){
	return null;
    }
   
    public void add(T x){
	if (size == data.length-1){
	    doubleSize();
	}
	int index = 1;
	while (index*2+1 < data.length){
	}
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
	    }
	    ans += data[x] + ", ";
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
	ArrayList<Integer> array = new ArrayList<Integer>();
	array.add(2);
	array.add(5);
	array.add(9);
	array.add(13);
	array.add(30);
	array.add(11);
	array.add(23);
	array.add(62);
	array.add(4);
	array.add(7);
	MyHeap<Integer> test = new MyHeap(array);
    }

}
