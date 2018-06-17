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
		assertEquals(0, oneVarDouble.getMean(), 0.001);
	}
}
