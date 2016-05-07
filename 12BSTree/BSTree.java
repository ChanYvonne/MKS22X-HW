import java.util.*;

public class BSTree<T extends Comparable<T>>{
    private class Node{
	Node left,right;
	T value;
	
	public Node(){
	}
	
	public Node(T data){
	    value = data;
	}
	
	public T getValue(){
	    return value;
	}
	
        private Node getLeft(){
	    return left;
	}

        private Node getRight(){
	    return right;
	}

	public void setValue(T data){
	    value = data;
	}
	
        private void setLeft(Node n){
	    left = n;
	}

        private void setRight(Node n){
	    right = n;
	}

	public boolean hasChildren(){
	    return !(left == null && right == null);
	}

	public String toString(){
	    return getValue() + " " + toString(left) + " "+ toString(right);
	}

	private String toString(Node start){
	    if (start == null){
		return "_ ";
	    }
	    if (!(start.hasChildren())){
	        return start.getValue() + " _ _ ";
	    }
	    return start.getValue() + " " + toString(start.getLeft()) + toString(start.getRight());
	}

	public void add(T data){
	    if (value == null){
		value = data;
	    }else if (value.compareTo(data) > 0){
		if (left == null){
		    left = new Node(data);
		}else{
		    left.add(data);
		}
	    }else{
		if (right == null){
		    right = new Node(data);
		}else{
		    right.add(data);
		}
	    }
	}
	
	public boolean contains(T value){
	    if (this.value == value){
		return true;
	    }
	    if (value.compareTo(this.value) > 0){
		if (right != null){
		    return right.contains(value);
		}
	    }else{
		if (left != null){
		    return left.contains(value);
		}
	    }
	    return false;
	}
	   
	public int getHeight(){
	    int rheight = 1;
	    int lheight = 1;
	    if (!hasChildren()){
	    	return 1;
	    }
	    if (left != null){	
	        lheight += left.getHeight();
	    }
	    if (right != null){
		rheight += right.getHeight();
	    }
	    return Math.max(rheight,lheight);
	}

	private Node getParent(T value){ // tried it this way but it didn't work
	    Node guardian = new Node();
	    if (value.compareTo(this.value) > 0){
		if (right != null && right.getValue() == value){
		    return new Node(value);
		}
	    }else{
		if (left != null){
		    return new Node(value);
		}
	    }
	    return guardian;
	}
	
	public void remove(T value){
	    Node righty;
	    Node lefty;
	    if (this.value == null){
		
	    }else{
	    if (right != null && right.getValue() == value){
		righty = right.getRight();
		lefty = right.getLeft();
		if (!hasChildren()){
		    setRight(null); 
		}
		if (lefty == null){
		    setRight(righty);
		}
		if (righty == null){
		    setRight(lefty);
		}
		if (Math.min(lefty.getHeight(),righty.getHeight()) == lefty.getHeight()){
		    setRight(righty);
		}else{
		    setRight(lefty);
		}
	    }	
	    if (left != null && left.getValue() == value){
		righty = left.getRight();
		lefty = left.getLeft();
		if (!hasChildren()){
		    setLeft(null);
		}
		if (lefty == null){
		    setLeft(righty);
		}
		if (righty == null){
		    setLeft(lefty);
		}
		if (Math.min(lefty.getHeight(),righty.getHeight()) == lefty.getHeight()){
		    setLeft(righty);
		}else{
		    setLeft(lefty);
		} 
	    }
	    if (value.compareTo(this.value) > 0){
		if (right != null){
		    right.remove(value);
		}	
	    }else{
		if (left != null){
		    left.remove(value);
		}
	    }
	    }
	}
	
    }
    
    Node root;
    
    public BSTree(){
	root = new Node();
    }

     public int getHeight(){
	if (root == null){
	    return 0;
	}
	return root.getHeight();
    }
    
    public void add(T value){
	root.add(value);
    }

    public String toString(){
	if (root == null){
	    return "";
	}
	return root.toString();
    }

    public boolean contains(T value){
	if (root == null){
	    return false;
	}
	return root.contains(value);
    }

    public void remove(T value){
	if (contains(value)){
	    root.remove(value);
	}else{
	    throw new NoSuchElementException("not here!");
	}
    }    
    

    public static void main(String[] args){
	BSTree<Integer> test = new BSTree<Integer>();
	System.out.println(test);
	test.add(20);
	System.out.println(test);
	test.add(39);
	System.out.println(test);
	test.add(15);
	System.out.println(test);
	test.add(3);
	System.out.println(test);
	test.add(11);
	System.out.println(test);
	test.add(9);
	System.out.println(test);
	test.add(19);
	System.out.println(test);
	test.add(10);
	System.out.println(test);
	test.add(86);
	System.out.println(test);
	System.out.println(test.contains(-1));
	System.out.println(test.contains(15));
	System.out.println(test.contains(9));
	System.out.println(test.contains(5));
	System.out.println(test.getHeight());
	test.remove(15);
	System.out.println(test);
	test.remove(9);
	System.out.println(test);
	test.remove(1);
    }
    
}

