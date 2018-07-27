package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] can = { 2, 4, 6, 8 };
		List<List<Integer>> result = combinationSum(can, 8);

		for (List<Integer> sub : result) {
			System.out.println(sub);
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates); // sort the array, through this way we just need to consider the ith number and
									// subsequent numbers
		return combsub(candidates, target, 0);
	}

	private static List<List<Integer>> combsub(int[] nums, int target, int start) {
		// "thislevel" returns all the answers in this recursion, whose sum equals
		// target.
		List<List<Integer>> thislevel = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return thislevel;
		}
		// from "start" to the end of the array, initially start equals to 0
		for (int i = start; i < nums.length; i++) {
			if (nums[i] > target) {
				break;
			} // since the array is sorted, if the smallest element is larger than target, we
				// can run out of the for-loop
				// This statement is equal to "if (remain < 0) { break; }", which is eaiser to
				// understand.
			int remain = target - nums[i];
			if (remain == 0) {
				// In fact, "remain == 0" will only occur in the last recusion, which means that
				// we will minus a number until target equals nums[i].
				// In this case, we just add nums[i] to the List<Integer> "arr" and add "arr" to
				// thislevel.
				// Maybe you may get confused that arr has just one element. But in the
				// following algorithm, more elements will be added to the arr to satisfy the
				// final target.
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(nums[i]);
				thislevel.add(arr);
			} else {
				// In this case, if remian != 0, then we just use the List<List<Integer>> prev
				// returned from the remain. Then add the nums[i] to each answer in "prev", to
				// make their sum equal to "target".
				// Why we use combsub(nums, remain, i) here? Or why "i" here not "i+1"?
				// This is to consider the duplicate case. If nums[i] is done and i++, the start
				// will also change according to the value of i.
				List<List<Integer>> prev = combsub(nums, remain, i);
				for (List<Integer> l : prev) {
					l.add(0, nums[i]);
					thislevel.add(l);
				}
			}
		}
		return thislevel;
	}
}
