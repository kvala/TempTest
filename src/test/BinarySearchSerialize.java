package test;

import java.util.LinkedList;

//https://www.programcreek.com/2014/05/leetcode-serialize-and-deserialize-binary-tree-java/

public class BinarySearchSerialize {

	public static void main(String[] args) {
		BinaryTree d1 = new BinaryTree(1);
		BinaryTree d2 = new BinaryTree(2);
		BinaryTree d3 = new BinaryTree(3);
		d1.left = d2;
		d1.right = d3;

		BinaryTree d4 = new BinaryTree(4);
		d2.right = d4;

		serialize(d1);

	}

	public static String serialize(BinaryTree root) {
		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();

		LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();

		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTree t = queue.poll();
			if (t != null) {
				sb.append(String.valueOf(t.data) + ",");
				queue.add(t.left);
				queue.add(t.right);
			} else {
				sb.append("#,");
			}
		}

		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public BinaryTree deserialize(String data) {
		if (data == null || data.length() == 0)
			return null;

		String[] arr = data.split(",");
		BinaryTree root = new BinaryTree(Integer.parseInt(arr[0]));

		LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(root);

		int i = 1;
		while (!queue.isEmpty()) {
			BinaryTree t = queue.poll();

			if (t == null)
				continue;

			if (!arr[i].equals("#")) {
				t.left = new BinaryTree(Integer.parseInt(arr[i]));
				queue.offer(t.left);

			} else {
				t.left = null;
				queue.offer(null);
			}
			i++;

			if (!arr[i].equals("#")) {
				t.right = new BinaryTree(Integer.parseInt(arr[i]));
				queue.offer(t.right);

			} else {
				t.right = null;
				queue.offer(null);
			}
			i++;
		}

		return root;
	}

}
