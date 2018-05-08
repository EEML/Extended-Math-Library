package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.eeml.math.exception.NotSolvableException;
import org.junit.Test;

import static org.eeml.math.ThrowTestTemplate.assertThrows;

public class LinearEquationTwoTest
{
	LinearEquationTwo line1 = new LinearEquationTwo(4, 1, 6, -1, 1, 1);

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
		System.out.println(line1);
	}
}
