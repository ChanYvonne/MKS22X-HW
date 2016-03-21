import java.util.*;
public class Driver{
    public static void main(String[]args){
	MyLinkedList m = new MyLinkedList();
	ArrayList<Integer> n = new ArrayList<Integer>();

	long start,end;

	start = System.currentTimeMillis();
	for (int x = 0; x < 1000000;x++){
	    n.add(x); 
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for ArrayList");
        

	start = System.currentTimeMillis();
        for (int i = 0; i < 1000000;i++){
	    m.add(i); 
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	start = System.currentTimeMillis();
	for (int x = 0; x < 1000000;x++){
	    n.size(); 
	}
	end = System.currentTimeMillis();
	System.out.println("size time: " + (end-start)/1000.0 + " seconds for ArrayList");
        

	start = System.currentTimeMillis();
        for (int i = 0; i < 1000000;i++){
	    m.size(); 
	}
	end = System.currentTimeMillis();
	System.out.println("size time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	start = System.currentTimeMillis();
	for (int x = 0; x < 1000000;x++){
	    n.add(0,7); 
	}
	end = System.currentTimeMillis();
	System.out.println("add Time: " + (end-start)/1000.0 + " seconds for ArrayList");
        

	start = System.currentTimeMillis();
        for (int i = 0; i < 1000000;i++){
	    m.add(0,10); 
	}
	end = System.currentTimeMillis();
	System.out.println("add Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	
	start = System.currentTimeMillis();
	for (int x = 0; x < 1000000;x++){
	    n.remove(0); 
	}
	end = System.currentTimeMillis();
	System.out.println("remove time: " + (end-start)/1000.0 + " seconds for ArrayList");
        

	start = System.currentTimeMillis();
        for (int i = 0; i < 1000000;i++){
	    m.remove(0); 
	}
	end = System.currentTimeMillis();
	System.out.println("remove time: " + (end-start)/1000.0 + " seconds for MyLinkedList");
    }
}
