package org.eeml.math.equation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinearEquationOneTest
{
	LinearEquationOne line1 = new LinearEquationOne(2, 2, 9);
	LinearEquationOne line2 = new LinearEquationOne(-3, -2, -1);
	LinearEquationOne line3 = new LinearEquationOne(-2.2, 4.5, 6);
	LinearEquationOne line4 = new LinearEquationOne(1, 0);
	LinearEquationOne line5 = new LinearEquationOne(-1, 4, 9);
	LinearEquationOne line6 = new LinearEquationOne(-1, 0);

	@Test
	public void testToString()
	{
		assertEquals("2x+2=9\tx=3.5", line1.toString());
		assertEquals("-3x-2=-1\tx=-0.333", line2.toString());
		assertEquals("-2.2x+4.5=6\tx=-0.682", line3.toString());
		assertEquals("x=0\tx=0", line4.toString());
		assertEquals("-x+4=9\tx=-5", line5.toString());
		assertEquals("-x=0\tx=0", line6.toString());
	}
}
