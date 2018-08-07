package org.eeml.math.statistics;

import org.eeml.math.exception.TypeMismatchException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.eeml.math.AssertTemplate.assertThrows;
import static org.junit.Assert.*;

public class OneVarTest {
	OneVar oneVarDouble = new OneVar();
	OneVar oneVarDouble1 = new OneVar();
	OneVar oneVarInteger = new OneVar();
	OneVar oneVarInteger1 = new OneVar();

	private void init() {
		ArrayList<Double> list = new ArrayList<>(Arrays.asList(3.2D, 4D, 8D, 8.3D, 9D, 1D, 6.5D, 1D, 3D, 4D, 1D, 3.2D));
		oneVarDouble = new OneVar(list);
		list = new ArrayList<>(Arrays.asList(38.37D, 26.3D, 16.9D, 38.28D, 1.16D, 4.35D, 40.2D, 15.23D, 36.6D));
		oneVarDouble1 = new OneVar(list);
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(3, 4, 8, 8, 9, 1, 6, 1, 3, 4, 1, 3));
		oneVarInteger = new OneVar(list1);
		list1 = new ArrayList<>(Arrays.asList(77, 64, 55, 81, 70, 95, 98, 99, 86));
		oneVarInteger1 = new OneVar(list1);
	}

	@Test
	public void testGetMean() {
		init();
		assertEquals(4.35, oneVarDouble.getMean(), 0.001);
		assertEquals(24.154, oneVarDouble1.getMean(), 0.001);
		assertEquals(4.25, oneVarInteger.getMean(), 0.001);
		assertEquals(80.555, oneVarInteger1.getMean(), 0.001);
	}

	@Test
	public void testGetSum() {
		init();
		assertEquals(52.2, oneVarDouble.getSum(), 0.001);
		assertEquals(217.39, oneVarDouble1.getSum(), 0.001);
		assertEquals(51, oneVarInteger.getSum(), 0.001);
		assertEquals(725, oneVarInteger1.getSum(), 0.001);
	}

	@Test
	public void testGetSumSquared() {
		init();
		assertEquals(320.62, oneVarDouble.getSumSquared(), 0.001);
		assertEquals(7122.7363, oneVarDouble1.getSumSquared(), 0.001);
		assertEquals(307, oneVarInteger.getSumSquared(), 0.001);
		assertEquals(60337, oneVarInteger1.getSumSquared(), 0.001);
	}

	@Test
	public void testGetSampleStandardDeviation() {
		init();
		assertEquals(2.9162, oneVarDouble.getSampleStandardDeviation(), 0.001);
		assertEquals(15.2962, oneVarDouble1.getSampleStandardDeviation(), 0.001);
		assertEquals(2.86435, oneVarInteger.getSampleStandardDeviation(), 0.001);
		assertEquals(15.549205, oneVarInteger1.getSampleStandardDeviation(), 0.001);
	}

	@Test
	public void testGetStandardDeviation() {
		init();
		assertEquals(2.7921, oneVarDouble.getStandardDeviation(), 0.001);
		assertEquals(14.42144, oneVarDouble1.getStandardDeviation(), 0.001);
		assertEquals(2.74241, oneVarInteger.getStandardDeviation(), 0.001);
		assertEquals(14.6599311, oneVarInteger1.getStandardDeviation(), 0.001);
	}

	@Test
	public void testGetTotality() {
		init();
		assertEquals(12, oneVarDouble.getTotality());
		assertEquals(9, oneVarDouble1.getTotality());
		assertEquals(12, oneVarInteger.getTotality());
		assertEquals(9, oneVarInteger1.getTotality());
	}

	@Test
	public void testGetMin() {
		init();
		assertEquals(1, oneVarDouble.getMin(), 0.001);
		assertEquals(1.16, oneVarDouble1.getMin(), 0.001);
		assertEquals(1, oneVarInteger.getMin(), 0.001);
		assertEquals(55, oneVarInteger1.getMin(), 0.001);
	}

	@Test
	public void testGetMax() {
		init();
		assertEquals(9, oneVarDouble.getMax(), 0.001);
		assertEquals(40.2, oneVarDouble1.getMax(), 0.001);
		assertEquals(9, oneVarInteger.getMax(), 0.001);
		assertEquals(99, oneVarInteger1.getMax(), 0.001);
	}

	@Test
	public void testGetQ1() {
		init();
		assertEquals(2, oneVarDouble.getQ1(), 0.001);
		assertEquals(9.79, oneVarDouble1.getQ1(), 0.001);
		assertEquals(2, oneVarInteger.getQ1(), 0.001);
		assertEquals(67, oneVarInteger1.getQ1(), 0.001);
	}

	@Test
	public void testGetQ3() {
		init();
		assertEquals(7.25, oneVarDouble.getQ3(), 0.001);
		assertEquals(38.325, oneVarDouble1.getQ3(), 0.001);
		assertEquals(7, oneVarInteger.getQ3(), 0.001);
		assertEquals(96.5, oneVarInteger1.getQ3(), 0.001);
	}

	@Test
	public void testGetMedian() {
		init();
		assertEquals(3.6, oneVarDouble.getMedian(), 0.001);
		assertEquals(26.3, oneVarDouble1.getMedian(), 0.001);
		assertEquals(3.5, oneVarInteger.getMedian(), 0.001);
		assertEquals(81, oneVarInteger1.getMedian(), 0.001);
	}

	@Test
	public void testHasMode() {
		init();
		assertTrue(oneVarDouble.hasMode());
		assertFalse(oneVarDouble1.hasMode());
		assertTrue(oneVarInteger.hasMode());
		assertFalse(oneVarInteger1.hasMode());
	}

	@Test
	public void testGetMode() {
		init();
		if (oneVarDouble.hasMode())
			assertEquals(1, oneVarDouble.getMode(), 0.001);
		if (oneVarDouble1.hasMode())
			assertEquals(36.6, oneVarDouble1.getMode(), 0.001);
		if (oneVarInteger.hasMode())
			assertEquals(1, oneVarInteger.getMode(), 0.001);
		if (oneVarInteger1.hasMode())
			assertEquals(86, oneVarInteger1.getMode(), 0.001);
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
		assertEquals("mean=4.25\n" +
				"sum=51\n" +
				"sum^2=307\n" +
				"sample SD=2.864\n" +
				"SD=2.742\n" +
				"n=12\n" +
				"min=1\n" +
				"max=9\n" +
				"mode=1\n" +
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
		OneVar n = oneVarDouble;
		assertTrue(n.equals(oneVarDouble));
		assertFalse(oneVarDouble.equals(oneVarDouble1));
		assertFalse(oneVarDouble.equals(new Object()));
		n = oneVarInteger;
		assertTrue(n.equals(oneVarInteger));
		assertFalse(oneVarInteger.equals(oneVarInteger1));
		assertFalse(oneVarInteger.equals(new Object()));
	}

	@Test
	public void testHashcode() {
		init();
		assertNotEquals(oneVarDouble1.hashCode(), oneVarDouble.hashCode());
		assertNotEquals(oneVarInteger1.hashCode(), oneVarInteger.hashCode());
	}

	@Test
	public void testThrows() {
		assertThrows(IllegalArgumentException.class, () -> oneVarDouble1.getMode());
		assertThrows(IllegalArgumentException.class, () -> oneVarInteger1.getMode());
		assertThrows(TypeMismatchException.class, () -> new OneVar(new ArrayList<>(Arrays.asList("sdknf", "asfd"))));
		assertThrows(IllegalArgumentException.class, () -> new OneVar(new ArrayList<String>()));
	}
}
