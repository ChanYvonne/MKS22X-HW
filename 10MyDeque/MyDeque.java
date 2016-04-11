import java.util.*;

public class MyDeque<T>{
    private T[] data;
    private int size,start,end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (T[])new Object[5];
    }
    
    public void addFirst(T value){
	if (size == data.length){
	    resize();
	}
	
	if (start == 0){
	    if (data[start] != null){
		start = data.length-1;
	    }
	}else{
	    start--;
	}
	data[start] = value;
	size++;
    }

    public void addLast(T value){
	if (size == data.length){
	    resize();
	}
	if (end == data.length-1){ //data[end] == null){
	    end = 0;
	}else{
	    end++;
	}
	data[end] = value;
	size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(){ //had help from Alvin Zhu (Pd 6)
	T[] temp = (T[]) new Object[size*2];
	int count = 0;
	int index = start;

	while (count < data.length){
	    if (index == data.length){
		index = 0;
	    }
	    temp[count] = data[index];
	    count++;
	    index++;
	}
	
	data = temp;
	start = 0;
	end = size-1;
	/*
	if (size > 0){
	    end = size - 1;
	}else{
	    end = count;
	}
	*/
	size *= 2;
    }

    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
        T tempfirst = data[start];
	data[start] = null;
	if (start == data.length - 1){
	    start = 0;
	}else{
	    start++;
	}
	size--;
	return tempfirst;
    }

    public T removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	//System.out.println(end);
        T tempend = data[end];
	data[end] = null;
	if (end == 0){
	    end = size - 1;
	}else{
	    end--;
	}
	size--;
	return tempend;
	
    }

    public T getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public T getLast(){	
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[end];
    }

    public int size(){
	return size;
    }

    public String toString(){
	String ans = "[";
	for (int x = 0; x < data.length; x++){
	    if (x == data.length-1){
		ans += data[x];
	    }else{
		ans += data[x] + ", ";
	    }
	}
	return ans + "]";
    }

    public void debug(){
	System.out.println("size: "+size+" start: "+start+" end: "+end);
    }
    
    public static void main(String[]args){
	MyDeque<Integer> test = new MyDeque<Integer>();
	test.addLast(2);
	System.out.println(test);
	test.addFirst(4);
	test.addFirst(7);
	System.out.println(test);
	test.addLast(8);
	System.out.println(test);	
	test.addFirst(1);
	System.out.println(test);
	test.addFirst(9);
	System.out.println(test);
	test.addLast(3);
	System.out.println(test);
        test.removeFirst();
	System.out.println(test);
	test.removeLast();
	System.out.println(test);
	System.out.println(test.getFirst());
	System.out.println(test.getLast());
	test.addFirst(19);
	test.addFirst(52);
	test.addFirst(13);
	test.addFirst(6);
	System.out.println(test);
	test.addFirst(11);
	System.out.println(test);
	test.addFirst(26);
	System.out.println(test);
	test.addFirst(32);
	System.out.println(test);
	test.addFirst(41);
	System.out.println(test);
	
    }
}
