package org.eeml.math.statistics.test;

import org.junit.Test;

import static org.eeml.math.AssertTemplate.assert2DArrayEquals;
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

	/*
		@Test
		public void testGetPValue() {
			assertEquals(5.851314e-30, test1.getPValue(), 0.001);
			assertEquals(0.024425, test2.getPValue(), 0.001);
		}

	*/
	@Test
	public void testEquals() {
		ChiSquaredTest chiSquaredTest = test1;
		assertTrue(chiSquaredTest.equals(test1));
		assertFalse(test1.equals(test2));
		assertFalse(test2.equals(new Object()));
	}

	@Test
	public void testHashcode() {
		ChiSquaredTest chiSquaredTest = test1;
		assertEquals(test1.hashCode(), chiSquaredTest.hashCode());
		assertNotEquals(test1.hashCode(), test2.hashCode());
	}

	@Test
	public void testGetObserved() {
		assert2DArrayEquals(new double[][]{
				{15, 95},
				{85, 5}
		}, test1.getObserved());
		assert2DArrayEquals(new double[][]{
				{55, 45},
				{43, 66}
		}, test2.getObserved());
	}

	@Test
	public void testGetExpected() {
		assert2DArrayEquals(new double[][]{
				{55, 55},
				{45, 45}
		}, test1.getExpected());
		assert2DArrayEquals(new double[][]{
				{46.89, 53.11},
				{51.11, 57.89}
		}, test2.getExpected());
	}

	@Test
	public void testToString(){
		assertEquals("df=1\n" +
				"χ2=129.293",test1.toString());
		assertEquals("df=1\n" +
				"χ2=5.064",test2.toString());
	}
}
