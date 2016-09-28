package test;

/*
Create a Json like object to representation and implement a flatten method to return string -> string mapping. 
(implement from scratch / test / compiling + working code) 
{x:1, y:1, z:{a:1,b:2}} flattens to {x:1, y:1, z.a:1, z.b: 2}
{x:1, y:1, z:{a:{b:2}} flattens to {x:1, y:1, z.a.b:2}
{x:1, y:1, z:{a:{b:2}, c:3} flattens to {x:1, y:1, z.a.b:2, z.c:3}
{x:1, y:{a:{b:2,c:{d:3, e:4}}}}
 */

import java.util.*;

public class FlattenJsonString {

	public static void main(String[] args) {
		// String input = null;
		// String input = "{x:1, y:1, z:{a:1,b:2}}";
		// String input = "{x:1, y:1, z:{a:{b:2}}";
		// String input = "{x:1, y:1, z:{a:{b:2}, c:3}";

		String input = "{x:1, y:{a:{b:2,c:{d:3, e:4}}}}";
		System.out.println("Input: " + input);

		String output = flattenJson(input);
		System.out.println("Output: " + output);
	}

	public static String flattenJson(String input) {
		// Base conditions
		if (input == null || input.length() == 0)
			return "INVALID INPUT";

		// Initialization
		String output = "";
		boolean flag = false;
		Stack<String> stack = new Stack<String>();
		List<Character> parentNestList = new ArrayList<Character>();

		// Core logic
		for (int i = 0; i < input.length(); i++) {
			char currChar = input.charAt(i);

			if (currChar == '{') {
				if (i != 0)
					flag = true;
			}

			else if (currChar == '}') {
				if (i != (input.length() - 1) && parentNestList.size() > 0)
					parentNestList.remove(parentNestList.size() - 1);
			}

			else if (currChar == ':' || currChar == ',' || currChar == ' ') {
				continue;
			}

			else {
				if (flag) {
					flag = false;
					parentNestList.add(stack.pop().charAt(0));
					stack.push(String.valueOf(currChar));
				} else if (!flag && parentNestList.size() > 0 && ((currChar - 'a') >= 26 || (currChar - 'a') < 0)) {
					String temp = "";
					for (int j = 0; j < parentNestList.size(); j++) {
						temp = temp + parentNestList.get(j);
						temp = temp + ".";
					}
					stack.push(temp + stack.pop());
					stack.push(String.valueOf(currChar));
				} else {
					stack.push(String.valueOf(currChar));
				}
			}
			//System.out.println(stack);
		}
		boolean flag2 = true;
		output = stack.pop();
		while (!stack.isEmpty()) {
			if (flag2)
				output = stack.pop() + ":" + output;
			else
				output = stack.pop() + ", " + output;
			flag2 = !flag2;
		}
		output = "{" + output + "}";
		return output;
	}
}