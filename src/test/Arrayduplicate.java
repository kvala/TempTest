package test;

import java.util.HashMap;
import java.util.Map;

public class Arrayduplicate {

	public static void main(String[] args) {
		int[] input = { 23, 17, 9, 9, 15, 7, 5 };
		System.out.println(findduplicate(input));

	}

	public static int findduplicate(int[] input) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

		for (int i : input) {
			Integer c = h.get(i);
			if (c == null) {
				h.put(i, 1);
			} else {
				h.put(i, ++c);
			}
		}

		for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
			// System.out.println(entry.getKey() + "/" + entry.getValue());
			if (entry.getValue() > 1) {
				return entry.getKey();
			}
		}

		return -1;

	}

}
