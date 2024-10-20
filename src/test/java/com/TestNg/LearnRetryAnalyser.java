package com.TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LearnRetryAnalyser {
	@Test
	public void testCaseOne() {
		Assert.assertEquals(true, false);
		
	}
	@Test
	public void testCaseTwo() {
		Assert.assertEquals(false, true);
	}

}
