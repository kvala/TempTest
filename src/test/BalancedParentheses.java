package test;

import java.util.ArrayList;

public class BalancedParentheses {

	static Character open = '{';
	static Character close = '}';

	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> solutions = new ArrayList<String>();
		recursion(n, new String(), solutions);
		return solutions;
	}

	private static void recursion(int n, String str, ArrayList<String> sol) {
		if (str.length() == 2 * n)
			sol.add(str);
		else {
			int left = 0;
			int right = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == open)
					left++;
				if (str.charAt(i) == close)
					right++;
			}
			if (left == right)
				recursion(n, str + open, sol);
			else if (right < left) {
				if (left < n)
					recursion(n, str + open, sol);
				recursion(n, str + close, sol);
			}
		}
	}

	public static void main(String args[]) {
		for (String s : generateParenthesis(3)) {
			System.out.println(s);
		}
	}
}
