package org.eeml.math.equation;

import org.junit.Test;

public class LinearEquationTwoTest
{
	LinearEquationTwo line1 = new LinearEquationTwo(1, 2, 3, 4, 5, 6);

	@Test
	public void testToString()
	{
		System.out.println(line1);
	}
}
