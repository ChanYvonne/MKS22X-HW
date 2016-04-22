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
	
	public Node getLeft(){
	    return left;
	}

	public Node getRight(){
	    return right;
	}

	public void setValue(T data){
	    value = data;
	}
	
	public void setLeft(Node n){
	    left = n;
	}

	public void setRight(Node n){
	    right = n;
	}

	public boolean hasChildren(){
	    return !(left == null && right == null);
	}

	public String toString(){
	    return getValue() + " " + toString(left)+ " "+ toString(right);
	}

	private String toString(Node start){
	    if (start == null){
		return "_ ";
	    }
	    if (!(start.hasChildren())){
	        return start.getValue() + "";
	    }
	    return toString(start.getLeft()) + toString(start.getRight());
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
	    return false;
	}
	   
	public int getHeight(){
	    return 1;
	}

    }
    
    Node root;
    
    public BSTree(){
	root = new Node();
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

    

    public static void main(String[] args){
	BSTree<Integer> test = new BSTree<Integer>();
	System.out.println(test);
	test.add(10);
	System.out.println(test);
	test.add(15);
	System.out.println(test);
	test.add(3);
	System.out.println(test);
	test.add(5);
	System.out.println(test);
    }
    
}

