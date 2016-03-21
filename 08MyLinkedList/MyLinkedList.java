import java.util.*;

public class MyLinkedList{
    private class LNode{
	int value;
	LNode next;
	
	public LNode(int val){
	    value = val;
	}
	
	public int getValue(){
	    return value;
	}

	public LNode getNext(){
	    return next;
	}
	
	public void setValue(int newValue){
	    value = newValue;
	}
	
	public void setNext(LNode newValue){
	    next = newValue;
	}
    }

    LNode start;
    LNode last;
    int size;
   
    public String toString(){
	String ans = "[";
	LNode current = start;
        while (current != null){
	    ans += current.getValue();
	    if (current.getNext() != null){
		ans+= ", ";
	    }
	    current = current.getNext();
	}
	return ans + "]";
    }

    public boolean add(int value){
	if (start == null){
	    start = new LNode(value);
	    last = start;
	}else{
	    LNode temp = new LNode(value);
	    last.setNext(temp);
	    last = last.getNext();
	}
        size++;
	//start = current;
	return true;
    }

    public boolean add(int index, int value){
	LNode current = start;
	int count = 0;
	LNode temp = new LNode(value);
	if (index == 0){
	    temp.setNext(current);
	    start = temp;
	}else{
	    while (count < index-1){
		current = current.getNext();
		count++;
	    }
	    LNode next = current.getNext();
	    temp.setNext(next);
	    current.setNext(temp);
	}
	size++;
	return true;
    }

    public int remove(int index){
	int oldValue = -1;
	LNode current = start;
	int count = 0;
	//LNode temp = current.getNext();
	if (index == 0){
	    oldValue = current.getValue();
	    start = start.getNext();
	}else{
	    while (current.getNext()!= null){
		if (count == index-1){
		    oldValue = (current.getNext()).getValue();
		    current.setNext((current.getNext()).getNext());
		}
		current = current.getNext();
		count++;
	    }
	}
	size--;
	return oldValue;
    }
    
    public int get(int index){
	int value = 0;
	LNode current = start;
	int count = 0;
        while (count != index){
	    current = current.getNext();
	    count++;
	}
	value = current.getValue();
	return value;
    }
    
    public int set(int index, int newValue){
	int oldValue = get(index);
	LNode current = start;
        int count = 0;
        while (current.getNext() != null){
	    if (count == index){
		oldValue = current.getValue();
		current.setValue(newValue);
	    }
	    current = current.getNext();
	    count++;
	}
	return oldValue;
    }

    public int size(){
	return size;
    }

    public int indexOf(int value){
	int index = 0;
	LNode current = start;
	while (current.getValue() != value){
	    current = current.getNext();
	    index++;
	}
	return index;
    }

    public static void printArray(int[]data){
        String ans = "";
	for (int x = 0; x < data.length; x ++){
	    if (x == data.length-1){
		ans+= " " + data[x];
	    }else{
		ans+= " " + data[x] + ",";
	    }
	}
	System.out.println("[" + ans + "]");	
    }

    public static void main(String[]args){
	/*
	MyLinkedList test = new MyLinkedList();
	System.out.println(test);
	int i = 0;
	while(i < 10){
	    test.add(i);
	    i++;
	}
	test.add(54);
	test.add(-10);
	test.add(47);
	test.add(6);
	System.out.println(test);
	System.out.println(test.get(3));
	System.out.println(test.set(7,99));
	System.out.println(test);
	System.out.println(test.indexOf(9));
	System.out.println(test.remove(4));
	System.out.println(test);
	System.out.println(test.add(8,23));
	System.out.println(test);
	System.out.println(test.remove(0));
	System.out.println(test);
	System.out.println(test.add(0,31));
	System.out.println(test);
	*/
	/*
	MyLinkedList m = new MyLinkedList();
	ArrayList<Integer> n = new ArrayList<Integer>();

	long start,end;

	start = System.currentTimeMillis();
	for (long x = 0; x < 100;x++){
	    n.add(Math.random()*1000); 
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for ArrayList");
	printArray(n);

	start = System.currentTimeMillis();
        for (long i = 0; i < 100;i++){
	    m.add(Math.random()*1000); 
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");
	System.out.println(m);
	*/
    }
}

/* 
notes from class:

set/get(index i) --> O(i)
size --> O(1)
add/remove(v,index i) --> O(i) --> modifying the front O(1)
add(v) --> O(1)
indexOf(v)-->0(n)
*/
