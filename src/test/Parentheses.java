package test;

import java.util.Stack;
import java.util.HashMap;

public class Parentheses {

	public static void main(String[] args) {
		System.out.println(isValid2("{(int i = 5)}"));
	}

	public static boolean isValid(String s) {
		char[] par = s.toCharArray();
		Stack<Character> charStack = new Stack<Character>();
		for (Character c : par) {
			if (c == '}') {
				if (charStack.pop() != '{') {
					return false;
				}
			} else if (c == ')') {
				if (charStack.pop() != '(') {
					return false;
				}
			} else if (c == ']') {
				if (charStack.pop() != '[') {
					return false;
				}
			} else {
				charStack.push(c);
			}
		}
		if (charStack.size() > 0) {
			return false;
		}
		return true;
	}

	public static boolean isValid2(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (map.containsKey(curr)) {
				stack.push(curr);
			} else if (map.containsValue(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.empty();
	}

}
