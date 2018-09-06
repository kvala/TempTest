package uber;

/**
 * Alien dictionary problem
 * -----------------------
 * File: https://raw.githubusercontent.com/dwyl/english-words/master/words.txt
 * 
Aar$  ----
Aara ----
Aarau
AARC
aardvark
aardvarks
aardwolf
aardwol
  * Alpha numeric dict
  * 
  * O/p: asc of alphabets 
  * a b c d e f....
  * 
  * Input #2:
  * lll
  * lpa
  * lpp
  * lpb
  * apl
  * b
  * 
  * Graph: Node, edge
  *  Nodes: 4 (words)
  *  Edge: 4 (charcters)
  * 
  * 
  *  (l) -> (p)
  *  (a) -> (p)
  *  (p) -> (b)
  *  (l) -> (a)
  *  (a) -> (b)
  * 
  * Direct connection Hash Table:
  *  (p) -> (l, a)
  *  (b) -> (a, p)
  *  (a) -> (l)
  * 
  * 
  * (p) -> (a)
  * (p) -> (b)
  * (c) -> (a)
  * (c) -> (b)
  * 
  * 
  * (a) -> (p)
  * (b) -> (p)
  * 
  * 
  * O/p: l a p b
  * 
  * # of in edges 
  * l -> 0  
  * a -> 1
  * p -> 2
  * b -> 2
  * 
  * sort(words)
  * 
  * Topological sort (graph) <--- correct
  * 
  * Graph datastructure
  * 
  * word1 word2
  * 
  * Edges:
  * 1) Cycles
  * 2) 
  * 
  * 
  * HashSet<char, List<char>
  * HashMap<char, int>
 */

import java.util.*;

public class Solution {

	HashMap<Character, List<Character>> childMap = new HashMap<Character, List<Character>>();
	HashMap<Character, Integer> counter = new HashMap<Character, Integer>();

	public List<Character> alienSorting(ArrayList<String> input) {
		for (int i = 0; i < input.size() - 1; i++) {
			String p = input.get(i);
			String c = input.get(i + 1);

			for (int j = 0; j < Math.min(p.length(), c.length()); j++) {
				if (p.charAt(j) != c.charAt(j)) {
					List<Character> data = childMap.get(c.charAt(j));
					if (data == null) {
						data = new ArrayList<Character>();
					}

					data.add(p.charAt(j));
					childMap.put(c.charAt(j), data);

					Integer cnt = counter.get(c.charAt(j));
					if (cnt == null) {
						cnt = 1;
					} else {
						cnt++;
					}
					counter.put(c.charAt(j), cnt);

					Integer pcnt = counter.get(p.charAt(j));
					if (pcnt == null) {
						counter.put(p.charAt(j), 0);
					}

					break;
				}
			}

			while (!counter.isEmpty()) {

			}
		}

		return null;
	}

	public static String simplifyPath(String path) {

		Stack<String> stack = new Stack<String>();
		String[] paths = path.split("/");

		for (String p : paths) {
			if (p.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!p.equals(".") && !p.isEmpty()) {
				stack.push(p);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String l : stack) {
			sb.append("/");
			sb.append(l);
		}

		String result = sb.toString();
		return result.isEmpty() ? "/" : result;
	}

	public static void main(String args[]) throws Exception {

		String data = "/home//foo/w";

		System.out.println(simplifyPath(data));
		/*
		 * ArrayList<String> data = new ArrayList<String>(); data.add("lll");
		 * data.add("lpa"); data.add("lpp"); data.add("lpb"); data.add("apl");
		 * data.add("b");
		 * 
		 * Solution s = new Solution(); System.out.println(s.alienSorting(data));
		 */
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	}
}