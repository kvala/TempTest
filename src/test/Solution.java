package test;

public class Solution {

	public static void main(String[] args) {

		// int[] t = { -1, -9, -6, 8, 5, 9 };
		// System.out.println(solution(t));

		// int[] t = { 0, 0, 0, 1, 0, 0 };

		int[] t = { 1, 1, 0, 1, 0, 0 };
		// int[] t = { 0, 0, 0 };
		System.out.println(solution2(t));
		System.out.println(flipCoin((t)));
	}

	public static int solution(int[] A) {

		if (A == null) {
			return 0;
		}
		int count = 0;
		boolean flag = false;
		int outoforder = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i + 1] < A[i] && !flag) {
				flag = true;
				outoforder = i;
			}
			if (flag) {
				if (A[outoforder] < A[i]) {
					return count;
				}
				count++;
			}
		}

		return 0;
	}

	public static int solution2(int[] A) {
		int n = A.length;
		int result = 0;
		
		for (int i = 0; i < n - 1; i++) {
			if (A[i] == A[i + 1])
				result = result + 1;
			
		}
		

		int r = 0;
		for (int i = 0; i < n; i++) {
			int count = 0;
			if (i > 0) {
				if (A[i - 1] != A[i])
					count = count + 1;
				else
					count = count - 1;
			}
			if (i < n - 1) {
				if (A[i + 1] != A[i])
					count = count + 1;
				else
					count = count - 1;
			}

			r = Math.max(r, count);

		}
		return result + r;
	}

	public static int test(int[] A) {
		int inputsize = A.length;

		// Size should be at least 3 to figure out sequence
		if (inputsize < 3)
			return 0;

		int s = 0, count = 0;

		while (s < inputsize - 2) {
			int e = s + 1;
			int differenceoftwonumbers = A[e] - A[s];

			while (e < inputsize - 1 && A[e + 1] - A[e] == differenceoftwonumbers) {
				e++;
			}

			int countsublen = e - s + 1;
			if (countsublen >= 3) {

				count += ((countsublen - 2) * (countsublen - 1) / 2);
			}

			s = e;
		}

		return count;
	}

	public static int flipCoin(int[] coins) {
		if (coins.length == 0) {
			return 0;
		}

		for (int i = 1; i < coins.length - 1; i++) {
			if (coins[i - 1] != coins[i] && coins[i] != coins[i + 1]) { // 010
																		// or
																		// 101
				coins[i] = coins[i] == 1 ? 0 : 1;
				return adjacency(coins);
			}
		}

		for (int i = 1; i < coins.length - 1; i++) {
			if (coins[i - 1] == coins[i] && coins[i] != coins[i + 1]) {
				coins[i + 1] = coins[i + 1] == 1 ? 0 : 1;
				return adjacency(coins);
			} else if (coins[i - 1] != coins[i] && coins[i] == coins[i + 1]) {
				coins[i - 1] = coins[i - 1] == 1 ? 0 : 1;
				return adjacency(coins);
			}
		}

		coins[0] = coins[0] == 1 ? 0 : 1;
		return adjacency(coins);
	}

	private static int adjacency(int[] A) {
		int adj = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] == A[i]) {
				adj++;
			}
		}
		return adj;
	}
}
