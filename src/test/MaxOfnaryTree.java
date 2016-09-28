package test;

import java.util.List;

public class MaxOfnaryTree {

	public static void main(String[] args) {
		NTN n25 = new NTN(25);
		
		NTN  n1000 = new NTN(1000);
		NTN  n2500 = new NTN(2500);
		NTN  n1200 = new NTN(1200);
		
		NTN  n750 = new NTN(750);
		NTN  n75 = new NTN(75);
		NTN  n7500 = new NTN(7500);
		
		n25.children.add(n1000);
		n25.children.add(n1200);
		n25.children.add(n2500);
		
		n2500.children.add(n7500);
		n2500.children.add(n750);
		n2500.children.add(n75);
		
		System.out.println(maximum(n25));
	}

	public static int maximum(NTN t) {
		int max = t.value;
		List<NTN> children = t.children;

		// only check if this node is not a leaf
		if (children != null && !children.isEmpty()) {
			for (NTN e : children) {
				// here is the recursion
				int maxNext = maximum(e);

				if (maxNext > max)
					max = maxNext;
			}
		}

		return max;
	}

}
