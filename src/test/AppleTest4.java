package test;

public class AppleTest4 {
	public boolean canBalance(int[] nums) {
		int leftsum = 0;

		for (int index = 0; index < nums.length - 1; index++) {
			leftsum += nums[index];
		}
		int rightsum = nums[nums.length - 1];
		for (int index = nums.length - 2; index > 1; index--) {
			if (leftsum == rightsum) {
				return true;
			}
			leftsum -= nums[index];
			rightsum += nums[index];
		}

		return (leftsum == rightsum);
	}

	public static void main(String[] args) {
		AppleTest4 t = new AppleTest4();
		int [] input = {};
		
		System.out.println(t.canBalance(input));

	}

}
