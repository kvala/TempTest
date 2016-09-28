package test;
//sqrt(n+1) = (sqrtn + num/sqrtn) /2
public class Sqrt {

	public static double sqrt(Double number) throws Exception {
		if(number<0)
			throw new Exception("Invalid input");
		double t;
	 
		double squareRoot = number / 2;
	 
		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);
	 
		return squareRoot;
	}
	
	public static void main(String args[]) throws Exception {

		System.out.println(sqrt(3.2));

	}
}
