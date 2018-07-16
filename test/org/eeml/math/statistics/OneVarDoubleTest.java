package org.eeml.math.statistics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.eeml.math.AssertTemplate.assertThrows;
import static org.junit.Assert.*;

public class OneVarDoubleTest {
	OneVarDouble oneVarDouble = new OneVarDouble();
	OneVarDouble oneVarDouble1 = new OneVarDouble();

	private void init() {
		ArrayList<Double> list = new ArrayList<>(Arrays.asList(3.2D, 4D, 8D, 8.3D, 9D, 1D, 6.5D, 1D, 3D, 4D, 1D, 3.2D));
		oneVarDouble = new OneVarDouble(list);
		list = new ArrayList<>(Arrays.asList(38.37D, 26.3D, 16.9D, 38.28D, 1.16D, 4.35D, 40.2D, 15.23D, 36.6D));
		oneVarDouble1 = new OneVarDouble(list);
	}

	@Test
	public void testGetMean() {
		init();
		assertEquals(4.35, oneVarDouble.getMean(), 0.001);
		assertEquals(24.154, oneVarDouble1.getMean(), 0.001);
	}

	@Test
	public void testGetSum() {
		init();
		assertEquals(52.2, oneVarDouble.getSum(), 0.001);
		assertEquals(217.39, oneVarDouble1.getSum(), 0.001);
	}

	@Test
	public void testGetSumSquared() {
		init();
		assertEquals(320.62, oneVarDouble.getSumSquared(), 0.001);
		assertEquals(7122.7363, oneVarDouble1.getSumSquared(), 0.001);
	}

	@Test
	public void testGetSampleStandardDeviation() {
		init();
		assertEquals(2.9162, oneVarDouble.getSampleStandardDeviation(), 0.001);
		assertEquals(15.2962, oneVarDouble1.getSampleStandardDeviation(), 0.001);
	}

	@Test
	public void testGetStandardDeviation() {
		init();
		assertEquals(2.7921, oneVarDouble.getStandardDeviation(), 0.001);
		assertEquals(14.42144, oneVarDouble1.getStandardDeviation(), 0.001);
	}

	@Test
	public void testGetTotality() {
		init();
		assertEquals(12, oneVarDouble.getTotality());
		assertEquals(9, oneVarDouble1.getTotality());
	}

	@Test
	public void testGetMin() {
		init();
		assertEquals(1, oneVarDouble.getMin(), 0.001);
		assertEquals(1.16, oneVarDouble1.getMin(), 0.001);
	}

	@Test
	public void testGetMax() {
		init();
		assertEquals(9, oneVarDouble.getMax(), 0.001);
		assertEquals(40.2, oneVarDouble1.getMax(), 0.001);
	}

	@Test
	public void testGetQ1() {
		init();
		assertEquals(2, oneVarDouble.getQ1(), 0.001);
		assertEquals(9.79, oneVarDouble1.getQ1(), 0.001);
	}

	@Test
	public void testGetQ3() {
		init();
		assertEquals(7.25, oneVarDouble.getQ3(), 0.001);
		assertEquals(38.325, oneVarDouble1.getQ3(), 0.001);
	}

	@Test
	public void testGetMedian() {
		init();
		assertEquals(3.6, oneVarDouble.getMedian(), 0.001);
		assertEquals(26.3, oneVarDouble1.getMedian(), 0.001);
	}

	@Test
	public void testHasMode() {
		init();
		assertTrue(oneVarDouble.hasMode());
		assertFalse(oneVarDouble1.hasMode());
	}

	@Test
	public void testGetMode() {
		init();
		if (oneVarDouble.hasMode())
			assertEquals(1, oneVarDouble.getMode(), 0.001);
		if (oneVarDouble1.hasMode())
			assertEquals(36.6, oneVarDouble1.getMode(), 0.001);
	}

	@Test
	public void testToString() {
		init();
		assertEquals("mean=4.35\n" +
				"sum=52.2\n" +
				"sum^2=320.62\n" +
				"sample SD=2.916\n" +
				"SD=2.792\n" +
				"n=12\n" +
				"min=1\n" +
				"max=9\n" +
				"mode=1\n" +
				"median=3.6\n" +
				"Q1=2\n" +
				"Q3=7.25", oneVarDouble.toString());
		assertEquals("mean=24.154\n" +
				"sum=217.39\n" +
				"sum^2=7,122.736\n" +
				"sample SD=15.296\n" +
				"SD=14.421\n" +
				"n=9\n" +
				"min=1.16\n" +
				"max=40.2\n" +
				"median=26.3\n" +
				"Q1=9.79\n" +
				"Q3=38.325", oneVarDouble1.toString());
	}

	@Test
	public void testEquals() {
		init();
		OneVarDouble n = oneVarDouble;
		assertTrue(n.equals(oneVarDouble));
		assertFalse(oneVarDouble.equals(oneVarDouble1));
		assertFalse(oneVarDouble.equals(new Object()));
	}

	@Test
	public void testHashcode() {
		init();
		assertNotEquals(oneVarDouble1.hashCode(), oneVarDouble.hashCode());
	}

	@Test
	public void testThrows() {
		assertThrows(IllegalArgumentException.class, () -> oneVarDouble1.getMode());
	}
}
