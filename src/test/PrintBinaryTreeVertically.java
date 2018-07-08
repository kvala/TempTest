package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTreeVertically {

	public static void main(String[] args) {

		BinaryTree n20 = new BinaryTree(20);
		BinaryTree n8 = new BinaryTree(8);
		BinaryTree n22 = new BinaryTree(22);
		BinaryTree n4 = new BinaryTree(4);
		BinaryTree n12 = new BinaryTree(12);
		BinaryTree n10 = new BinaryTree(10);
		BinaryTree n14 = new BinaryTree(14);

		BinaryTree n21 = new BinaryTree(21);

		BinaryTree n6 = new BinaryTree(6);
		BinaryTree n7 = new BinaryTree(7);

		n20.left = n8;
		n20.right = n22;

		n8.left = n4;
		n8.right = n12;

		n12.left = n10;
		n12.right = n14;

		n22.left = n21;

		n4.right = n6;
		n6.right = n7;

		HashMap<Integer, ArrayList<Integer>> map = verticlePrint(n20);

		for (int key : map.keySet()) {
			System.out.println(key + " = " + map.get(key));
		}

	}

	public static HashMap<Integer, ArrayList<Integer>> verticlePrint(BinaryTree node) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		traverse(node, 0, map);
		return map;
	}

	public static void traverse(BinaryTree node, int distance, HashMap<Integer, ArrayList<Integer>> map) {
		if (node == null) {
			return;
		}

		if (map.containsKey(distance)) {
			ArrayList<Integer> old = map.get(distance);
			old.add(node.data);
		} else {
			ArrayList<Integer> ndata = new ArrayList<Integer>();
			ndata.add(node.data);
			map.put(distance, ndata);

		}

		traverse(node.left, distance - 1, map);
		traverse(node.right, distance + 1, map);

	}

	//if print order matters
	public static HashMap<Integer, ArrayList<Integer>> verticlePrintByLevel(BinaryTree node) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		Queue<BinaryTree> que = new LinkedList<BinaryTree>();
		if (node == null) {
			return map;
		}
		que.add(node);

		while (!que.isEmpty()) {
			BinaryTree current = que.remove();
			
			//We need to push BinaryTree node and key to Queue
			
		}
		return map;

	}

	public static HashMap<Integer, ArrayList<Integer>> printbycolumn(BinaryTree node, int distance) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		if (node == null) {
			return map;
		}

		if (map.containsKey(distance)) {
			ArrayList<Integer> old = map.get(distance);
			old.add(node.data);
		} else {
			ArrayList<Integer> ndata = new ArrayList<Integer>();
			ndata.add(node.data);
			map.put(distance, ndata);

		}
		HashMap<Integer, ArrayList<Integer>> lmap = printbycolumn(node.left, distance - 1);
		map = merge(lmap, map);
		HashMap<Integer, ArrayList<Integer>> rmap = printbycolumn(node.right, distance + 1);
		map = merge(rmap, map);
		return map;
	}

	public static HashMap<Integer, ArrayList<Integer>> merge(HashMap<Integer, ArrayList<Integer>> map1,
			HashMap<Integer, ArrayList<Integer>> map2) {

		for (Integer key : map2.keySet()) {
			ArrayList<Integer> list1 = map1.get(key);
			ArrayList<Integer> list2 = map2.get(key);
			if (list1 != null) {
				list2.addAll(list2);
			} else {
				map2.put(key, list2);
			}
		}
		return map2;

	}
}
