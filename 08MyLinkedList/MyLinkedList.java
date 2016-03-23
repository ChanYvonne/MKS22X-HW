<<<<<<< HEAD
import java.util.*;

public class MyLinkedList<T>{
    private class LNode{
        T value;
	LNode next;
	
	public LNode(T val){
	    value = val;
	}
	
	public T getValue(){
	    return value;
	}

	public LNode getNext(){
	    return next;
	}
	
	public void setValue(T newValue){
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

    public boolean add (T value){
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

    public boolean add(int index, T value){
	LNode current = start;
	int count = 0;
	LNode temp = new LNode(value);
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}else if (index == 0){
	    start = temp;
	    start.setNext(current);
	    size++;
	}else if (index == size){
	    add(value);
	}else{
	    while (count < index-1){
		current = current.getNext();
		count++;
	    }
	    LNode next = current.getNext();
	    temp.setNext(next);
	    current.setNext(temp);
	    size++;
	}
	return true;
    }

    public T remove(int index){
        T oldValue;
	LNode current = start;
	int count = 0;
	//LNode temp = current.getNext();
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}else if (index == 0){
	    oldValue = current.getValue();
	    start = start.getNext();
	    size--;
	}else if (index == size - 1){
	    while (count < size - 2){
		current = current.getNext();
		count++;
	    }
	    oldValue = (current.getNext()).getValue();
	    current.setNext(null);
	    last = current;
	    size--;
	}else{
	    while (count < index-1){
		current = current.getNext();
		count++;
	    }
	    oldValue = (current.getNext()).getValue();
	    current.setNext((current.getNext()).getNext());
	    size--;
	}
	return oldValue;
    }
    
    public T get(int index){
        T value;
	LNode current = start;
	int count = 0;
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}else{
	    while (count != index){
		current = current.getNext();
		count++;
	    }
	    value = current.getValue();
	}
	return value;
    }
    
    public T set(int index, T newValue){
        T oldValue = get(index);
	LNode current = start;
        int count = 0;
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}else{
	    while (current.getNext() != null){
		if (count == index){
		    oldValue = current.getValue();
		    current.setValue(newValue);
		}
		current = current.getNext();
		count++;
	    }
	}
	return oldValue;
    }

    public int size(){
	return size;
    }

    public int indexOf(T value){
	int index = 0;
	LNode current = start;
	while (!(current.getValue().equals(value))){
	    current = current.getNext();
	    index++;
	}
	if (index >= size){
	    return -1;
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

    public String toString(boolean test){
	String ans = "";
	if (test){
	    ans+= this.toString()+" head: " + start.getValue() + " tail: " + last.getValue();
	}
	return ans;
    }

    public static void main(String[]args){
	
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	System.out.println(test);
	int i = 0;
	while(i < 10){
	    test.add(new Integer(i));
	    i++;
	}
	test.add(new Integer(54));
	test.add(new Integer(-10));
	test.add(new Integer(47));
	test.add(new Integer(6));
	System.out.println(test);
	System.out.println(test.get(3));
	System.out.println(test.set(7,new Integer(99)));
	System.out.println(test);
	System.out.println(test.indexOf(new Integer(9)));
	System.out.println(test.remove(4));
	System.out.println(test);
	//System.out.println(test.add(-1,new Integer(23)));
	System.out.println(test);
	System.out.println(test.size());
	System.out.println(test.remove(12));
	System.out.println(test);
	//System.out.println(test.add(40,new Integer(31)));
	System.out.println(test);
	
	
	
	
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
=======
import java.util.*;

public class MyLinkedList<T>{
    private class LNode{
        T value;
	LNode next;
	
	public LNode(T val){
	    value = val;
	}
	
	public T getValue(){
	    return value;
	}

	public LNode getNext(){
	    return next;
	}
	
	public void setValue(T newValue){
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

    public boolean add (T value){
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

    public boolean add(int index, T value){
	LNode current = start;
	int count = 0;
	LNode temp = new LNode(value);
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}else if (index == 0){
	    start = temp;
	    start.setNext(current);
	    size++;
	}else if (index == size){
	    add(value);
	}else{
	    while (count < index-1){
		current = current.getNext();
		count++;
	    }
	    LNode next = current.getNext();
	    temp.setNext(next);
	    current.setNext(temp);
	    size++;
	}
	return true;
    }

    public T remove(int index){
        T oldValue;
	LNode current = start;
	int count = 0;
	//LNode temp = current.getNext();
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}else if (index == 0){
	    oldValue = current.getValue();
	    start = start.getNext();
	    size--;
	}else if (index == size - 1){
	    while (count < size - 2){
		current = current.getNext();
		count++;
	    }
	    oldValue = (current.getNext()).getValue();
	    current.setNext(null);
	    last = current;
	    size--;
	}else{
	    while (count < index-1){
		current = current.getNext();
		count++;
	    }
	    oldValue = (current.getNext()).getValue();
	    current.setNext((current.getNext()).getNext());
	    size--;
	}
	return oldValue;
    }
    
    public T get(int index){
        T value;
	LNode current = start;
	int count = 0;
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}else{
	    while (count != index){
		current = current.getNext();
		count++;
	    }
	    value = current.getValue();
	}
	return value;
    }
    
    public T set(int index, T newValue){
        T oldValue = get(index);
	LNode current = start;
        int count = 0;
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}else{
	    while (current.getNext() != null){
		if (count == index){
		    oldValue = current.getValue();
		    current.setValue(newValue);
		}
		current = current.getNext();
		count++;
	    }
	}
	return oldValue;
    }

    public int size(){
	return size;
    }

    public int indexOf(T value){
	int index = 0;
	LNode current = start;
	while (!(current.getValue().equals(value))){
	    current = current.getNext();
	    index++;
	}
	if (index >= size){
	    return -1;
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

    public String toString(boolean test){
	String ans = "";
	if (test){
	    ans+= this.toString()+" head: " + start.getValue() + " tail: " + last.getValue();
	}
	return ans;
    }

    public static void main(String[]args){
	
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	System.out.println(test);
	int i = 0;
	while(i < 10){
	    test.add(new Integer(i));
	    i++;
	}
	test.add(new Integer(54));
	test.add(new Integer(-10));
	test.add(new Integer(47));
	test.add(new Integer(6));
	System.out.println(test);
	System.out.println(test.get(3));
	System.out.println(test.set(7,new Integer(99)));
	System.out.println(test);
	System.out.println(test.indexOf(new Integer(9)));
	System.out.println(test.remove(4));
	System.out.println(test);
	//System.out.println(test.add(-1,new Integer(23)));
	System.out.println(test);
	System.out.println(test.size());
	System.out.println(test.remove(12));
	System.out.println(test);
	//System.out.println(test.add(40,new Integer(31)));
	System.out.println(test);
	
	
	
	
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
>>>>>>> 5ae799ac3d63abc071598be70136b2218298bb53
