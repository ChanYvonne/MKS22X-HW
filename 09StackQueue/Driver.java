import java.util.*;
public class Driver{
    public static void main(String[]args){
	MyLinkedList<String> m = new MyLinkedList<String>();
        ArrayList<String>    n = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            n.add(""+i);
            m.add(""+i);
        }

        try{
            m.add(-1,"oops");
            System.out.println("\n\nAdd -1 #####################################");
        }catch(IndexOutOfBoundsException e){

        }
        try{
            m.add(12,"oops");
            System.out.println("\n\n add 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }
        try{
            m.remove(12);
            System.out.println("\n\n remove 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }

        try{
            m.set(12,"Fwazzat?!?");
            System.out.println("\n\n set 12 #####################################");
        }catch(IndexOutOfBoundsException e){
	    
        }





        //replace toString(true) with a debug to string that shows the head/tail
        System.out.println(m.toString(true));
        System.out.println(n);

        //test removing from head/tail/middle
        m.remove(0);
        n.remove(0);
        System.out.println(m.toString(true));

        m.remove(2);
        n.remove(2);
        System.out.println(m.toString(true));

        m.remove(m.size()-1);
        n.remove(n.size()-1);
        System.out.println(m.toString(true));
        System.out.println(n);

        //test adding to end/start
        m.add(0,"START");
        n.add(0,"START");
        m.add(m.size(),"PENULTIMATE");
        n.add(n.size(),"PENULTIMATE");
        System.out.println(m.toString(true));
        System.out.println(n);

        //test add
        m.add("Z-END!");
        n.add("Z-END!");
        System.out.println(m.toString(true));
        System.out.println(n);

        //test remove random items:
        Random rand = new Random(0);
        for(int i = 0; i < 6000; i++){
            int op = rand.nextInt(4);

            if(op == 0){//ensure never empty
                n.add(""+i);
                m.add(""+i);
	    }else if(op == 1 || m.size() == 0 || n.size() == 0){
		int x;
		if (m.size() == 0 || m.size() == 1){
		    x = rand.nextInt(n.size()+1);
		}else{
		    x = rand.nextInt(n.size());
		}
		System.out.println(x);
		System.out.println(m.size());
                n.add(x,""+i);
                m.add(x,""+i);
            }else{
                int x = rand.nextInt(n.size());
		System.out.println(x);
		System.out.println(m.size());
		/*
		String tenp = n.remove(x);
	        String temp = m.remove(x);
		System.out.println(tenp);
		System.out.println(temp);
		if (!(tenp.equals(temp))){
		*/
                if(!n.remove(x).equals(m.remove(x))){
                    System.out.println("Non matching elements removed\n");
                    System.exit(1);
                }
            }
        }
        System.out.println(m.toString(true));
        System.out.println(n);


	/*
	MyLinkedList<Integer> m = new MyLinkedList<Integer>();
	ArrayList<Integer> n = new ArrayList<Integer>();

	long start,end;

	start = System.currentTimeMillis();
	for (int x = 0; x < 10000;x++){
	    n.add(x); 
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for ArrayList");
        

	start = System.currentTimeMillis();
        for (int i = 0; i < 10000;i++){
	    m.add(new Integer(i)); 
	}
	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	start = System.currentTimeMillis();
	for (int x = 0; x < 10000;x++){
	    n.size(); 
	}
	end = System.currentTimeMillis();
	System.out.println("size time: " + (end-start)/1000.0 + " seconds for ArrayList");
        

	start = System.currentTimeMillis();
        for (int i = 0; i < 10000;i++){
	    m.size(); 
	}
	end = System.currentTimeMillis();
	System.out.println("size time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	start = System.currentTimeMillis();
	for (int x = 0; x < 10000;x++){
	    n.add(0,7); 
	}
	end = System.currentTimeMillis();
	System.out.println("add Time: " + (end-start)/1000.0 + " seconds for ArrayList");
        

	start = System.currentTimeMillis();
        for (int i = 0; i < 10000;i++){
	    m.add(0,new Integer(10)); 
	}
	end = System.currentTimeMillis();
	System.out.println("add Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

	
	start = System.currentTimeMillis();
	for (int x = 0; x < 10000;x++){
	    n.remove(0); 
	}
	end = System.currentTimeMillis();
	System.out.println("remove time: " + (end-start)/1000.0 + " seconds for ArrayList");
        

	start = System.currentTimeMillis();
        for (int i = 0; i < 10000;i++){
	    m.remove(0); 
	}
	end = System.currentTimeMillis();
	System.out.println("remove time: " + (end-start)/1000.0 + " seconds for MyLinkedList");
	*/
    }
}
