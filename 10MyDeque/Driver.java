import java.util.*;

public class Driver {
    public static void main(String[] args) {
 
        MyDeque<Integer> d = new MyDeque<Integer>();
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

	try{
	    d.removeFirst();
	}catch(NoSuchElementException e){
	    //System.out.println("removeFirst works");
	}

	try{
	    d.removeLast();
	}catch(NoSuchElementException e){
	    //System.out.println("removeLast works");
	}
	
	try{
	    d.getFirst();
	}catch(NoSuchElementException e){
	    //System.out.println("getFirst works");
	}

	try{
	    d.getLast();
	}catch(NoSuchElementException e){
	    //System.out.println("getLast works");
	}

        // Add to the head and to the tail
	Random rand = new Random();
	
        for (int i = 1; i < 20000; i++) {
            Integer n = rand.nextInt(i);
            d.addFirst(n);
            ad.addFirst(n);
	    //System.out.println(d);
	    //System.out.println(ad);	
        }
       
        for (int i = 1; i < 20000; i++) {
            Integer m = rand.nextInt(i*2);
            d.addLast(m);
            ad.addLast(m);
        }

	/*
	System.out.println(d.equals(ad));
	System.out.println(d);
	System.out.println(d.size());
	System.out.println(ad);
	System.out.println(ad.size());
	*/

	System.out.println(d.getFirst());
	System.out.println(ad.getFirst());
	System.out.println(d.getLast());
	System.out.println(ad.getLast());
	
        // Test if adding worked by removing elements
 
        for (int i = 0; i < 20000 && !ad.isEmpty() && !d.isEmpty(); i++) {

	    if (!d.getFirst().equals(ad.getFirst())) {
		System.out.println("addFirst failed at: " + i);
		System.out.println(d.getFirst() + "!=" + ad.getFirst());
		System.exit(0);
	    }
 
	    if (!d.getLast().equals(ad.getLast())) {
		System.out.println("addLast failed at: " + i);
		System.out.println(d.getLast() + "!=" + ad.getLast());
		System.exit(0);
	    }
	    

	    int dFirst = d.getFirst();
	    int dLast = d.getLast();
	    int adFirst = ad.getFirst();
	    int adLast = ad.getLast();
	    
            if (!d.removeFirst().equals(ad.removeFirst())) {
                System.out.println("removeFirst failed at: " + i);
		System.out.println(dFirst + "!=" + adFirst);
                System.exit(0);
            }
 
            if (!d.removeLast().equals(ad.removeLast())) {
                System.out.println("removeLast failed at: " + i);
		System.out.println(dLast + "!=" + adLast);
                System.exit(0);
            }

	    if (d.size() != ad.size()) {
		System.out.println("Unequal sizes: "+ d.size()+ " != " + ad.size());
		System.exit(0);
	    }
        }
 
        System.out.println("Yay it works!!");
	
       
	
    }
 
}
