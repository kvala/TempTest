package test;

//sqrt(n+1) = (sqrtn + num/sqrtn) /2
public class Sqrt {

	public static double sqrt(Double number) throws Exception {
		if (number < 0)
			throw new Exception("Invalid input");
		double t;

		double squareRoot = number / 2;

		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);

		return squareRoot;
	}

	public static int floorSqrt(int x) {
		// Base Cases
		if (x == 0 || x == 1)
			return x;

		// Do Binary Search for floor(sqrt(x))
		int start = 1, end = x, ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			// If x is a perfect square
			if (mid * mid == x)
				return mid;

			// Since we need floor, we update answer when mid*mid is
			// smaller than x, and move closer to sqrt(x)
			if (mid * mid < x) {
				start = mid + 1;
				ans = mid;
			} else // If mid*mid is greater than x
				end = mid - 1;
		}
		return ans;
	}

	public static void main(String args[]) throws Exception {

		System.out.println(sqrt(3.2));
		System.out.println(floorSqrt(3));

	}
}
