import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
<<<<<<< HEAD

    public MyHeap(){
	data = (T[]) new Comparable[size];
=======
    private boolean isMax;

    public MyHeap(){
	data = (T[]) new Comparable[10];
	isMax = true;
>>>>>>> 408fad0c7e73a8d561bb2a1ae8f01a30e3375522
    }
   
    public MyHeap(T[] array){
	data = (T[]) new Comparable[array.length+1];
	for (int x = 0; x < array.length;x++){
<<<<<<< HEAD
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
=======
	    data[x+1] = array[x];
	}
	size = array.length;
	isMax = true;
	heapify();
    }

    public MyHeap(boolean Max){
	this();
        isMax = Max;
	heapify();
    }
    
    public MyHeap(T[] array, boolean Max){
	this(array);
        isMax = Max;
	heapify();
    }

    /*
    public boolean getMax(){
	return isMax;
    }
    */
    
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
	    if (isMax){
		if (data[index*2].compareTo(data[index]) < 0){
		    swap(index,index*2);
		    pushDown(index*2);
		}
		if (data[index*2+1].compareTo(data[index]) < 0){
		    swap(index,index*2+1);
		    pushDown(index*2+1);
		}
	    }else{
		if (data[index*2].compareTo(data[index]) > 0){
		    swap(index,index*2);
		    pushDown(index*2);
		}
		if (data[index*2+1].compareTo(data[index]) > 0){
		    swap(index,index*2+1);
		    pushDown(index*2+1);
		}
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
	    if (isMax){
		if (data[index/2].compareTo(data[index]) > 0){
		    swap(index,index/2);
		    pushUp(index/2);
		}
	    }else{
		if (data[index/2].compareTo(data[index]) < 0){
		    swap(index,index/2);
		    pushUp(index/2);
		}
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
	T temp;
        if (size == 1){
	    temp = data[1];
	    data[size] = null;
	    return null;
	}else{
	    temp = data[1];
	    data[1] = data[size];
	    data[size] = null;
	    pushDown(1);
	}
	size--;
	return temp;
    }
   
    public void add(T x){
	if (size == 0){
	    data[1] = x;
	}else{
	    if (size == data.length-1){
		doubleSize();
	    }
	    data[size+1] = x;
	    pushUp(size+1);
	}
	size++;
    }
   
    private void doubleSize(){
	T[] temp = (T[])new Comparable[size*2+1];
>>>>>>> 408fad0c7e73a8d561bb2a1ae8f01a30e3375522
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
<<<<<<< HEAD
	    }
	    ans += data[x] + ", ";
=======
	    }else{
		ans += data[x] + ", ";
	    }
>>>>>>> 408fad0c7e73a8d561bb2a1ae8f01a30e3375522
	}
	return ans + "]";
    }

<<<<<<< HEAD
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
=======
    public static void main(String[]args){
	
        Integer[] array = {1,5,24,7,15,3,8,4,10,13,6,30,17,9,28};
	MyHeap<Integer> test = new MyHeap(array);
	System.out.println(test);
	
	/*
	MyHeap<Integer> test2 = new MyHeap();
	test2.add(4);
	System.out.println(test2);
	test2.add(9);
	test2.add(-2);
	test2.add(14);
	test2.add(10);
	test2.add(20);
	test2.add(5);
	test2.add(12);
	test2.add(0);
	test2.add(7);
	test2.add(19);
	test2.add(24);
	test2.add(-10);
	test2.add(29);
	test2.add(13);
        System.out.println(test2);
	test2.delete();
	System.out.println(test2);
	*/
	
	MyHeap<Integer> test3 = new MyHeap(array,false);
	//System.out.println(test3.getMax());
	System.out.println(test3);
>>>>>>> 408fad0c7e73a8d561bb2a1ae8f01a30e3375522
    }

}
