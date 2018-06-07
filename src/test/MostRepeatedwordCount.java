package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MostRepeatedwordCount {
	public static List<String> findMostRepetative(String input, ArrayList<String> ignoreWords) {
		List<String> returnResult = new ArrayList<String>();
		String[] words = input.trim().toLowerCase().split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		int max = 0;
		for (String word : words) {
			if (!ignoreWords.contains(word)) {
				if (map.containsKey(word)) {
					map.put(word, (map.get(word) + 1));
				} else {
					map.put(word, 1);
				}

				int curmax = map.get(word);
				if (curmax > max) {
					max = curmax;
				}
			}
		}

		for (String key : map.keySet()) {
			if (map.get(key) == max) {
				returnResult.add(key);
			}
		}
		return returnResult;
	}

	public static void main(String[] args) {
		String input = "this is fun java code i love java fun";
		ArrayList<String> ignore = new ArrayList<String>();
		ignore.add("is");
		ignore.add("this");
		System.out.println(findMostRepetative(input, ignore));

	}

}
