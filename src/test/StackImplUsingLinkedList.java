package test;

public class StackImplUsingLinkedList {
	Node head;

	// int size;

	public void push(int value) {
		Node n = new Node(value);

		n.next = head;
		head = n;

		// size++;
	}

	public Node pop() throws Exception {
		if (head == null) {
			throw new Exception("Stack is Empty.");
		}
		Node temp = head;
		head = head.next;
		return temp;
	}

	/*
	 * public int size() { return size; }
	 */

	public boolean isEmpty() {
		return head == null;
	}

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}

	}
}
