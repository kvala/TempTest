package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Angrams {

	
	public static void main(String[] args) {
		
		System.out.println(isAngram1("test", "tset"));
		
		//String[] myArray = { "dog", "god", "hat", "fan", "anf" };
		String[] myArray = { "star", "dog", "car", "rats", "arc" };
		List<List<String>> out = groupAnagrams(myArray);
		for (List<String> s : out) {
			System.out.println(s);
		}
	}
	

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0)
			return res;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String word : strs) {
			char[] charArr = word.toCharArray();
			Arrays.sort(charArr);
			String str = new String(charArr);
			if (map.containsKey(str)) {
				map.get(str).add(word);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(word);
				map.put(str, list);
			}
		} 
		Iterator<ArrayList<String>> iter = map.values().iterator();
		while (iter.hasNext()) {
			ArrayList<String> item = iter.next();
			//If you want to sort output alphabetically
			//Collections.sort(item);
			res.add(item);
		}
		return res;
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
