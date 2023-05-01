package test;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

public class LogestSubString {

	public static void main(String[] args) {

//		List<Integer> myList = new ArrayList<>();
//		for (int i = 0; i < 100; i++)
//			myList.add(i);
//
//		// sequential stream
//		Stream<Integer> sequentialStream = myList.stream();
//
//		// parallel stream
//		Stream<Integer> parallelStream = myList.parallelStream();
//
//		// using lambda with Stream API, filter example
//		Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
//		// using lambda in forEach
//		highNums.forEach(p -> System.out.println("High Nums parallel=" + p));
//
//		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
//		highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));

		System.out.println(lengthOfLongestSubstring2("abcdaghijklmnog"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length(), ans = 0;
		HashMap<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	public static String lengthOfLongestSubstrings(String s) {
		String maxs = "";
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				if ((j - i) > ans) {
					ans = j - i;
					maxs = s.substring(i, j);
				}
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return maxs;
	}
}
