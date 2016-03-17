public class MyLinkedList{
    private class LNode{
	int value;
	int next;
	
	public LNode(int val){
	    value = val;
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

    LNode start;
    int size;
   
    public String toString(){
	String ans = "[";
	LNode current = start;
        while (current!= 0){
	    ans += start.getValue();
	    if (current.getNext() != null){
		ans+= ", "
	    }
	    current = current.getNext();
	}
	return ans + "]";
    }

    public boolean add(int value){
	boolean ans = false;
	if (start == null){
	    start = new LNode(value);
	}else{
	    LNode current = start;
	}	
	
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
	MyLinkedList test = new MyLinkedList();
	int i = 0;
	while(i < 100){
	    test.add(i);
	    i++;
	}
	test.add(54);
	test.add(-10);
	test.add(47);
	System.out.println(test);
    }
}
