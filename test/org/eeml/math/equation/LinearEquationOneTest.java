package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LinearEquationOneTest
{
	private static void assertThrows(Class<? extends Throwable> clazz, Runnable function)
	{
		try
		{
			function.run();
		} catch (Throwable e)
		{
			if (e.getClass() == clazz)
				System.out.println("Successfully thrown " + e.getClass().getSimpleName() + ", message: " + e.getMessage());
			else fail("Error: expected: " + clazz.getSimpleName() + ", get: " + e.getClass().getSimpleName());
			return;
		}
		fail("No exceptions thrown!");
	}

	LinearEquationOne line1 = new LinearEquationOne(2, 2, 9);
	LinearEquationOne line2 = new LinearEquationOne(-3, -2, -1);
	LinearEquationOne line3 = new LinearEquationOne(-2.2, 4.5, 6);
	LinearEquationOne line4 = new LinearEquationOne(1, 0);
	LinearEquationOne line5 = new LinearEquationOne(-1, 4, 9);
	LinearEquationOne line6 = new LinearEquationOne(-1, 0);
	LinearEquationOne line7 = new LinearEquationOne(2.432, 31.234);

	@Test
	public void testToString()
	{
		assertEquals("2x+2=9\tx=3.5", line1.toString());
		assertEquals("-3x-2=-1\tx=-0.333", line2.toString());
		assertEquals("-2.2x+4.5=6\tx=-0.682", line3.toString());
		assertEquals("x=0\tx=0", line4.toString());
		assertEquals("-x+4=9\tx=-5", line5.toString());
		assertEquals("-x=0\tx=0", line6.toString());
		assertEquals("2.432x+31.234=0\tx=-12.843", line7.toString());
	}

	@Test
	public void testException()
	{
		assertThrows(HighestCoefficientBeZeroException.class, () -> new LinearEquationOne(0, 4));
		assertThrows(HighestCoefficientBeZeroException.class, () -> new LinearEquationOne(0.0, 0.342));
	}
}
