package test;

public class FindRepeatingNumber {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
		System.out.print(findRepeatingNumber(input, 10));

	}

	public static int findRepeatingNumber(int[] input, int num) {
		int sumofnNum = num * (num + 1) / 2;
		System.out.println(sumofnNum);
		int inputSum = 0;
		for (int n : input) {
			inputSum = inputSum + n;
		}

		System.out.println(inputSum);
		return inputSum - sumofnNum;
	}

}
