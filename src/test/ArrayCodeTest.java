package test;

import org.junit.Assert;
import org.junit.Test;

public class ArrayCodeTest {

	@Test
	public void test() {
		int[] input = { 12, 3, 3, 4, 15, 16, 35 };
		Assert.assertEquals(4, ArrayCode.findSmallestUniqueValue(input));
	}

	@Test
	public void test2() {
		int[] input = { 12, 3, 4, 15, 16, 35 };
		Assert.assertEquals(3, ArrayCode.findSmallestUniqueValue(input));
	}

	@Test
	public void test3() {
		int[] input = { 12, 3, 12, 3, 16, 16 };
		Assert.assertEquals(Integer.MAX_VALUE, ArrayCode.findSmallestUniqueValue(input));
	}

	@Test
	public void test4() {
		Assert.assertEquals(Integer.MAX_VALUE, ArrayCode.findSmallestUniqueValue(null));
	}

	@Test
	public void test5() {
		int[] input = {};
		Assert.assertEquals(Integer.MAX_VALUE, ArrayCode.findSmallestUniqueValue(input));
	}

	@Test
	public void test6() {
		int[] input = { -12, 3, 3, 4, 15, 16, 35 };
		Assert.assertEquals(-12, ArrayCode.findSmallestUniqueValue(input));
	}

	@Test
	public void test7() {
		int[] input = { 0 };
		Assert.assertEquals(0, ArrayCode.findSmallestUniqueValue(input));
	}
}
