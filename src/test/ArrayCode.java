package test;

import java.util.ArrayList;
import java.util.Hashtable;

public class ArrayCode {

	public static void main(String[] args) {
		/*
		 * int[] input = { 12, 3, 4, 3, 4, 15, 16, 35 };
		 * System.out.println(findSmallestUniqueValue(input));
		 * 
		 * for (int i : findDuplicate(input)) { System.out.print(i + " "); }
		 */
		System.out.println(removeDuplicate2("ababcdd"));
	}

	public static int findSmallestUniqueValue(int[] input) {
		/*
		 * 1) Can number be negative? 2) Array is sorted? 3) input must have
		 * unique value? if, not then what function should return
		 */

		int min = Integer.MAX_VALUE;

		if (input == null) {
			return min;
		}
		Hashtable<Integer, Integer> dictionary = new Hashtable<Integer, Integer>();

		for (int i : input) {
			Integer count = dictionary.get(i);
			if (count == null) {
				dictionary.put(i, 1);
			} else {
				dictionary.put(i, count + 1);
			}
		}

		for (int key : dictionary.keySet()) {
			if (dictionary.get(key) == 1) {
				if (key < min) {
					min = key;
				}
			}
		}

		return min;
	}

	public static ArrayList<Integer> findDuplicate(int[] input) {
		/*
		 * 1) Can number be negative? 2) Array is sorted? 3) input must have
		 * unique value? if, not then what function should return
		 */

		ArrayList<Integer> retArray = new ArrayList<Integer>();

		if (input == null) {
			// return null or empty array?
			return null;
		}
		Hashtable<Integer, Integer> dictionary = new Hashtable<Integer, Integer>();

		for (int i : input) {
			Integer count = dictionary.get(i);
			if (count == null) {
				dictionary.put(i, 1);
			} else {
				dictionary.put(i, count + 1);
			}
		}

		for (int key : dictionary.keySet()) {
			if (dictionary.get(key) > 1) {
				retArray.add(key);
			}
		}

		return retArray;
	}

	public static String removeDuplicate(String input) {
		StringBuilder cout = new StringBuilder();

		if (input == null) {
			// return null or empty array?
			return null;
		}
		Hashtable<Character, Integer> dictionary = new Hashtable<Character, Integer>();

		for (int i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);
			Integer count = dictionary.get(c);
			if (count == null) {
				dictionary.put(c, 1);
				cout.append(c);

			} else {
				dictionary.put(c, count + 1);
			}
		}

		return cout.toString();
	}

	public static String removeDuplicate2(String input) {
		char[] cout = input.toCharArray();
		int ic = 0;

		Hashtable<Character, Integer> dictionary = new Hashtable<Character, Integer>();

		for (int i = 0; i < cout.length; i++) {
			Character c = cout[i];
			Integer count = dictionary.get(c);
			if (count == null) {
				dictionary.put(c, 1);
				cout[ic++] = c;

			} else {
				dictionary.put(c, count + 1);
			}
		}

		return new String(cout, 0, ic);
	}

}
