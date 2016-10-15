package test;

import java.util.Arrays;
import java.util.Hashtable;

public class IntHelper {

	public static void FindSumOfTwoNumbers(int[] input, int sum) {
		Hashtable<Integer, Integer> dictionary = new Hashtable<Integer, Integer>();

		int len = input.length;

		for (int i = 0; i < len; i++) {
			int currentvalue = input[i];
			int x = sum - currentvalue;
			if (x < 0) {
				continue;
			}

			Integer val = dictionary.get(x);
			if (val == null) {
				dictionary.put(currentvalue, currentvalue);
			} else {
				System.out.println("X: " + currentvalue + " Y: " + val);
			}
		}
	}

	public static void FindSumOfTwoNumbersSorting(int[] input, int sum) {

		// sort array by merge-sort. Big(O) = nlog(n)
		MergeSort(input);

		int start = 0;
		int len = input.length;
		int end = len;
		while (end < len && sum > input[end]) {
			end--;
		}

		while (start < end) {
			int num1 = input[start];
			int num2 = input[end];
			if (num1 + num2 == sum) {
				System.out.println("X: " + num1 + " Y: " + num2);
			} else if (num1 + num2 > sum) {
				end--;
			} else {
				start++;
			}

		}

	}

	public static void MergeSort(int[] input) {
		int[] helper = new int[input.length];
		MergeSort(input, helper, 0, input.length - 1);

	}

	public static void MergeSort(int[] input, int[] helper, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			MergeSort(input, helper, start, mid);
			MergeSort(input, helper, mid + 1, end);
			Merge(input, helper, start, mid, end);

		}
	}

	public static void Merge(int[] input, int[] helper, int start, int mid, int end) {
		for (int i = start; i <= end; i++) {
			helper[i] = input[i];
		}

		int helperleft = start;
		int helperright = mid + 1;
		int current = start;

		while (helperleft <= mid && helperright <= end) {
			if (helper[helperleft] <= helper[helperright]) {
				input[current] = helper[helperleft];
				helperleft++;
			} else {
				input[current] = helper[helperright];
				helperright++;
			}
			current++;
		}

		int remaining = mid - helperleft;

		for (int i = 0; i <= remaining; i++) {
			input[current + i] = helper[helperleft + i];
		}
	}
}
