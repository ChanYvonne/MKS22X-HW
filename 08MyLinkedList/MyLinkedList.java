public class MyLinkedList{
    LNode start;
    int size;

    private class LNode{
	int value;
	int next;
	
	public LNode(int val, int nex){
	    value = val;
	    next = nex;
	}
	
	public int getValue(){
	    return value;
	}

	public int getNext(){
	    return next;
	}
	
	public void setValue(int newValue){
	    value = newValue;
	}
	
	public void setNext(int newValue){
	    next = newValue;
	}
    }
    
    public MyLinkedList(LNode s, int length){
        int tempstart = s.getValue();
	int tempnext = s.getNext();
	start = new LNode(tempstart,tempnext);
	size = length;
    }
    
    public String toString(){
	String ans = "[";
	for (int x = 0; x < size(); x++){
	    if (x == size()-1){
		ans += start.getValue();
	    }else{
		ans += Integer.toString(start.getValue()) + ", ";
	    }
	}
	return ans + "]";
    }

    public boolean add(int value){
	boolean ans = false;
	LNode current = start;
        for (int x = 0; x < size(); x++){
	    if (current.getNext() == 0 && x == size()-2){
	        current.setNext(value);
		ans = true;
	    }
	    current.setValue(current.getNext());	    
	}
	start = current;
	return ans;
    }

    public boolean add(int index, int value){
	boolean done = false;
	LNode current = start;
        for (int x = 0; x < size(); x++){
	    current.setValue(current.getNext());
	    if (x == index){
		current.setValue(value);
		done = true;
	    }
	}
	start = current;
	return done;
    }

    public int remove(int index){
	int oldValue = 0;
	LNode current = start;
	for (int x = 0; x < size(); x++){
	    if (x == index){
		oldValue = current.getValue();
	    }else{
		current.setValue(current.getNext());
	    }
	}
	return oldValue;
    }
    
    public int get(int index){
	int value = 0;
	LNode current = start;
        for (int x = 0; x < size(); x++){
	    if (x == index){
		value = current.getValue();
	    }
	    current.setValue(current.getNext());
	}
	start = current;
	return value;
    }
    
    public int set(int index, int newValue){
	int oldValue = get(index);
	LNode current = start;
        for (int x = 0; x < size(); x++){
	    if (x == index-1){
		current.setNext(newValue);
	    }
	    current.setValue(current.getNext());
	}
	start = current;
	return oldValue;
    }

    public int size(){
	return size;
    }

    public int indexOf(int value){
	int ans = -1;
	LNode current = start;
	int count = 0;
	while (count < size() && ans == -1){
	    if (current.getValue() == value){
		ans = count;
	    }
	    count++;
	    current.setValue(current.getNext());
	}
	start = current;
	return ans;
    }

    public static void main(String[]args){
	/*
	LNode sample = new LNode(1,2);
	MyLinkedList test = new MyLinkedList(sample,3);
	System.out.println(test);
	*/
    }
}
