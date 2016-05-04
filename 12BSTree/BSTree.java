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
	        return start.getValue() + " _ _ ";
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
	    if (!hasChildren() && this.value == value){
	        return true;
	    }else if (hasChildren()){
	    	return left.getValue() == value || right.getValue() == value;
	    }else{
	    	return contains(left) || contains(right);
	    }
	}
	   
	public int getHeight(){
	    int rheight = 1;
	    int lheight = 1;
	    Node ltemp = new Node();
	    ltemp = left;
	    Node rtemp = new Node();
	    rtemp = right;
	    if (!hasChildren()){
	    	return 1;
	    }
	    while (left.hasChildren()){
	    	lheight++;
	    }
	    while (right.hasChildren()){
	    	rheight++;
	    }
	    if (rheight > lheight){
	    	return rheight;
	    }else{
	    	return lheight;
	    }
	}

	public T remove(T value){
	    if (!contain(value)){
	    	return null;
	    }
	    return value;
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
	return root.height();
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

