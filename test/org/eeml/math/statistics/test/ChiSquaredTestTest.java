package org.eeml.math.statistics.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChiSquaredTestTest {
	ChiSquaredTest test1 = new ChiSquaredTest(new double[][]{
			{15, 95},
			{85, 5}
	});
	ChiSquaredTest test2 = new ChiSquaredTest(new double[][]{
			{55, 45},
			{43, 66}
	});

	@Test
	public void testGetDF() {
		assertEquals(1, test1.getDf());
		assertEquals(1, test2.getDf());
	}

	@Test
	public void testGetChiSquared() {
		assertEquals(129.2929, test1.getChiSquared(), 0.001);
		assertEquals(5.06419, test2.getChiSquared(), 0.001);
	}

	@Test
	public void testGetPValue() {
		assertEquals(5.851314e-30, test1.getPValue(), 0.001);
		assertEquals(0.024425, test2.getPValue(), 0.001);
	}

	@Test
	public void testEquals() {
		ChiSquaredTest chiSquaredTest = test1;
		assertTrue(chiSquaredTest.equals(test1));
		assertFalse(test1.equals(test2));
		assertFalse(test2.equals(new Object()));
	}
}
