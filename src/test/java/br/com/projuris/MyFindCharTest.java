package br.com.projuris;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyFindCharTest {

	private FindCharachter findCharachter;

	@Before
	public void init() {
		findCharachter = new MyFindChar();
	}

	@Test
	public void testCase1() {
		Assert.assertEquals(findCharachter.findChar("stress"), 't');
	}

	@Test
	public void testCase2() {
		Assert.assertEquals(findCharachter.findChar("reembolsar"), 'm');
	}

	@Test
	public void testCase3() {
		Assert.assertEquals(findCharachter.findChar("aabbcc"), Character.MIN_VALUE);
	}

}
