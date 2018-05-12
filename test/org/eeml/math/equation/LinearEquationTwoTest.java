package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.eeml.math.exception.NotSolvableException;
import org.junit.Test;

import static org.eeml.math.ThrowTestTemplate.assertThrows;
import static org.junit.Assert.*;

public class LinearEquationTwoTest
{
	LinearEquationTwo line = new LinearEquationTwo();
	LinearEquationTwo line1 = new LinearEquationTwo(4, 1, 6, -1, 1, 1);
	LinearEquationTwo line2 = new LinearEquationTwo(-2, 3, -5.3, 1.2, 2, 2);
	LinearEquationTwo line3 = new LinearEquationTwo(1, 3.44, 3, -2, -3, 0);

	@Test
	public void testThrow()
	{
		assertThrows(HighestCoefficientBeZeroException.class, () ->
		{
			LinearEquationTwo line = new LinearEquationTwo(0, 2, 1, 3, 1, 2);
		});
		assertThrows(HighestCoefficientBeZeroException.class, () ->
		{
			LinearEquationTwo line = new LinearEquationTwo(9, 0, 1, 3, 1, 2);
		});
		assertThrows(HighestCoefficientBeZeroException.class, () ->
		{
			LinearEquationTwo line = new LinearEquationTwo(4, 2, 1, 0, 1, 2);
		});
		assertThrows(HighestCoefficientBeZeroException.class, () ->
		{
			LinearEquationTwo line = new LinearEquationTwo(2, 2, 1, 3, 0, 2);
		});
		assertThrows(NotSolvableException.class, () ->
		{
			LinearEquationTwo line = new LinearEquationTwo(2, 4, 6, 1, 2, 3);
		});
	}

	@Test
	public void testToString()
	{
		assertEquals("4x+y=6\n-x+y=1\nx=1\ty=2", line1.toString());
		assertEquals("-2x+3y=-5.3\n1.2x+1.2y=2\nx=2.184\ty=-0.311", line2.toString());
		assertEquals("x+3.44y=3\n-2x-2y=0\nx=-2.32\ty=1.546", line3.toString());
	}

	@Test
	public void testGetXSolution()
	{
		assertEquals(1, line1.getXSolution(), 0.001);
		assertEquals(2.184, line2.getXSolution(), 0.001);
		assertEquals(-2.32, line3.getXSolution(), 0.001);
	}

	@Test
	public void testGetYSolution()
	{
		assertEquals(2, line1.getYSolution(), 0.001);
		assertEquals(-0.311, line2.getYSolution(), 0.001);
		assertEquals(1.546, line3.getYSolution(), 0.001);
	}

	@Test
	public void testEquals()
	{
		assertFalse(line1.equals(line2));
		assertFalse(line3.equals(line));
		assertEquals(new LinearEquationTwo(1, 2, 3, 4, 5, 6), new LinearEquationTwo(1, 2, 3, 4, 5, 6));
		assertFalse(line.equals(new Object()));
		LinearEquationTwo line4 = line1;
		assertTrue(line1.equals(line4));
	}

	@Test
	public void testHashcode()
	{
		assertNotEquals(line1.hashCode(), line2.hashCode());
		assertEquals(line1.hashCode(), new LinearEquationTwo(4, 1, 6, -1, 1, 1).hashCode());
	}
}
