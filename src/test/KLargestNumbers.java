package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestNumbers {

	public static ArrayList<Integer> kthLargestNumbers(int[] numbers, int k) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(k);

		for (int i = 0; i < k; i++) {
			que.add(numbers[i]);
		}

		for (int i = k; i < numbers.length; i++) {

			if (que.peek() < numbers[i]) {
				que.remove();
				que.add(numbers[i]);
			}
		}

		while (!que.isEmpty()) {
			output.add(que.remove());
		}
		return output;

	}

	public static ArrayList<Integer> kthSmallestNumbers(int[] numbers, int k) {
		ArrayList<Integer> output = new ArrayList<Integer>();

		PriorityQueue<Integer> que = new PriorityQueue<Integer>(k, Collections.reverseOrder());

		for (int i = 0; i < k; i++) {
			que.add(numbers[i]);
		}

		for (int i = k; i < numbers.length; i++) {

			if (que.peek() > numbers[i]) {
				que.remove();
				que.add(numbers[i]);
			}
		}

		while (!que.isEmpty()) {
			output.add(que.remove());
		}
		return output;

	}

	public static void main(String[] args) {

		int[] input = { 1, 23, 12, 9, 30, 2, 50 };
		for (int i : kthLargestNumbers(input, 3)) {
			System.out.print(i + " ");
		}

		System.out.println("\n -----");
		
		for (int i : kthSmallestNumbers(input, 3)) {
			System.out.print(i + " ");
		}
	}

}
