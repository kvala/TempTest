package test;

public class InOrderSuccessor {

	public static void main(String[] args) {
		BinaryTree n20 = new BinaryTree(20);
		BinaryTree n8 = new BinaryTree(8);
		BinaryTree n22 = new BinaryTree(22);
		n20.left = n8;
		n20.right = n22;

		BinaryTree n4 = new BinaryTree(4);
		BinaryTree n12 = new BinaryTree(12);
		n8.left = n4;
		n8.right = n12;

		BinaryTree n10 = new BinaryTree(10);
		BinaryTree n14 = new BinaryTree(14);

		n12.left = n10;
		n12.right = n14;

		BinaryTree out = inOrderSuccessor(n20, n14);

		if (out != null) {
			System.out.println(out.data);
		}

	}

	public static BinaryTree inOrderSuccessor(BinaryTree root, BinaryTree n) {
		// step 1 of the above algorithm
		if (n.right != null)
			return minValue(n.right);

		BinaryTree succ = null;

		// Start from root and search for successor down the tree
		while (root != null) {
			if (n.data < root.data) {
				succ = root;
				root = root.left;
			} else if (n.data > root.data)
				root = root.right;
			else
				break;
		}

		return succ;
	}

	public static BinaryTree minValue(BinaryTree node) {
		BinaryTree current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

}
