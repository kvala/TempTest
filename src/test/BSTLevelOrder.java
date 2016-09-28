package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTLevelOrder {

	public static void main(String[] args) {

		BinaryTree n1 = new BinaryTree(56);
		BinaryTree n2 = new BinaryTree(45);
		BinaryTree n3 = new BinaryTree(75);
		BinaryTree n4 = new BinaryTree(175);
		BinaryTree n5 = new BinaryTree(275);
		BinaryTree n6 = new BinaryTree(150);
		n1.left = n2;
		n1.right = n3;
		n3.right = n4;
		n4.right = n5;
		n4.left = n6;

		System.out.println("\nStarted using single Queue");
		printLevelOrderUsingQueue(n1);
		System.out.println("\nEnded using single Queue\n");

		System.out.println("\nStarted using two Queue");
		printLevelOrder(n1);
		System.out.println("\nEnded using two Queue\n");

		List<ArrayList<Integer>> out = levelOrder(n1);
		for (ArrayList<Integer> s : out) {
			System.out.println(s);
		}
	}

	// Using two queues.
	public static void printLevelOrder(BinaryTree root) {
		if (root == null)
			return;
		Queue<BinaryTree> currentLevel = new LinkedList<BinaryTree>();
		Queue<BinaryTree> nextLevel = new LinkedList<BinaryTree>();
		currentLevel.add(root);
		while (!currentLevel.isEmpty()) {
			BinaryTree currNode = currentLevel.poll();

			if (currNode != null) {
				System.out.print(currNode.data + " ");

				nextLevel.add(currNode.left);
				nextLevel.add(currNode.right);
			}
			if (currentLevel.isEmpty()) {
				System.out.println(" ");
				currentLevel = nextLevel;
				nextLevel = new LinkedList<BinaryTree>();
			}
		}
	}

	public static List<ArrayList<Integer>> levelOrder(BinaryTree root) {
		List<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> nodeValues = new ArrayList<Integer>();
		if (root == null)
			return al;

		LinkedList<BinaryTree> current = new LinkedList<BinaryTree>();
		LinkedList<BinaryTree> next = new LinkedList<BinaryTree>();
		current.add(root);

		while (!current.isEmpty()) {
			BinaryTree node = current.remove();

			if (node.left != null)
				next.add(node.left);
			if (node.right != null)
				next.add(node.right);

			nodeValues.add(node.data);
			if (current.isEmpty()) {
				current = next;
				next = new LinkedList<BinaryTree>();
				al.add(nodeValues);
				nodeValues = new ArrayList<Integer>();
			}

		}
		return al;
	}

	public static void printLevelOrderUsingQueue(BinaryTree root) {
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(root);
		while (!queue.isEmpty()) {

			/*
			 * poll() removes the present head. For more information on poll()
			 * visit http://www.tutorialspoint.com/java/util/linkedlist_poll.htm
			 */
			BinaryTree tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
}
