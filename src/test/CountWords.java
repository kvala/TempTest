package test;

import java.util.HashMap;

public class CountWords {

	public static void main(String[] args) {
		countWords("this is test string and this like to be 1 ketan ketan");

	}

	public static void countWords(String input) {
		String[] inputarray = input.split(" ");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String data : inputarray) {
			int val = 0;
			if (map.containsKey(data)) {
				val = map.get(data);
			}
			map.put(data, val + 1);
		}

		for (String key : map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}
	}

}
