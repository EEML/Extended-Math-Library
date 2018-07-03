package org.eeml.math.statistics;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OneVarDoubleTest {
	OneVarDouble oneVarDouble = new OneVarDouble();
	OneVarDouble oneVarDouble1 = new OneVarDouble();

	private void init() {
		ArrayList<Double> list = new ArrayList<>();
		list.add(3.2D);
		list.add(4D);
		list.add(8D);
		list.add(8.3D);
		list.add(9D);
		list.add(1D);
		list.add(6.5D);
		list.add(1D);
		list.add(3D);
		list.add(4D);
		list.add(1D);
		list.add(3.2D);
		oneVarDouble = new OneVarDouble(list);
		list = new ArrayList<>();
		list.add(38.37D);
		list.add(26.3D);
		list.add(16.9D);
		list.add(38.28D);
		list.add(1.16D);
		list.add(4.35D);
		list.add(40.2D);
		list.add(15.23D);
		list.add(36.6D);
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
	public void testGetMode() {
		init();
		assertEquals(1, oneVarDouble.getMode(), 0.001);
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
				"mode=36.6\n" +
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
}
