public class ParenDemo{
    public static boolean isMatching(String s){
	MyStack<String> plate = new MyStack<String>();
	for (int x = 0; x < s.length(); x++){
	    if (s.substring(x,x+1).equals("<") || 
		s.substring(x,x+1).equals("(") ||
		s.substring(x,x+1).equals("{") ||
		s.substring(x,x+1).equals("[")){
		plate.push(s.substring(x,x+1));
	    }	        
	    if (s.substring(x,x+1).equals(">")){
		if (!(plate.isEmpty()) && plate.peek().equals("<")){
		    plate.pop();
		}else{
		    plate.push(s.substring(x,x+1));
		}
	    }
	    if (s.substring(x,x+1).equals("}")){
		if (!(plate.isEmpty()) && plate.peek().equals("{")){
		    plate.pop();
		}else{
		    plate.push(s.substring(x,x+1));
		}
	    }
	    if (s.substring(x,x+1).equals("]")){
		if (!(plate.isEmpty()) && plate.peek().equals("[")){
		    plate.pop();
		}else{
		    plate.push(s.substring(x,x+1));
		}
	    }
	    if (s.substring(x,x+1).equals(")")){
		if (!(plate.isEmpty()) && plate.peek().equals("(")){
		    plate.pop();
		}else{
		    plate.push(s.substring(x,x+1));
		}
	    }
	    //System.out.println(plate.printStack());
	}
        return plate.isEmpty();
    }
    
    public static void main(String[]args){
	String input = "";
	if (args.length > 0){
	    input = args[0];
	    System.out.println(isMatching(input));
	}
    }
}
