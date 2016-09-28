package test;

import java.util.ArrayList;
import java.util.List;

public class PowerSetTest {

	public static void main(String[] args) {

		List<String> l = new ArrayList<>();
		l.add("a");
		l.add("b");
		l.add("c");
		List<ArrayList<String>> retList = powerSet(l);

		for (int i = 0; i < retList.size(); i++) {
			System.out.println(retList.get(i));
		}
		
	}

	public static List<ArrayList<String>> powerSet(List<String> set) {
		List<ArrayList<String>> retList = new ArrayList<ArrayList<String>>();

		if (set.size() == 0) {
			retList.add(new ArrayList<>());
			return retList;
		}

		String element = set.get(0);

		// Do not modify original set.
		List<String> copy = new ArrayList<String>(set);
		copy.remove(0);
		List<ArrayList<String>> subSet = powerSet(copy);

		retList.addAll(subSet);
		for (int i = 0; i < subSet.size(); i++) {
			ArrayList<String> nSubSet = new ArrayList<String>(subSet.get(i));
			nSubSet.add(element);
			retList.add(nSubSet);
		}

		return retList;

	}
}
