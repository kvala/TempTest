package test;

public class SearchElementInsortedandrotatedArray {

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 2, 3 };

		System.out.println(search(input, 0, 4, 2));

	}

	public static int search(int arr[], int l, int h, int key) {
		if (l > h)
			return -1;

		int mid = (l + h) / 2;
		if (arr[mid] == key)
			return mid;

		/* If arr[l...mid] is sorted */
		if (arr[l] <= arr[mid]) {
			/*
			 * As this subarray is sorted, we can quickly check if key lies in
			 * half or other half
			 */
			if (key >= arr[l] && key <= arr[mid])
				return search(arr, l, mid - 1, key);

			return search(arr, mid + 1, h, key);
		}

		/*
		 * If arr[l..mid] is not sorted, then arr[mid... r] must be sorted
		 */
		if (key >= arr[mid] && key <= arr[h])
			return search(arr, mid + 1, h, key);

		return search(arr, l, mid - 1, key);
	}

}
