package org.eeml.math.statistics;

import org.junit.Test;

import java.util.ArrayList;

import static org.eeml.math.ThrowTestTemplate.assertThrows;
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
		assertEquals(80.555, oneVarInteger1.getMean(), 0.001);
	}

	@Test
	public void testGetSum() {
		init();
		assertEquals(51, oneVarInteger.getSum());
		assertEquals(725, oneVarInteger1.getSum());
	}

	@Test
	public void testGetSumSquared() {
		init();
		assertEquals(307, oneVarInteger.getSumSquared());
		assertEquals(60337, oneVarInteger1.getSumSquared());
	}

	@Test
	public void testGetSampleStandardDeviation() {
		init();
		assertEquals(2.86435, oneVarInteger.getSampleStandardDeviation(), 0.001);
		assertEquals(15.549205, oneVarInteger1.getSampleStandardDeviation(), 0.001);
	}

	@Test
	public void testGetStandardDeviation() {
		init();
		assertEquals(2.74241, oneVarInteger.getStandardDeviation(), 0.001);
		assertEquals(14.6599311, oneVarInteger1.getStandardDeviation(), 0.001);
	}

	@Test
	public void testGetTotality() {
		init();
		assertEquals(12, oneVarInteger.getTotality());
		assertEquals(9, oneVarInteger1.getTotality());
	}

	@Test
	public void testGetMin() {
		init();
		assertEquals(1, oneVarInteger.getMin());
		assertEquals(55, oneVarInteger1.getMin());
	}

	@Test
	public void testGetMax() {
		init();
		assertEquals(9, oneVarInteger.getMax());
		assertEquals(99, oneVarInteger1.getMax());
	}

	@Test
	public void testGetQ1() {
		init();
		assertEquals(2, oneVarInteger.getQ1(), 0.001);
		assertEquals(67, oneVarInteger1.getQ1(), 0.001);
	}

	@Test
	public void testGetQ3() {
		init();
		assertEquals(7, oneVarInteger.getQ3(), 0.001);
		assertEquals(96.5, oneVarInteger1.getQ3(), 0.001);
	}

	@Test
	public void testGetMedian() {
		init();
		assertEquals(3.5, oneVarInteger.getMedian(), 0.001);
		assertEquals(81, oneVarInteger1.getMedian(), 0.001);
	}

	@Test
	public void testHasMode() {
		init();
		assertTrue(oneVarInteger.hasMode());
		assertFalse(oneVarInteger1.hasMode());
	}

	@Test
	public void testGetMode() {
		init();
		if (oneVarInteger.hasMode())
			assertEquals(3, oneVarInteger.getMode());
		if (oneVarInteger1.hasMode())
			assertEquals(86, oneVarInteger1.getMode());
	}

	@Test
	public void testToString() {
		init();
		assertEquals("mean=4.25\n" +
				"sum=51\n" +
				"sum^2=307\n" +
				"sample SD=2.864\n" +
				"SD=2.742\n" +
				"n=12\n" +
				"min=1\n" +
				"max=9\n" +
				"mode=3\n" +
				"median=3.5\n" +
				"Q1=2\n" +
				"Q3=7", oneVarInteger.toString());
		assertEquals("mean=80.556\n" +
				"sum=725\n" +
				"sum^2=60,337\n" +
				"sample SD=15.549\n" +
				"SD=14.66\n" +
				"n=9\n" +
				"min=55\n" +
				"max=99\n" +
				"median=81\n" +
				"Q1=67\n" +
				"Q3=96.5", oneVarInteger1.toString());
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

	@Test
	public void testThrows() {
		assertThrows(IllegalArgumentException.class, () -> oneVarInteger1.getMode());
	}
}
