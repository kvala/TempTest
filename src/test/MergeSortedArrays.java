package test;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] a = { 2, 11, 21 };
		int[] b = { 2, 9, 10, 15, 17, 25, 39 };

		for (int i : mergeSorted(a, b)) {
			System.out.print(i + " ");
		}

	}

	public static int[] mergeSorted(int[] a, int[] b) {
		int asize = a.length;
		int bsize = b.length;

		int[] output = new int[asize + bsize];
		int astart = 0;
		int bstart = 0;
		int ostart = 0;
		while (astart < asize && bstart < bsize) {
			if (a[astart] < b[bstart]) {
				output[ostart++] = a[astart++];
			} else {
				output[ostart++] = b[bstart++];
			}
		}

		for (int i = astart; i < asize; i++) {
			output[ostart++] = a[astart++];
		}

		for (int i = bstart; i < bsize; i++) {
			output[ostart++] = b[bstart++];
		}
		return output;
	}

}
