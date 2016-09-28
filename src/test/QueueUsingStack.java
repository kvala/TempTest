package test;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	public void push(int input) {
		s1.add(input);
	}

	public int pop() throws Exception {
		Integer returnval = null;
		if (s1.isEmpty() && s2.isEmpty()) {
			throw new Exception("Queue is empty.");
		}

		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.add(s1.pop());
			}
		}

		returnval = s2.pop();

		return returnval;

	}

	public static void main(String args[]) throws Exception {

		QueueUsingStack q = new QueueUsingStack();
		q.push(5);
		System.err.println(q.pop());

		q.push(6);

		q.push(7);
		System.err.println(q.pop());
		q.push(8);
		System.err.println(q.pop());
		System.err.println(q.pop());
		System.err.println(q.pop());

	}
}
