package test;

class Node2 {
	int data;
	Node2 left, right;

	public Node2(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTree2 {

	Node2 root;

	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isBSTUtil(Node2 node, int min, int max) {

		if (node == null)
			return true;

		if (node.data < min || node.data > max)
			return false;
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}

	public static void main(String args[]) {
		BinaryTree2 tree = new BinaryTree2();
		tree.root = new Node2(13);
		tree.root.left = new Node2(10);
		tree.root.right = new Node2(15);
		tree.root.left.left = new Node2(4);
		tree.root.left.right = new Node2(14);

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}

}
