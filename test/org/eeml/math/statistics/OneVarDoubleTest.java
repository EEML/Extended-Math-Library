package org.eeml.math.statistics;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OneVarDoubleTest
{
	OneVarDouble oneVarDouble = new OneVarDouble();

	private void init()
	{
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
	}

	@Test
	public void testGetMean()
	{
		init();
		assertEquals(4.35, oneVarDouble.getMean(), 0.001);
	}

	@Test
	public void testGetSum()
	{
		init();
		assertEquals(52.2, oneVarDouble.getSum(), 0.001);
	}

	@Test
	public void testGetSumSquared()
	{
		init();
		assertEquals(320.62, oneVarDouble.getSumSquared(), 0.001);
	}

	@Test
	public void testGetSampleStandardDeviation()
	{
		init();
		assertEquals(2.9162, oneVarDouble.getSampleStandardDeviation(), 0.001);
	}

	@Test
	public void testGetStandardDeviation()
	{
		init();
		assertEquals(2.7921, oneVarDouble.getStandardDeviation(), 0.001);
	}

	@Test
	public void testGetTotality()
	{
		init();
		assertEquals(12, oneVarDouble.getTotality());
	}

	@Test
	public void testGetMin()
	{
		init();
		assertEquals(1, oneVarDouble.getMin(), 0.001);
	}

	@Test
	public void testGetMax()
	{
		init();
		assertEquals(9, oneVarDouble.getMax(), 0.001);
	}

	@Test
	public void testGetQ1()
	{
		init();
		assertEquals(2, oneVarDouble.getQ1(), 0.001);
	}

	@Test
	public void testGetQ3()
	{
		init();
		assertEquals(7.25, oneVarDouble.getQ3(), 0.001);
	}

	@Test
	public void testGetMedian()
	{
		init();
		assertEquals(3.6, oneVarDouble.getMedian(), 0.001);
	}

	@Test
	public void testGetMode()
	{
		init();
		assertEquals(1, oneVarDouble.getMode(), 0.001);
	}

	@Test
	public void testToString()
	{
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
				"Q3=7.25\n", oneVarDouble.toString());
	}

	@Test
	public void testEquals()
	{
		init();

	}
}
