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

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	HashMap<Character, List<Character>> childMap = new HashMap<Character, List<Character>>();
	HashMap<Character, Integer> counter = new HashMap<Character, Integer>();

	public List<Character> alienSorting(ArrayList<String> input) {
		for (int i = 0; i < input.size() - 1; i++) {
			String p = input.get(i);
			String c = input.get(i + 1);

			char[] pc = p.toCharArray();
			char[] cc = c.toCharArray();
			int ps = 0, pend = pc.length;
			int cs = 0, cend = cc.length;
			while (ps < pend && cs < cend) {
				if (pc[ps] != cc[cs]) {
					// cc child
					// pc parent
					char child = cc[cs];
					char parent = pc[ps];
					if (!childMap.containsKey(child)) {
						List<Character> newList = new ArrayList<Character>();
						newList.add(parent);
						childMap.put(child, newList);
					} else {
						List<Character> data = childMap.get(child);
						data.add(parent);
						childMap.put(child, data);
					}
				}
			}
		}

		return null;
	}

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	}
}