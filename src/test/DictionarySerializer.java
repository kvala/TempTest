package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Serialize Input : dict(“a”: “apple”, “b”: dict(“b”: “blueberry”, “c”:
 * “cranberry”)) Expected output String :
 * “{a:apple,b:{b:blueberry,c:cranberry}}”
 */

public class DictionarySerializer {
	public interface DictEntry {
		public boolean isDict();
	}

	public static class Dict implements DictEntry {
		private Map<String, DictEntry> map;

		public Dict(Map<String, DictEntry> map) {
			this.map = map;
		}

		public boolean isDict() {
			return true;
		}

		public Set<String> getKeys() {
			return map.keySet();
		}

		public DictEntry get(String key) {
			return map.get(key);
		}
	}

	public static class StringWrapper implements DictEntry {

		private String str;

		public StringWrapper(String str) {
			this.str = str;
		}

		public boolean isDict() {
			return false;
		}

		public String getValue() {
			return str;
		}
	}

	/*
	 * Input : dict(“a”: “apple”, “b”: dict(“b”: “blueberry”, “c”: “cranberry”))
	 * Expected output String : “{a:apple,b:{b:blueberry,c:cranberry}}”
	 */
	public static void main(String[] args) {
		Map<String, DictEntry> map1 = new HashMap<>();
		map1.put("b", new StringWrapper("blueberry"));
		map1.put("c", new StringWrapper("cranberry"));
		DictEntry dict1 = new Dict(map1);

		Map<String, DictEntry> map = new HashMap<>();
		map.put("a", new StringWrapper("apple"));
		map.put("b", dict1);
		DictEntry dict = new Dict(map);

		System.out.println("Serialized string : " + serialize(dict));
	}

	// implement
	public static String serialize(DictEntry entry) {
		StringBuffer sb = new StringBuffer();

		if (entry == null) {
			return "";
		}

		if (!entry.isDict()) {
			return ((StringWrapper) entry).getValue();
		}

		sb.append("{");
		Set<String> keys = ((Dict) entry).getKeys();
		int i = 0;
		for (String key : keys) {
			DictEntry dict = ((Dict) entry).get(key);
			i++;
			sb.append(key + ":" + serialize(dict));
			if (i != keys.size()) {
				sb.append(",");
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
