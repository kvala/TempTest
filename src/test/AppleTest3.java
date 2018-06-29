package test;

public class AppleTest3 {

	// THIS is a FISH TH a FH
	public String withoutString(String base, String remove) {
		String output = null;
		if (base == null) {
			return output;
		}
		if (remove == null) {
			return base;
		}
		String[] parts = base.split(remove, -1);
		output = String.join("", parts);
		return output;
	}

	public String withoutString2(String base, String remove) {
		StringBuilder sb = new StringBuilder();
		if (base == null) {
			return null;
		}
		if (remove == null) {
			return base;
		}

		remove = remove.toLowerCase();
		int removeCounter = 0;
		int removeLength = remove.length();
		int baseLength = base.length();

		for (int baseCounter = 0; baseCounter < base.length(); baseCounter++) {
			if ((Character.toLowerCase(base.charAt(baseCounter)) == remove.charAt(removeCounter))
					&& (baseCounter <= baseLength + removeCounter - removeLength)) {
				removeCounter++;
				removeCounter %= removeLength;
			} else {
				baseCounter -= removeCounter;
				sb.append(base.charAt(baseCounter));
				removeCounter = 0;
			}
		}

		return sb.toString();
	}

	public String withoutString4(String base, String remove) {
		StringBuilder sb = new StringBuilder();
		if (base == null) {
			return null;
		}
		if (remove == null) {
			return base;
		}

		remove = remove.toLowerCase();
		int bsize = base.length();
		int rsize = remove.length();
		int bstart = 0;
		int rstart = 0;

		while (bstart < bsize && rstart < rsize) {
			if (Character.toLowerCase(base.charAt(bstart)) != remove.charAt(rstart)) {
				sb.append(base.charAt(bstart));
				bstart++;
			} else if (rstart == rsize) {
				rstart = 0;
			} else {
				sb.append(base.charAt(bstart - rstart));
				bstart++;
				rstart = 0;
			}

		}
		return sb.toString();
	}

	public String withoutString3(String base, String remove) {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < base.length(); i++) {
			if (i > base.length() - remove.length()) {
				output.append(base.substring(i, base.length()));
				break;
			} else {
				String substring = base.substring(i, i + remove.length());
				if (!(substring.equalsIgnoreCase(remove))) {
					output.append(base.charAt(i));
				} else {
					i = i + remove.length() - 1;
				}
			}
		}
		return output.toString();
	}

	public static void main(String[] args) {
		AppleTest3 obj = new AppleTest3();

		String base = "wel";
		String remove = "this is welcome";
		System.out.println(obj.withoutString2(base, remove));

	}

}
