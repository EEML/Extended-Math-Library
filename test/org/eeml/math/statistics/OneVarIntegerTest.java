package org.eeml.math.statistics;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OneVarIntegerTest
{
	OneVarInteger oneVarInteger = new OneVarInteger();

	private void init()
	{
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
	}

	@Test
	public void testGetMean()
	{
		init();
		assertEquals(0, oneVarInteger.getMean(), 0.001);
	}
}
