package test;

import java.util.Arrays;

public class TripletSumZero {

	public static void main(String[] args) {
		int[] input = { 4, 5, -1, 2, -1, -9 };
		tripletSum(input);

	}

	public static void tripletSum(int[] input) {
		Arrays.sort(input);
		int n = input.length;
		for (int i = 0; i < n - 1; i++) {
			int x = input[i];
			int l = i + 1;
			int r = n - 1;

			while (l < r) {
				//System.out.println(x + " + " + input[l] + " + " + input[r]);
				if (x + input[l] + input[r] == 0) {
					System.out.println(x + " + " + input[l] + " + " + input[r]);
					l += 1;
					r -= 1;
				} else if (x + input[l] + input[r] < 0) {
					l += 1;
				} else {
					r -= 1;
				}
			}

		}
	}

}
