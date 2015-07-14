package com.dimit.test;

import org.junit.Test;

public class StringTest {

	@Test
	public void test() {
		String abc = String.format("a%sb%s", new Object[]{"=1","=2"});
		System.out.println(abc);
	}

}
