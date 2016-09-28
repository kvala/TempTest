package test;

public class HashMap {

	private final static int TABLE_SIZE = 128;

	HashEntry[] table;

	HashMap() {
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	public int get(int key) {
		int hash = (key % TABLE_SIZE);
		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % TABLE_SIZE;
		if (table[hash] == null)
			return -1;
		else
			return table[hash].getValue();
	}

	public void put(int key, int value) {
		int hash = (key % TABLE_SIZE);
		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % TABLE_SIZE;
		table[hash] = new HashEntry(key, value);
	}

	public static void main(String[] args) {
		HashMap h = new HashMap();
		h.put(1, 10);
		h.put(2, 20);
		h.put(3, 30);

		System.out.println(h.get(2));

	}

}
