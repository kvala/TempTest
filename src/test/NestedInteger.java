package test;

import java.util.List;

public class NestedInteger {
	List<NestedInteger> nestedList;
	Integer intval;

	public boolean isInteger() {
		return intval != null;
	}

	public List<NestedInteger> getList() {
		return nestedList;
	}

	public int getInteger() {
		return intval;
	}

}
