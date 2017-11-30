package test;

public class FindClosestElementBST {
	public static void main(String[] args) {
		BinaryTree d9 = new BinaryTree(9);
		BinaryTree d4 = new BinaryTree(4);
		BinaryTree d17 = new BinaryTree(17);
		d9.left = d4;
		d9.right = d17;

		BinaryTree d3 = new BinaryTree(3);
		BinaryTree d6 = new BinaryTree(6);
		d4.left = d3;
		d4.right = d6;

		BinaryTree d5 = new BinaryTree(5);
		BinaryTree d7 = new BinaryTree(7);
		d6.left = d5;
		d6.right = d7;

		BinaryTree d22 = new BinaryTree(22);
		d17.right = d22;

		BinaryTree d20 = new BinaryTree(20);
		d22.left = d20;

		System.out.println(findClosestElement(d9, 4, Integer.MAX_VALUE, -1));

	}

	public static int findClosestElement(BinaryTree root, int k, int mindifference, int mink) {
		if (root == null) {
			return mink;
		}

		if (root.data == k) {
			mink = k;
			return k;
		}

		if (mindifference > Math.abs(root.data - k)) {
			mindifference = Math.abs(root.data - k);
			mink = root.data;
		}

		if (k < root.data) {
			return findClosestElement(root.left, k, mindifference, mink);
		} else {
			return findClosestElement(root.right, k, mindifference, mink);
		}

	}
}
