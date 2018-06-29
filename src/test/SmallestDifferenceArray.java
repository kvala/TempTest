package test;

import java.util.Arrays;

public class SmallestDifferenceArray {

	public static int smallestDifferenceArrays(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		int a = 0;
		int b = 0;
		int min = Integer.MAX_VALUE;
		while (a < array1.length && b < array2.length) {
			if (Math.abs(array1[a] - array2[b]) < min) {
				min = Math.abs(array1[a] - array2[b]);
			}

			if (array1[a] < array2[b]) {
				a++;
			} else {
				b++;
			}
		}

		return min;
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 3, 15, 11, 2 };
		int[] array2 = { 23, 127, 235, 19, 8 };

		System.out.println(smallestDifferenceArrays(array1, array2));

	}

}
