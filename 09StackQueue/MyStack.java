public class MyStack<T>{
    private MyLinkedList<T> start;
    private int size;
    
    /**
     * Adds the given item to the top of the stack.
     */
    public void push(T item){
	start.add(0,item);
	size++;
    }
    
    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop(){
	if (isEmpty()){
	    throw new NoSuchElementException();
	}else{
	    T old = start.get(0);
	    start.remove(0);
	    return old;
	    size--;
	}
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if (isEmpty()){
	    throw new NoSuchElementException();
	}else{
	    return start.get(0);
	}
    }

    /**
     * Returns the number of items currently in the stack.
     */
    public int size(){
	return size;
    }

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty(){
	return start == null;
    }

    public static void main(String[]args){
	MyStack<String> test = new MyStack<String>();
	test.push(7);
	test.push(6);
	test.push(8);
	test.push(4);
	test.push(1);
	test.push(5);
	test.push(9);
	System.out.println(test.pop());
	System.out.println(test.isEmpty());
	System.out.println(test.peek());
	
    }
}
