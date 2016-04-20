public class BSTree<T extends comparable<T>>{
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
	
	public String toString(){
	    return this.toString();
	}

	private String toString(Node child){
	    String ans = "";
	    
	    return ans;
	}

	public void add(T value){
	
	}
	
	public boolean contains(T value){
	    return false;
	}
	   
	public int getHeight(){
	    
	}

    }
    
    Node root;

    public String toString(){
	return root.toString();
    }
    
}

