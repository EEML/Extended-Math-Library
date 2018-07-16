package org.eeml.math.exception;

import org.eeml.math.equation.LinearEquationTwo;
import org.junit.Test;

import static org.eeml.math.AssertTemplate.assertThrows;

public class NotSolvableExceptionTest {
	@Test
	public void testThrow() {
		assertThrows(NotSolvableException.class, () ->
		{
			throw new NotSolvableException();
		});
		assertThrows(NotSolvableException.class, () ->
		{
			throw new NotSolvableException("Illegal");
		});
		assertThrows(NotSolvableException.class, () ->
		{
			throw new NotSolvableException(LinearEquationTwo.class);
		});
	}
}

