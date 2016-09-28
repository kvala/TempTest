package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringToTree {
	public static void main(String[] args) {
		StringToTree testMain = new StringToTree();

		List<String> testData = new ArrayList<String>();
		testData.add("com-bo-news-2012,12");
		testData.add("com-bo-news-2015,3");
		testData.add("net-php-www,20");
		testData.add("net-phototrails,3");

		MyNode myNode = new MyNode("ROOT");

		for (String string : testData) {
			List<String> l = new ArrayList<String>();
			l.addAll(Arrays.asList(string.split("-")));

			testMain.buildTree(l, myNode);
		}

		printTree(myNode, 1);

	}

	private void buildTree(List<String> nodeNames, MyNode node) {
		if (nodeNames.isEmpty()) {
			return;
		}
		String nodeName = nodeNames.remove(0);
		MyNode myNode = new MyNode(nodeName);
		int index = node.getNodes().indexOf(myNode);

		if (index == -1) {
			node.getNodes().add(myNode);
		} else {
			myNode = node.getNodes().get(index);
		}

		buildTree(nodeNames, myNode);

	}

	private static void printTree(MyNode myNode, int tabCount) {
		for (int i = 0; i < tabCount; i++) {
			System.out.print("\t");
		}

		System.out.print(myNode.getNode() + "\n");

		for (int i = 0; i < tabCount; i++) {
			System.out.print("\t");
		}

		System.out.println("|");

		for (MyNode node : myNode.getNodes()) {
			printTree(node, ++tabCount);
		}

	}
}
