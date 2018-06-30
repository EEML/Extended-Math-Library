package org.eeml.math.exception;

import org.eeml.math.equation.LinearEquationOne;
import org.junit.Test;

import static org.eeml.math.ThrowTestTemplate.assertThrows;

public class HighestCoefficientBeZeroExceptionTest {
	@Test
	public void testThrow() {
		assertThrows(HighestCoefficientBeZeroException.class, () ->
		{
			throw new HighestCoefficientBeZeroException();
		});
		assertThrows(HighestCoefficientBeZeroException.class, () ->
		{
			throw new HighestCoefficientBeZeroException("Illegal");
		});
		assertThrows(HighestCoefficientBeZeroException.class, () ->
		{
			throw new HighestCoefficientBeZeroException(LinearEquationOne.class);
		});
	}
}
