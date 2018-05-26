package test;

import java.util.ArrayList;
import java.util.List;

//Given an integer as an input, find the next larger integer with only 4 and 7 
//as the digits
//Example: Input: 123, Output: 444
//Example: Input: 153, Output: 444
//Example: Input: 456, Output: 474
//Example: Input: 457, Output: 474
//Example: Input: 572, Output: 744
//Example: Input: 483, Output: 744
//Example: Input: 777, Output: 4444
//Example: Input: 444, Output: 447
//Example: Input: 774, Output: 777
//Example: Input: 744, Output: 747


public class NextLargeNumber {
	public static int nextLargerInteger(int[] input, int a, int b) {

		List<Integer> output = new ArrayList<Integer>();
		int i = 0, length = input.length;
		while (i < length) {
			int currentNumber = input[i++];
			if (a >= currentNumber) {
				output.add(a);
			} else if (b >= currentNumber) {
				output.add(b);
			} else {
				output.add(a);
			}

		}
		return convertArrayToInteger(output);
	}

	public static int convertArrayToInteger(List<Integer> input) {
		int result = 0;
		for (int temp = 0; temp < input.size(); temp++) {
			result *= 10;
			result += input.get(temp);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] myIntArray = { 7, 7, 4 };
		System.out.println(nextLargerInteger(myIntArray, 4, 7));

	}

}
