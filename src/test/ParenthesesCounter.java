package test;

public class ParenthesesCounter {

	public static int counter(String[] input) {
		int max = 0, open = 0, close = 0;

		for (String i : input) {
			if (i == "(" && close == 0) {
				open++;
			} else if (i == ")") {
				close++;
			} else {
				int lmax = Math.min(open, close);
				if (lmax > max) {
					max = lmax;
				}
				close = 0;
				open = 1;

			}

		}
		return max;
	}

	public static int counter(String input) {
		int max = 0, open = 0, close = 0;

		char[] inputArray = input.toCharArray();
		for (char i : inputArray) {
			if (i == '(' && close == 0) {
				open++;
			} else if (i == ')') {
				close++;
			} else {
				int lmax = Math.min(open, close);
				if (lmax > max) {
					max = lmax;
				}
				close = 0;
				open = 1;

			}

		}
		return max;
	}

	public static void main(String[] args) {
		// String[] input = { ")", "(", "(", "(", ")", ")", ")", "(", ")" };
		// System.out.println(counter(input));

		String input2 = ")((()))()()";
		System.out.println(counter(input2));

	}

}
