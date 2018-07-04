package test;

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println(fibsum(3));

	}

	// Iterative.
	public static void fib(int number) {
		int s1 = 1, s2 = 1, temp;
		if (number == 1) {
			System.out.print(s1);
			return;
		}

		if (number == 2) {
			System.out.print(s1 + " " + s2 + " ");
			return;
		}

		System.out.print(s1 + " " + s2 + " ");

		for (int i = 2; i <= number; i++) {
			temp = s1 + s2;
			s1 = s2;
			s2 = temp;

			System.out.print(s2 + " ");
		}
	}

	public static int fibRecursive(int number) {

		if (number <= 1) {
			return 1;
		}
		return fibRecursive(number - 1) + fibRecursive(number - 2);
	}

	public static int fibsum(int number) {
		int s1 = 1, s2 = 1, temp;

		for (int i = 2; i < number; i++) {
			temp = s1 + s2;
			s1 = s2;
			s2 = temp;
		}

		return s2;
	}

	static int fibDynamic(int n) {

		int f[] = new int[n + 1];
		int i;

		f[0] = 0;
		f[1] = 1;

		for (i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n];
	}

}
