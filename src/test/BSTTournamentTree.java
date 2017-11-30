package test;

/**
 * A tournament tree is a binary tree where the parent is the minimum of the two
 * children. Given a tournament tree find the second minimum value in the tree.
 * A node in the tree will always have 2 or 0 children. Also all leaves will
 * have distinct and unique values. 2 / \ 2 3 / \ / \ 4 2 5 3
 *
 * In this given tree the answer is 3.
 */
public class BSTTournamentTree {
	public static Integer secondMin(Node root) {
		if (root.left == null || root.right == null)
			return Integer.MAX_VALUE;
		int min;
		if (root.left.data == root.data) {
			min = Math.min(root.right.data, secondMin(root.left));
		} else {
			min = Math.min(root.left.data, secondMin(root.right));
		}

		return min;
	}

	public static Integer secondMin2(Node root) {
		if (root.left == null && root.right == null) {
			return Integer.MAX_VALUE;
		}
		Node node;
		int min;
		if (root.left.data == root.data) {
			node = root.left;
			min = root.right.data;
		} else {
			node = root.right;
			min = root.left.data;
		}
		return Math.min(min, secondMin2(node));
	}

	public static void main(String args[]) {
		Node d2 = new Node(2);
		Node d21 = new Node(2);
		Node d3 = new Node(3);

		d2.left = d21;
		d2.right = d3;

		Node d4 = new Node(4);
		Node d22 = new Node(2);

		d21.left = d4;
		d21.right = d22;

		Node d5 = new Node(5);
		Node d31 = new Node(3);

		d3.left = d5;
		d3.right = d31;

		System.out.println(secondMin(d2));
		System.out.println(secondMin2(d2));
	}

}
