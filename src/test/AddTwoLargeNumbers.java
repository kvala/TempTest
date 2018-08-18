package test;

public class AddTwoLargeNumbers {

	public static void main(String[] args) {
		System.out.println(sumLargeNumbers("1234", "456"));

	}

	public static String sumLargeNumbers(String number1, String number2) {

		StringBuilder sb = new StringBuilder();
		if (number1.length() > number2.length()) {
			String temp = number2;
			number2 = number1;
			number1 = temp;
		}

		int n1 = number1.length() - 1;
		int n2 = number2.length() - 1;
		int carry = 0;

		while (n1 >= 0 && n2 >= 0) {
			int num1 = number1.charAt(n1) - '0';
			int num2 = number2.charAt(n2) - '0';
			int sum = num1 + num2 + carry;
			carry = sum / 10;
			sum = sum % 10;

			sb.append(sum);
			n1--;
			n2--;
		}

		while (n2 >= 0) {
			int num2 = number2.charAt(n2) - '0';
			int sum = num2 + carry;
			carry = sum / 10;
			sum = sum % 10;

			sb.append(sum);
			n2--;

		}

		if (carry > 0) {
			sb.append(carry);
		}
		return reverse(sb.toString());
	}

	public static String reverse(String input) {
		char[] ichar = input.toCharArray();
		int start = 0, end = ichar.length - 1;
		while (start < end) {
			char temp = ichar[start];
			ichar[start] = ichar[end];
			ichar[end] = temp;
			start++;
			end--;

		}

		return new String(ichar);
	}

}
