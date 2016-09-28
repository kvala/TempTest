package test;

public class SearchInRotatedSortedArrayIterative {

	public static int searchiterative(int[] input, int target) {

		int start = 0, end = input.length - 1;
		while (start <= end) {
			int pivot = start + (end - start) / 2;

			if (target == input[pivot]) {
				return pivot;
			}
			if (input[start] <= input[pivot]) {
				if (input[start] <= target && target < input[pivot]) {
					end = pivot - 1;
				} else {
					start = pivot + 1;
				}
			} else {
				if (input[pivot] < target && target <= input[end]) {
					start = pivot + 1;
				} else {
					end = pivot - 1;
				}
			}

		}

		// 6,7,7,8,9,1,2,3,4,5 search 4

		return -1;

	}

	public static void main(String args[]) {
		int[] input = { 6, 7, 7, 8, 9, 1, 2, 3, 4, 5 };
		System.out.println(searchiterative(input, 7));
	}
}
