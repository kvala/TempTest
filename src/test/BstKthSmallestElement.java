package test;

import java.util.Stack;

public class BstKthSmallestElement {

	public static void main(String[] args) {

		BinaryTree n2000 = new BinaryTree(2000);

		BinaryTree n1000 = new BinaryTree(1000);
		BinaryTree n3000 = new BinaryTree(3000);

		BinaryTree n1500 = new BinaryTree(1500);
		BinaryTree n1400 = new BinaryTree(1400);
		BinaryTree n500 = new BinaryTree(500);

		n2000.left = n1000;
		n2000.right = n3000;

		n1000.left = n500;
		n1000.right = n1500;

		n1500.left = n1400;
		BinaryTree ret = bstkthsmallestelementfind(n2000, 0);

		if (ret != null) {
			System.out.println(ret.data);
		} else {
			System.out.println("Returned null!");
		}

	}

	public static BinaryTree bstkthsmallestelementfind(BinaryTree root, int k) {
		Stack<BinaryTree> st = new Stack<BinaryTree>();
		if (root == null) {
			return null;
		}

		while (root != null) {
			st.push(root);
			root = root.left;
		}

		BinaryTree n;
		do {
			n = st.pop();
			k = k - 1;

			if (k == 0) {
				return n;
			}

			if (n.right != null) {
				BinaryTree r = n.right;
				while (r != null) {
					st.push(r);
					r = r.left;
				}
			}
		} while (n != null && !st.isEmpty());

		return null;
	}

}
