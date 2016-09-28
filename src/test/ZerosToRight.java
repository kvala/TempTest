package test;

public class ZerosToRight {

	public static void main(String[] args) {

		int[] input = { 1, 0, 2, 3, 0, 0, 4 };
		// { 0, 1, 2, 3, 4, 5, 6, 0, 0, 0, 7, 8, 0 };

		for (int o : input) {
			System.out.print(o + " ");
		}

		System.out.println();

		int[] out = zerotoright1(input);
		for (int o : out) {
			System.out.print(o + " ");
		}

		System.out.println();

		int[] input1 = { 1, 0, 2, 3, 0, 0, 4 };
		// { 0, 1, 2, 3, 4, 5, 6, 0, 0, 0, 7, 8, 0 };
		for (int o : pushZerosToEnd(input1)) {
			System.out.print(o + " ");
		}

	}

	public static int[] pushZerosToEnd(int arr[]) {
		int count = 0; // Count of non-zero elements
		int n = arr.length;
		// Traverse the array. If element encountered is
		// non-zero, then replace the element at index 'count'
		// with this element
		for (int i = 0; i < n; i++)
			if (arr[i] != 0)
				arr[count++] = arr[i]; // here count is
										// incremented

		// Now all non-zero elements have been shifted to
		// front and 'count' is set as index of first 0.
		// Make all elements 0 from count to end.
		while (count < n)
			arr[count++] = 0;

		return arr;
	}

	// DONT do this. This is worst inmplementation.
	public static int[] zerotoright(int[] input) {
		int start = 0;
		int end = input.length - 1;

		while (start < end) {
			while (input[start] != 0) {
				start++;
				continue;
			}

			while (input[end] == 0) {
				end--;
				continue;
			}

			if (start < end) {
				int temp;
				temp = input[start];
				input[start] = input[end];
				input[end] = temp;
			}
		}

		return input;
	}

	public static int[] zerotoright1(int[] arr) {
		int max = arr.length;
		int j = 0;
		for (int i = 0; j < max; j++) {
			if (arr[j] != 0) {
				if (i < j) {
					int temp;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				i++;
			}
		}

		return arr;
	}

}
