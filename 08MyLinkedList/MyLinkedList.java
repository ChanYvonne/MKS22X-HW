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
	
	public int value(){
	    return value;
	}

	public int next(){
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
        int tempstart = s.value();
	int tempnext = s.next();
	start = new LNode(tempstart,tempnext);
	size = length;
    }
    
    public String toString(){
	String ans = "[";
	for (int x = 0; x < size(); x++){
	    if (x == size()-1){
		ans += start[x].value();
	    }else{
		ans += Integer.parseInt(start[x].value()) + ", ";
	    }
	}
	return ans + "]";
    }

    public boolean add(int value){
	boolean ans = false;
        for (int x = 0; x < size(); x++){
	    if (start[x].next() == 0){
		start[x].setNext(value);
	    }
	}
	return ans;
    }
    
    public int get(int index){
	return start[index].getValue();
    }
    
    public int set(int index, int newValue){
	int oldValue = get(index);
	start[index] = newValue;
	return oldValue;
    }

    public int size(){
	return size;
    }
 
    public int remove(int index){
	int oldValue = 0;
	for (int x = 0; x < size(); x++){
	    if (x == index){
		oldValue = start[x].getValue;
		
	    }
	}
    }
}
