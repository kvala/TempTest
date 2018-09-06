package test;

public class HIndex {

	public static int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}

		int n = citations.length;
		int[] buckets = new int[n + 1];

		// Step 1: Accmulate the number of citations for each bucket
		for (int i = 0; i < n; i++) {
			if (citations[i] <= n) {
				buckets[citations[i]]++;
			} else {
				buckets[n]++;
			}
		}

		// Step 2: iterate the citations from right to left.
		int numPapers = 0;
		for (int i = n; i >= 0; i--) {
			numPapers += buckets[i];
			if (numPapers >= i) {
				return i;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		int[] data = new int[] { 3, 3, 15, 2, 0, 99, 111, 100, 100, 125, 100, 100 };
		System.out.println(hIndex(data));

	}

}
