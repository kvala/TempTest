package test;

public class AppleTest1 {
	public boolean splitArray(int[] nums) {
		if (nums == null) {
			return false;
		}
		return isSumEqual(nums, 0, 0);
	}

	private boolean isSumEqual(int[] input, int i, int sum) {
		// base case
		if (i == input.length) {
			return (sum == 0);
		}

		if (isSumEqual(input, i + 1, sum + input[i])) {
			return true;
		}

		return isSumEqual(input, i + 1, sum - input[i]);
	}

	
	
	public static void main(String[] args) {
		AppleTest1 obj = new AppleTest1();
		int[] inputs = {-2,-5,-7};

		System.out.println(obj.splitArray(inputs));

	}

}
