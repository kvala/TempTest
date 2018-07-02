package test;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };
		for (int i : twoSum(nums, 9)) {
			System.out.println(i);
		}

	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] output = new int[2];
		for (int num : nums) {
			Integer i = map.get(target - num);

			if (i == null) {
				output[0] = num;
				output[1] = target - num;
				return output;
			}
			map.put(num, 1);
		}

		return output;
	}

}
