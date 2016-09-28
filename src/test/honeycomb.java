package test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class honeycomb {

	public static void main(String[] args) {
		List<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
		ArrayList<String> t1 = new ArrayList<String>();
		t1.add("A");

		input.add(t1);

		ArrayList<String> t2 = new ArrayList<String>();
		t2.add("B");
		t2.add("C");
		t2.add("D");
		t2.add("E");
		t2.add("F");
		t2.add("G");

		input.add(t2);

		Hashtable<Integer, ArrayList<HoneycombNode>> dictforlayerNodes = new Hashtable<Integer, ArrayList<HoneycombNode>>();

		HoneycombNode prev = null;

		int layer = 1;
		for (List<String> list : input) {

			System.out.println(list);
			for (int j = 0; j < list.size(); j++) {

				int nextedgeindex = 1;
				HoneycombNode n1 = new HoneycombNode(list.get(j));

				if (dictforlayerNodes.get(layer) == null) {
					ArrayList<HoneycombNode> data = new ArrayList<HoneycombNode>();
					dictforlayerNodes.put(layer, data);
				}

				n1.layer = layer;
				dictforlayerNodes.get(layer).add(n1);

				if (prev != null) {
					
					prev.edge.add(nextedgeindex,n1);
					prev = n1;
				}

			}
			if (list.size() > 0) {

				//to point G -> B
				if(prev!=null){
					prev.edge.add(dictforlayerNodes.get(layer).get(0));
				}
				
				prev = dictforlayerNodes.get(layer).get(0);
				
			}

			layer++;
		}

		for (Integer layerdict : dictforlayerNodes.keySet()) {
			HoneycombNode n = (dictforlayerNodes.get(layerdict).get(0));
			int i = 0;
			System.out.println(i + n.value);
		}

	}

	public static int getsamelayernextindex(int i) {
		if (i == 3) {
			return 6;
		}

		if (i == 4) {
			return 1;
		}

		if (i == 5) {
			return 2;
		}

		if (i == 6) {
			return 3;
		}

		if (i == 1) {
			return 4;
		}

		if (i == 2) {
			return 5;
		}

		// default
		return 1;
	}

	public static int getsamelayernextnode(int i, int layer) {

		int maxlayercanhave = layer * 6;

		if (i >= maxlayercanhave) {
			return 1;
		}

		// if count > layer * 6 then return 1;
		return i + 1;
	}

	public static int getprevlayernextindex(int i) {
		if (i == 4) {
			return 1;
		}

		if (i == 5) {
			return 2;
		}

		if (i == 6) {
			return 3;
		}

		if (i == 1) {
			return 4;
		}

		if (i == 2) {
			return 5;
		}

		if (i == 3) {
			return 6;
		}

		// default
		return 1;
	}

	static class HoneycombNode {
		String value;
		ArrayList<HoneycombNode> edge;
		int layer;

		public HoneycombNode(String string) {
			this.value = string;
			this.edge = new ArrayList<HoneycombNode>();
		}
	}
}
