package test;

import java.util.ArrayList;

public class DictionaryRegexMatch {

	static ArrayList<String> dict = new ArrayList<String>();

	public static void main(String[] args) {
		dict.add("test");
		dict.add("gest");
		dict.add("pest");
		dict.add("abc");
		dict.add("dbc");
		dict.add("a");
		dict.add("b");
		
		for (String s : dict) {
			if (isMatch("*es*", s)) {
				System.out.println(s);
			}
		}
		
	}

	public static boolean isMatch(String input, String dictionaryword) {
		if (dictionaryword.length() != input.length()) {
			return false;
		}
		int i = 0, len = input.length();
		while (i < len) {
			if (input.charAt(i) != dictionaryword.charAt(i) && input.charAt(i) != '*') {
				return false;
			}
			i++;
		}

		return true;
	}
}
