package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		ArrayList<Integer> list = new ArrayList<>();

		for (int valor : nums) {
			list.add(valor);
		}

		System.out.println("list : " + list);

		List<Integer> list2 = Arrays.stream(nums).boxed().collect(Collectors.toList());
		System.out.println("list2 : " + list2);

		List<int[]> ints = Arrays.asList(nums);

		System.out.println("list3 : " + ints);

	}

}
