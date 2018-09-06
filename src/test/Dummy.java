package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Dummy {

	public int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] found = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff)) {
				found[0] = map.get(diff);
				found[1] = i;
			} else {
				map.put(nums[i], i);
			}
		}

		return found;
	}

	public static boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty())
			return text.isEmpty();
		boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
		} else {
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}

	// Finds decimal value of a given romal numeral
	public static int romanToDecimal(String str) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int res = 0;

		for (int i = 0; i < str.length(); i++) {
			int s1 = map.get(str.charAt(i));

			if (i + 1 < str.length()) {
				int s2 = map.get(str.charAt(i + 1));
				if (s1 >= s2) {
					res = res + s1;
				} else {
					res = res + s2 - s1;
					i++;
				}
			} else {
				res = res + s1;
				// i++; //?
			}
		}

		return res;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					set.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		result.addAll(set);
		return result;
	}

	public static boolean threeSum2(int[] nums, int findSum) {

		for (int i = 0; i < nums.length - 2; i++) {
			Set<Integer> set = new HashSet<Integer>();
			int curSum = findSum - nums[i];
			for (int j = i + 1; j < nums.length - 1; j++) {
				int diff = curSum - nums[j];
				if (set.contains(diff)) {
					return true;
				} else {
					set.add(nums[j]);
				}
			}
		}

		return false;
	}

	public static List<String> letterCombinations(String digits) {
		HashMap<Character, Character[]> map = new HashMap<Character, Character[]>();

		map.put('2', new Character[] { 'a', 'b', 'c' });
		map.put('3', new Character[] { 'd', 'e', 'f' });
		map.put('4', new Character[] { 'g', 'h', 'i' });
		map.put('5', new Character[] { 'j', 'k', 'l' });
		map.put('6', new Character[] { 'm', 'n', 'o' });
		map.put('7', new Character[] { 'p', 'q', 'r', 's' });
		map.put('8', new Character[] { 't', 'u', 'v' });
		map.put('9', new Character[] { 'w', 'x', 'y', 'z' });

		List<String> result = new ArrayList<String>();

		if (digits == null || digits.length() == 0) {
			return result;
		}

		char[] arr = new char[digits.length()];
		combinationUtility(0, result, map, digits, arr);

		return result;
	}

	public static void combinationUtility(int index, List<String> result, HashMap<Character, Character[]> map,
			String digits, char[] arr) {

		if (index == digits.length()) {
			result.add(new String(arr));
			return;
		}
		Character[] data = map.get(digits.charAt(index));
		for (Character c : data) {
			arr[index] = c;
			combinationUtility(index + 1, result, map, digits, arr);
		}
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack.push(map.get(c));

			} else if (map.containsValue(c)) {
				if (!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		int counter = 0;
		ListNode c = head;
		ListNode p = null;
		ListNode n = null;
		while (counter < k && c != null) {
			n = c.next;
			c.next = p;
			p = c;
			c = n;
			counter++;
		}

		if (n != null) {
			head.next = reverseKGroup(n, k);
		}

		return p;
	}

	public static ListNode reverseKGroup1(ListNode head, int k) {
		if (head == null || k == 1)
			return head;

		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode pre = fake;
		int i = 0;

		ListNode p = head;
		while (p != null) {
			i++;
			if (i % k == 0) {
				pre = reverse(pre, p.next);
				p = pre.next;
			} else {
				p = p.next;
			}
		}

		return fake.next;
	}

	public static ListNode reverse(ListNode pre, ListNode next) {
		ListNode last = pre.next;
		ListNode curr = last.next;

		while (curr != next) {
			last.next = curr.next;
			curr.next = pre.next;
			pre.next = curr;
			curr = last.next;
		}

		return last;
	}

	public int strStr(String haystack, String needle) {

		if (needle == null || needle.isEmpty()) {
			return 0;
		}

		int h = 0, n = 0, he = haystack.length(), ne = needle.length();

		while (h < he && n < ne) {
			if (needle.charAt(n) == haystack.charAt(h)) {
				h++;
				n++;
				if (n == ne) {
					return h - ne;
				}
			} else {
				h = h - n + 1;
				n = 0;
			}
		}

		return -1;
	}

	public static String countAndSay(int n) {
		if (n <= 0)
			return null;
		String result = "1";
		int i = 1;
		while (i < n) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == result.charAt(j - 1)) {
					count++;
				} else {
					sb.append(count);
					sb.append(result.charAt(j - 1));
					count = 1;
				}
			}
			sb.append(count);
			sb.append(result.charAt(result.length() - 1));
			result = sb.toString();
			i++;
		}
		return result;
	}

	public static String countAndSay1(int n) {
		String result = "1";

		for (int i = 1; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			int counter = 1;
			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == result.charAt(j - 1)) {
					counter++;
				} else {
					sb.append(counter);
					sb.append(result.charAt(j));
					counter = 1;
				}
			}

			sb.append(counter);
			sb.append(result.charAt(result.length() - 1));
			result = sb.toString();
		}

		return result;
	}

	public static String multiply(String num1, String num2) {
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();

		int[] d = new int[num1.length() + num2.length()];

		// multiply each digit and sum at the corresponding positions
		for (int i = 0; i < n1.length(); i++) {
			for (int j = 0; j < n2.length(); j++) {
				d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
			}
		}

		// calculate each digit
		for (int i = 0; i < d.length; i++) {
			int mod = d[i] % 10;
			int carry = d[i] / 10;
			d[i] = mod;

			if (carry > 0) {
				d[i + 1] += carry;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = d.length - 1; i >= 0; i--) {
			sb.append(d[i]);
		}

		// remove front 0's
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	public static boolean strmatch(String str, String pattern) {
		int n = str.length();
		int m = pattern.length();
		if (m == 0)
			return (n == 0);

		boolean[][] lookup = new boolean[n + 1][m + 1];

		lookup[0][0] = true;

		for (int j = 1; j <= m; j++)
			if (pattern.charAt(j - 1) == '*')
				lookup[0][j] = lookup[0][j - 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (pattern.charAt(j - 1) == '*')
					lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];

				else if (pattern.charAt(j - 1) == '?' || str.charAt(i - 1) == pattern.charAt(j - 1))
					lookup[i][j] = lookup[i - 1][j - 1];

				else
					lookup[i][j] = false;
			}
		}

		return lookup[n][m];
	}

	public static float power(float x, int y) {
		float temp;
		if (y == 0)
			return 1;
		temp = power(x, y / 2);

		if (y % 2 == 0)
			return temp * temp;
		else {
			if (y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}

	public static String addBinary(String a, String b) {
		int ae = a.length() - 1, be = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		int c = 0;
		while (ae >= 0 || be >= 0) {
			int sum = 0;
			if (ae >= 0) {
				sum += (a.charAt(ae) - '0');
			}
			if (be >= 0) {
				sum += (b.charAt(be) - '0');
			}

			sum += c;

			c = sum / 2;
			sum = sum % 2;

			sb.append(sum);
			be--;
			ae--;
		}

		if (c > 0) {
			sb.append(c);
		}

		return sb.reverse().toString();
	}

	public void sortColors(int[] nums) {
		int l = 0, m = 0, h = nums.length - 1;
		while (m <= h) {
			if (nums[m] == 0) {
				swap(nums, l, m);
				l++;
				m++;
			} else if (nums[m] == 1) {
				m++;
			} else {
				swap(nums, m, h);
				h--;
			}
		}
	}

	public void swap(int[] nums, int p1, int p2) {
		int temp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = temp;
	}

	// Correct solution
	public static String minWindow2(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			Integer d = map.get(t.charAt(i));
			if (d == null) {
				map.put(t.charAt(i), 0);
				d = 0;
			}
			map.put(t.charAt(i), d + 1);
		}

		int st = 0, e = 0, c = t.length(), f = 0, l = 0, fl = Integer.MAX_VALUE;
		while (e < s.length()) {
			char cd = s.charAt(e);
			if (map.containsKey(cd)) {
				if (map.get(cd) > 0) {
					c--;
				}
				map.put(cd, map.get(cd) - 1);
			}

			e++;

			while (c == 0) {

				if (e - st < fl) {
					fl = e - st;
					f = st;
					l = e;
				}
				char c1 = s.charAt(st);
				if (map.containsKey(c1)) {
					map.put(c1, map.get(c1) + 1);

					if (map.get(c1) > 0) {
						c++;
					}
				}
				st++;

			}
		}

		if (fl == Integer.MAX_VALUE) {
			return "";
		}
		return s.substring(f, l);
	}

	// This solution does not work for duplicates. e.g. aa aa => aa
	public static String minWindow(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			Integer d = map.get(t.charAt(i));
			if (d == null) {
				map.put(t.charAt(i), 0);
				d = 0;
			}
			map.put(t.charAt(i), d++);
		}
		int st = 0, mw = Integer.MAX_VALUE, f = 0, l = 0, i = 0;
		while (i < s.length() && st < s.length()) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
			}
			if (!map.containsValue(0)) {
				if (i - st < mw) {
					mw = i - st;
					f = st;
					l = i;
				}

				for (int j = 0; j < t.length(); j++) {
					Integer d = map.get(t.charAt(j));
					map.put(t.charAt(j), d++);
				}

				st++;
				i = st;
				continue;
			}
			i++;
		}
		return s.substring(f, l + 1);
	}

	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

		UndirectedGraphNode nn = new UndirectedGraphNode(node.label);
		queue.offer(node);
		map.put(node, nn);

		while (!queue.isEmpty()) {
			UndirectedGraphNode current = queue.poll();
			List<UndirectedGraphNode> neighbors = current.neighbors;

			for (UndirectedGraphNode n : neighbors) {
				if (!map.containsKey(n)) {
					UndirectedGraphNode cn = new UndirectedGraphNode(n.label);
					map.put(n, cn);
					queue.offer(n);
					map.get(current).neighbors.add(cn);
				} else {
					UndirectedGraphNode cn = map.get(n);
					map.get(current).neighbors.add(cn);

				}
			}

		}

		return nn;

	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);

		while (!queue.isEmpty()) {
			UndirectedGraphNode n = queue.poll();
			if (!map.containsKey(n)) {
				UndirectedGraphNode nn = new UndirectedGraphNode(n.label);
				map.put(n, nn);
			} else {
				continue;
			}
			for (UndirectedGraphNode cn : n.neighbors) {
				queue.offer(cn);
			}
		}

		for (UndirectedGraphNode n : map.keySet()) {
			UndirectedGraphNode nn = map.get(n);
			for (UndirectedGraphNode cn : n.neighbors) {
				nn.neighbors.add(map.get(cn));
			}
		}

		return map.get(node);

	}

	public static boolean validTreeBFS(int n, int[][] edges) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			map.put(i, list);
		}

		for (int[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		while (!queue.isEmpty()) {
			int top = queue.poll();
			if (visited[top])
				return false;

			visited[top] = true;

			for (int i : map.get(top)) {
				if (!visited[i])
					queue.offer(i);
			}
		}

		for (boolean b : visited) {
			if (!b)
				return false;
		}

		return true;
	}

	public static int maxProfit(int[] prices) {
		int i = 0;
		int valley = prices[0];
		int peak = prices[0];
		int maxprofit = 0;
		while (i < prices.length - 1) {
			while (i < prices.length - 1 && prices[i] >= prices[i + 1])
				i++;
			valley = prices[i];
			while (i < prices.length - 1 && prices[i] <= prices[i + 1])
				i++;
			peak = prices[i];
			maxprofit += peak - valley;
		}
		return maxprofit;
	}

	public static void main(String args[]) {

		// int[] data = new int[] { 7, 1, 5, 3, 6, 4 };
		// System.out.println(maxProfit(data));
		// [[0, 1], [0, 2], [0, 3], [1, 4]]
		// [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
//		int[][] data = new int[][] { { 0, 1 }, { 2, 3 }, };

		// System.out.println(isValidGraphTree(data.length, data));
//		System.out.println(validTreeBFS(4, data));

//		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
//		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
//		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
//
//		n0.neighbors.add(n1);
//		n0.neighbors.add(n2);
//		n1.neighbors.add(n2);
//		n2.neighbors.add(n2);
//
//		Dummy d = new Dummy();
//		UndirectedGraphNode o = d.cloneGraph(n0);
//
//		System.out.println(o.neighbors.size());
		// System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
		// System.out.println(isMatch("aab", "c*a*b"));
		// System.out.println(romanToDecimal("IIIIV"));
		// System.out.println(threeSum2(new int[]{ 1, 4, 7, 6, 10, 8 }, 22));

		// System.out.println(letterCombinations("23"));

//		ListNode a1 = new ListNode(1);
//		ListNode a2 = new ListNode(2);
//		ListNode a3 = new ListNode(3);
//		ListNode a4 = new ListNode(4);
//		ListNode a5 = new ListNode(5);
//		ListNode a6 = new ListNode(6);
//
//		a1.next = a2;
//		a2.next = a3;
//		a3.next = a4;
//		a4.next = a5;
//		a5.next = a6;
//
//		ListNode out = reverseKGroup1(a1, 3);
//
//		while (out != null) {
//			System.out.println(out.val);
//			out = out.next;
//		}

//		System.out.println(countAndSay(5));

		// System.out.println(multiply("42", "32"));

//		System.out.println(strmatch("a", "*?*b"));

//		System.out.println(power(34.00515F, -3));

		// System.out.println(addBinary("1010", "1011"));

	}

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
