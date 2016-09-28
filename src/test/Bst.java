package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bst {
	public static int countWords2(String s) {
		int count = 0;
		boolean found = false;
		int endOfLine = s.length() - 1;

		int i = 0;
		while (i < s.length()) {
			boolean isLetter = Character.isLetter(s.charAt(i));
			boolean isDigit = Character.isDigit(s.charAt(i));

			if ((isLetter || isDigit) && i != endOfLine) {
				found = true;
				// if char isn't a letter and there have been letters before,
				// counter goes up.
			} else if (!(isLetter || isDigit) && found) {
				count++;
				found = false;
				// last word of String; if it doesn't end with a non letter, it
				// wouldn't count without this.
			} else if ((isLetter || isDigit) && i == endOfLine) {
				count++;
			}
			i++;
		}
		return count;
	}

	public static int countWords3(String s) {
		int count = 0;
		boolean preCharWasLetterOrDigit = false;
		int endOfLine = s.length() - 1;

		int i = 0;
		while (i < s.length()) {
			boolean isLetter = Character.isLetter(s.charAt(i));
			boolean isDigit = Character.isDigit(s.charAt(i));

			if (isLetter || isDigit) {
				if (i == endOfLine) {
					count++;
				} else {
					preCharWasLetterOrDigit = true;
				}

			} else if (preCharWasLetterOrDigit) {
				count++;
				preCharWasLetterOrDigit = false;
			}
			i++;
		}
		return count;
	}

	public static String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line.trim().replace("'", ""));
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}
	/*
	public static void main(String[] args) {
		String s = "this is print@@@@ count ";
		
		System.out.println(s);
		System.out.println(countWords3(s));
		
		
	}
	*/
	public static String sumTwoBigNumbers(String no1, String no2) {
		
		return "";
		
	}
}
