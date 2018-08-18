package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Angrams {

	public static void main(String[] args) {

		// System.out.println(isAngram1("test", "tset"));

		// String[] myArray = { "dog", "god", "hat", "fan", "anf" };
		String[] myArray = { "star", "dog", "car", "rats", "arc" };
		List<List<String>> out = groupAnagrams(myArray);
		for (List<String> s : out) {
			System.out.println(s);
		}
	}

	// Big(O) = Sorting klogk, iterate over string O(n)
	//Space complexity is nk
	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<List<String>> result = new ArrayList<List<String>>();

		if (strs == null || strs.length == 0) {
			return result;
		}

		for (String item : strs) {
			char[] cdata = item.toCharArray();
			Arrays.sort(cdata);
			String data = String.valueOf(cdata);

			if (map.containsKey(data)) {
				map.get(data).add(item);
			} else {
				List<String> value = new ArrayList<String>();
				value.add(item);
				map.put(data, value);
			}
		}

		for (String key : map.keySet()) {
			result.add(map.get(key));
		}

		return result;
	}

	//Big(O) = nk where n is length of strs and k is max length of string
	//Space complexity is nk
	public static List<List<String>> groupAnagramsOpt(String[] strs) {
		
		if (strs.length == 0)
			return new ArrayList();
		Map<String, List> ans = new HashMap<String, List>();
		int[] count = new int[26];
		for (String s : strs) {
			Arrays.fill(count, 0);
			for (char c : s.toCharArray())
				count[c - 'a']++;

			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if (!ans.containsKey(key))
				ans.put(key, new ArrayList());
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}

	public static Boolean isAngram(String input1, String input2) {

		if (input1.length() != input2.length()) {
			return false;
		}

		char[] char1 = input1.toCharArray();
		char[] char2 = input2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);

		for (int i = 0; i < input1.length(); i++) {
			if (char1[i] != char2[i]) {
				return false;
			}
		}

		return true;
	}

	public static Boolean isAngram1(String input1, String input2) {

		if (input1.length() != input2.length()) {
			return false;
		}

		int[] counter = new int[256];
		Arrays.fill(counter, 0);

		for (int i = 0; i < input1.length(); i++) {
			counter[input1.charAt(i)] += 1;
			counter[input2.charAt(i)] -= 1;
		}

		for (int i = 0; i < counter.length; i++) {
			if (counter[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
