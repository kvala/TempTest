package unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import test.IntHelper;

public class IntHelperTest {

	@Test
	public void FindSumOfTwoNumbersTest() {
		int[] input = { 1, 5, 4, 3, 4, 8 };
		IntHelper.FindSumOfTwoNumbers(input, 8);
	}

	@Test
	public void FindSumOfTwoNumbersSortingTest() {
		int[] input = { 1, 5, 4, 3, 4, 8 };
		IntHelper.FindSumOfTwoNumbers(input, 8);
	}

	@Test
	public void MergeSortTest() {
		int[] input = { 5, 9, 15, 2, 1, -1, -2 };
		IntHelper.MergeSort(input);
		
		assertArrayEquals(new int[] { -2, -1, 1, 2, 5, 9, 15 }, input);
	}

}
