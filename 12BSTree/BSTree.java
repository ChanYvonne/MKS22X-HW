public class BSTree<T extends Comparable<T>>{
    private class Node{
	Node left,right;
	T value;

	public Node(T data){
	    value = data;
	}
	
	public T getValue(){
	    return value;
	}
	
	public Node getLeft(){
	    return left;
	}

	public Node getValue(){
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
	    String ans = "_";
	    if (start.hasChildren()){
		ans += start.getValue() + " ";
	    }
	    return ans;
	}

	public void add(T value){
	    
	}
	
	public boolean contains(T value){
	    return false;
	}
	   
	public int getHeight(){
	    return 1;
	}

    }
    
    Node root;
    
    public BSTree(T data){
	root = new Node(data);
    }


    public String toString(){
	return root.toString();
    }

    

    public static void main(String[] args){
	BSTree<Integer> test = new BSTree<Integer>(4);
	System.out.println(test);
    }
    
}

