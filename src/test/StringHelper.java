package test;

import java.util.ArrayList;

public class StringHelper {
	public static String RemoveChars(String input, String remove) {
		char[] s = input.toCharArray();
		// ----------
		// in c# you do not need this. You can iterate using string.
		char[] r = remove.toCharArray();
		// ----------

		boolean[] flags = new boolean[128];

		for (char rm : r) {
			flags[rm] = true;
		}

		int src = 0;
		int dst = 0;
		int len = s.length;
		while (src < len) {
			if (!flags[s[src]]) {
				s[dst] = s[src];
				dst++;
			}
			src++;
		}

		return new String(s, 0, dst);
	}

	public static void ReverseWordChar(char[] i) {
		int start = 0;
		int end = i.length - 1;
		while (start < end) {
			char temp = i[end];
			i[end] = i[start];
			i[start] = temp;

			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// System.out.println(RemoveChars("ketan", "e"));
		String input = "ketan";
		char[] i = input.toCharArray();
		ReverseWordChar(i);

		System.out.println(i);

		System.out.println(RemoveChars("ketan", "e"));
	}

	public static ArrayList<String> GetPerms(String str) {
		if (str == null) {
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0); // get the first character
		String remainder = str.substring(1); // remove the 1st character
		ArrayList<String> words = GetPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
}
