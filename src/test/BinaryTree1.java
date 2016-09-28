package test;

//Java program to print BST in given range

//A binary tree node
class Node1 {

	int data;
	Node1 left, right;

	Node1(int d) {
		data = d;
		left = right = null;
	}
}

class BinaryTree1 {

	static Node1 root;

	/*
	 * A function that constructs Balanced Binary Search Tree from a sorted
	 * array
	 */
	Node1 sortedArrayToBST(int arr[], int start, int end) {

		/* Base Case */
		if (start > end) {
			return null;
		}

		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		Node1 node = new Node1(arr[mid]);

		/*
		 * Recursively construct the left subtree and make it left child of root
		 */
		node.left = sortedArrayToBST(arr, start, mid - 1);

		/*
		 * Recursively construct the right subtree and make it right child of
		 * root
		 */
		node.right = sortedArrayToBST(arr, mid + 1, end);

		return node;
	}

	/* A utility function to print preorder traversal of BST */
	void preOrder(Node1 node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {
		BinaryTree1 tree = new BinaryTree1();
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int n = arr.length;
		root = tree.sortedArrayToBST(arr, 0, n - 1);
		System.out.println("Preorder traversal of constructed BST");
		tree.preOrder(root);
	}
}
