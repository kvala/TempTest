package test;

import java.io.*;
import java.util.*;

public class Code {

	// Complete the rotLeft function below.
	static ArrayList<Integer> rotLeft(int[] a, int d) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		Queue<Integer> qu = new LinkedList<Integer>();
		for (int i : a) {
			qu.add(i);
		}

		while (d > 0) {
			int c = qu.remove();
			qu.add(c);
			d--;
		}

		while (!qu.isEmpty()) {
			output.add(qu.remove());
		}

		return output;
	}

	static int[] rotLeft1(int[] a, int d) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < d; i++) {
			temp.add(a[i]);
		}
		int start = 0;
		for (int j = d; j < a.length; j++) {
			a[start++] = a[j];
		}

		int tempstart = 0;
		while (start < a.length) {
			a[start++] = temp.get(tempstart++);
		}
		return a;
	}

	
	public static void main(String[] args) throws IOException {
		// int[] input = new int[] { 41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77,
		// 97, 58, 1, 86, 58, 26, 10, 86, 51 };
		int[] input = new int[] { 1, 2, 3, 4, 5 };
		for (int i : rotLeft1(input, 4)) {
			System.out.print(i + " ");
		}
	}
}
