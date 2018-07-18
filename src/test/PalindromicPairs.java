package test;

//Airbnb: Palindromic pair of a list of strings 

//
//
//
//Given a list of strings, find all the palindromic pairs of the string and output the concatenated palindrome.
//
//e.g. [abc, cba], output is abccba, cbaabc.
//e.g. [aabc, cb], output is cbaabc
//
//
//
//Understand the problem:
//The brute-force solution to this problem is very simple. For each word, we search all the others and see if it can form a palindrome. Assume that the ave. length of each word is m and there are totally n words in the list, the time complexity would be O(n^2 * m). 
//
// Solution:
//1. Put all the reversed order of the input string into a Map. The key is the reversed order of the string, and the value is the indices of the word
//2. For each word, get all its prefixes, If the prefix is in the map AND the rest of the string is a palindrome, then we can find a pair where the first half is the current word, and the second half is the reversed order of prefix.
//3. For each word, get all its postfixes. If the postfix is in the map AND the first half of the string is palindrome, then we can find a pair where the reversed order of the postfix is the first part, and the word is the second part of the pair. 
//
// The reason why we need to track the position of each word is to avoid the situation like ["c"], i.e. the word itself is a palindrome. Then we may mistakely concatenate a "cc" as a palindrome. So we can concatenate two words IFF
//1. The key in the map is different from the current word
//2. If they are the same, they must have different indices. 

import java.util.HashMap;
import java.util.*;

public class PalindromicPairs {
	List<String> getPalindromaticPairs(String[] input) {
		Set<String> result = new HashSet<>();
		if (input == null || input.length == 0) {
			return new ArrayList<>();
		}

		// Step 1: put the reversed order of each word into the map
		HashMap<String, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < input.length; i++) {
			String str = input[i];
			String reStr = reverse(str);
			if (!map.containsKey(reStr)) {
				List<Integer> indices = new ArrayList<>();
				indices.add(i);
				map.put(reStr, indices);
			} else {
				List<Integer> indices = map.get(reStr);
				indices.add(i);
			}
		}

		// Step 2: Iterate each word
		for (int i = 0; i < input.length; i++) {
			String str = input[i];

			// Get all the prefix of str, and append to the end
			for (int j = 1; j <= str.length(); j++) {
				String prefix = str.substring(0, j);
				String postfix = str.substring(j);

				if (map.containsKey(prefix) && isPalindrome(postfix)) {
					if (map.get(prefix).size() > 1 || !map.get(prefix).equals(str)) {
						String palin = str + reverse(prefix);
						result.add(palin);
					}
				}
			}

			// Get all postfix of the str, and insert to front
			for (int j = str.length() - 1; j >= 0; j--) {
				String postfix = str.substring(j);
				String prefix = str.substring(0, j);

				if (map.containsKey(postfix) && isPalindrome(prefix)) {
					if (map.get(postfix).size() > 1 || !map.get(postfix).equals(str)) {
						String palin = reverse(postfix) + str;
						result.add(palin);
					}
				}
			}
		}

		return new ArrayList<String>(result);
	}

	private String reverse(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		char[] array = s.toCharArray();
		int lo = 0;
		int hi = array.length - 1;
		while (lo < hi) {
			char temp = array[lo];
			array[lo] = array[hi];
			array[hi] = temp;

			lo++;
			hi--;
		}

		return new String(array);
	}

	private boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}

		int lo = 0;
		int hi = s.length() - 1;

		while (lo < hi) {
			if (s.charAt(lo) != s.charAt(hi)) {
				return false;
			}

			lo++;
			hi--;
		}

		return true;
	}

	public static void main(String[] args) {
		PalindromicPairs solution = new PalindromicPairs();
		String[] input = new String[] { "abc", "cba", "c", "c" };

		List<String> result = solution.getPalindromaticPairs(input);

		for (String s : result) {
			System.out.println(s);
		}
	}
}
