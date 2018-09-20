package br.com.projuris;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyFindArrayTest {
	
	private FindArray findArray;
	
	@Before
	public void init() {
		findArray = new MyFindArray();
	}
	
	@Test
	public void testCase1() {
		int[] array = {4,9,3,7,8};
		int[] subArray = {3, 7};
		Assert.assertEquals(findArray.findArray(array, subArray), 2);
	}
	
	@Test
	public void testCase2() {
		int[] array = {1,3,5};
		int[] subArray = {1};
		Assert.assertEquals(findArray.findArray(array, subArray), 0);
	}
	
	@Test
	public void testCase3() {
		int[] array = {7,8,9};
		int[] subArray = {8,9,10};
		Assert.assertEquals(findArray.findArray(array, subArray), -1);
	}
	
	@Test
	public void testCase4() {
		int[] array = {4,9,3,7,8,3,7,1};
		int[] subArray = {3, 7};
		Assert.assertEquals(findArray.findArray(array, subArray), 5);
	}

}
