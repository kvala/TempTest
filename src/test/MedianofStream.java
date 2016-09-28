package test;

import java.util.ArrayList;

public class MedianofStream {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		// {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4}
		A.add(5);
		A.add(15);
		A.add(1);
		A.add(3);
		A.add(2);
		A.add(8);

		A.add(7);
		A.add(9);
		A.add(10);
		A.add(6);
		A.add(11);
		A.add(4);

		printMedian(A);
	}

	public static void printMedian(ArrayList<Integer> input) {
		int m = 0; // effective median

		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();

		for (int i = 0; i < input.size(); i++) {
			m = getMedian(input.get(i), m, left, right);

			System.out.println(m);
		}

	}

	public static int getMedian(int e, int m, ArrayList<Integer> l, ArrayList<Integer> r) {

		if (l.size() == r.size()) {
			if (e < m) // current element fits in left (max) heap
			{
				l.add(e);
				heapify(l);
				m = l.get(0);
			} else {
				r.add(e);
				heapifymin(r);
				m = r.get(0);
			}
		} else if (l.size() > r.size()) {
			if (e < m) // current element fits in left (max) heap
			{
				r.add(l.remove(0));
				heapifymin(r);
				
				// current element fits in left (max) heap
				l.add(e);
				heapify(l);
			} else {
				// current element fits in right (min) heap
				r.add(e);
				heapifymin(r);
			}

			// Both heaps are balanced
			m = Average(l.get(0), r.get(0));
		} else {
			if (e < m) // current element fits in left (max) heap
			{
				l.add(e);
				heapify(l);
			} else {
				// Remove top element from right heap and
				// insert into left heap
				l.add(r.remove(0));
				heapify(l);
				// current element fits in right (min) heap
				r.add(e);
				heapifymin(r);
			}

			// Both heaps are balanced
			m = Average(l.get(0), r.get(0));

		}

		// No need to return, m already updated
		return m;
	}

	public static int Average(int a, int b) {
		return (a + b) / 2;
	}

	/* Function to build a heap */
	public static void heapify(ArrayList<Integer> arr) {
		int N = arr.size() - 1;
		for (int i = N / 2; i >= 0; i--)
			maxheap(arr, i);
	}

	public static void heapifymin(ArrayList<Integer> arr) {
		int N = arr.size() - 1;
		for (int i = N / 2; i >= 0; i--)
			minheap(arr, i);
	}

	/* Function to swap two numbers in an array */
	public static void swap(ArrayList<Integer> arr, int i, int j) {
		int tmp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, tmp);
	}

	/* Function to swap largest element in heap */
	public static void maxheap(ArrayList<Integer> arr, int i) {
		int N = arr.size() - 1;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = i;
		if (left <= N && arr.get(left) > arr.get(i))
			max = left;
		if (right <= N && arr.get(right) > arr.get(max))
			max = right;

		if (max != i) {
			swap(arr, i, max);
			maxheap(arr, max);
		}
	}

	/* Function to swap largest element in heap */
	public static void minheap(ArrayList<Integer> arr, int i) {
		int N = arr.size() - 1;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = i;
		if (left <= N && arr.get(left) < arr.get(i))
			max = left;
		if (right <= N && arr.get(right) < arr.get(max))
			max = right;

		if (max != i) {
			swap(arr, i, max);
			minheap(arr, max);
		}
	}
}
