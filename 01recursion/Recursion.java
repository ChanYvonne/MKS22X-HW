public class Recursion{
    public String name(){
	return "Chan,Yvonne";
    }

    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelp(n, n/2);
    }

    public double sqrtHelp(double n, double guess){
	if (Math.abs(guess*guess - n)/n < 0.000000001){
	    return guess;
	}
	return sqrtHelp(n,(n/guess + guess)/2);
    }

    public static void main(String[]args){
	Recursion test = new Recursion();
	System.out.println(test.sqrt(100));
	System.out.println(test.sqrt(24));
	System.out.println(test.sqrt(94));
	System.out.println(test.sqrt(-64));
    }
    
}
