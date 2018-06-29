package test;

public class AppleTest2 {
	public int countTriple(String str) {
		int count = 0;
		// check for null
		if (str == null) {
			return count;
		}

		for (int index = 0; index < str.length() - 2; index++) {
			if (str.charAt(index) == str.charAt(index + 1) && str.charAt(index) == str.charAt(index + 2)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

	}

}