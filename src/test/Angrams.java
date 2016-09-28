package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Angrams {

	
	public static void main(String[] args) {
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
}
