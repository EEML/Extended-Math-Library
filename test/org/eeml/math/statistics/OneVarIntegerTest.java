package org.eeml.math.statistics;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OneVarIntegerTest {
	OneVarInteger oneVarInteger = new OneVarInteger();
	OneVarInteger oneVarInteger1 = new OneVarInteger();

	private void init() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(4);
		list.add(8);
		list.add(8);
		list.add(9);
		list.add(1);
		list.add(6);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(3);
		oneVarInteger = new OneVarInteger(list);
		list = new ArrayList<>();
		list.add(77);
		list.add(64);
		list.add(55);
		list.add(81);
		list.add(70);
		list.add(95);
		list.add(98);
		list.add(99);
		list.add(86);
		oneVarInteger1 = new OneVarInteger(list);
	}

	@Test
	public void testGetMean() {
		init();
		assertEquals(4.25, oneVarInteger.getMean(), 0.001);
	}

	@Test
	public void testGetSum() {
		init();
		assertEquals(51, oneVarInteger.getSum());
	}

	@Test
	public void testGetSumSquared() {
		init();
		assertEquals(307, oneVarInteger.getSumSquared());
	}

	@Test
	public void testGetSampleStandardDeviation() {
		init();
		assertEquals(2.86435, oneVarInteger.getSampleStandardDeviation(), 0.001);
	}

	@Test
	public void testGetStandardDeviation() {
		init();
		assertEquals(2.74241, oneVarInteger.getStandardDeviation(), 0.001);
	}

	@Test
	public void testGetTotality() {
		init();
		assertEquals(12, oneVarInteger.getTotality());
	}

	@Test
	public void testGetMin() {
		init();
		assertEquals(1, oneVarInteger.getMin());
	}

	@Test
	public void testGetMax() {
		init();
		assertEquals(9, oneVarInteger.getMax());
	}

	@Test
	public void testGetQ1() {
		init();
		assertEquals(2, oneVarInteger.getQ1(), 0.001);
	}

	@Test
	public void testGetQ3() {
		init();
		assertEquals(7, oneVarInteger.getQ3(), 0.001);
	}

	@Test
	public void testGetMedian() {
		init();
		assertEquals(3.5, oneVarInteger.getMedian(), 0.001);
	}

	@Test
	public void testGetMode() {
		init();
		assertEquals(8, oneVarInteger.getMode(), 0.001);
	}

	@Test
	public void testToString() {
		init();
		assertEquals("", oneVarInteger.toString());
	}

	@Test
	public void testEquals() {
		init();
		OneVarInteger n = oneVarInteger;
		assertTrue(n.equals(oneVarInteger));
		assertFalse(oneVarInteger.equals(oneVarInteger1));
		assertFalse(oneVarInteger.equals(new Object()));
	}

	@Test
	public void testHashcode() {
		init();
		assertNotEquals(oneVarInteger1.hashCode(), oneVarInteger.hashCode());
	}
}
