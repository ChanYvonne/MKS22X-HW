import java.util.*;

public class MyDeque<T>{
    T[] data;
    int size;
    int start;
    int end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (T[])new Object[5];
    }
    
    public void addFirst(T value){
	if (size == data.length){
	    resize();
	}
	if (start == 0 && size > 0){
	    start = data.length-1;
	}
	if (!(start == 0)){
	    start--;
	}
	data[start] = value;
	size++;
    }

    public void addLast(T value){
	if (size == data.length){
	    resize();
	}
	if (end == data.length-1){ //|| data[end] == null){
	    end = 0;
	}else{
	    end++;
	}
	data[end] = value;
	size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	T[] temp = (T[]) new Object[size*2];
	int shift = 0;
	for (int x = 0; x < size; x++){
	    if (x + start > size){
		temp[x] = data[x-shift];
	    }else{
		temp[x] = data[x+start];
		shift++;
	    }
	}
	data = temp;
	start = 0;
	end = size;
	size *= 2;
    }

    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	int tempfirst = start;
	if (start == size - 1){
	    start = 0;
	}else{
	    start++;
	}
	size--;
	return data[tempfirst];
    }

    public T removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	int tempend = end;
	if (end == 0){
	    end = size - 1;
	}else{
	    end--;
	}
	size--;
	return data[tempend];
	
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

    public String toString(){
	String ans = "[";
	for (int x = 0; x < data.length; x++){
	    if (x == data.length-1){
		ans += data[x];
	    }else{
		ans += data[x] + ",";
	    }
	}
	return ans + "]";
    }

    public void debug(){
	System.out.println("size: "+size+" start: "+start+" end: "+end);
    }
    
    public static void main(String[]args){
	MyDeque<Integer> test = new MyDeque<Integer>();
	test.addFirst(4);
	test.addFirst(7);
	System.out.println(test);
	test.addLast(8);
	test.resize();
	System.out.println(test);
	test.addFirst(1);
	System.out.println(test);
	test.removeFirst();
	System.out.println(test);
	test.removeLast();
	System.out.println(test);
	System.out.println(test.getFirst());
	System.out.println(test.getLast());
	
    }
}
