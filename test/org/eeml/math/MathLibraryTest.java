package org.eeml.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathLibraryTest {
	@Test
	public void testGCD() {
		assertEquals(1, MathLibrary.gcd(4, 5));
		assertEquals(1, MathLibrary.gcd(1, 5));
		assertEquals(2, MathLibrary.gcd(4, 6));
	}
}
