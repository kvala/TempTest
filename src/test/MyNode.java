package test;

import java.util.ArrayList;
import java.util.List;

public class MyNode {

	private String node;
	private List<MyNode> nodes;

	public MyNode(String node) {
		super();
		this.node = node;
		this.nodes = new ArrayList<MyNode>();
	}

	public MyNode(String node, List<MyNode> nodes) {
		super();
		this.node = node;
		this.nodes = nodes;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public List<MyNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<MyNode> nodes) {
		this.nodes = nodes;
	}

	@Override
	public int hashCode() {
		return node.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass().equals(obj.getClass())) {
			return ((MyNode) obj).getNode().equals(node);
		}
		return false;

	}

	@Override
	public String toString() {
		return node + "[" + nodes.size() + "]";
	}

}