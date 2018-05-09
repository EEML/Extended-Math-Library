package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.eeml.math.exception.NotSolvableException;
import org.junit.Test;

import static org.eeml.math.ThrowTestTemplate.assertThrows;
import static org.junit.Assert.assertEquals;

public class LinearEquationTwoTest
{
	LinearEquationTwo line = new LinearEquationTwo();
	LinearEquationTwo line1 = new LinearEquationTwo(4, 1, 6, -1, 1, 1);
	LinearEquationTwo line2 = new LinearEquationTwo(-2, 3, -5.3, 1.2, 2, 2);

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
	}
}
