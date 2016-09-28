package test;

import java.util.Stack;

class LinkedListNode {
	LinkedListNode next;
	int data;

	public LinkedListNode(int data) {
		this.data = data;
	}
}

public class PrintReverseLinkedList {

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		//printLinkedListReverse(n1);
		
		printReverse(n1);
	}

	public static void printLinkedListReverse(LinkedListNode node) {
		if (node == null) {
			return;
		}

		printLinkedListReverse(node.next);
		System.out.print(" " + node.data);
	}

	public static void printReverse(LinkedListNode node) {
		Stack<LinkedListNode> stack = new Stack<LinkedListNode>();
		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		while (!stack.empty())
			System.out.println(stack.pop().data);
	}

}
