package org.eeml.math.exception;

import org.junit.Test;

import static org.eeml.math.ThrowTestTemplate.assertThrows;

public class DivideZeroExceptionTest
{
	@Test
	public void testThrow()
	{
		assertThrows(DivideZeroException.class, () ->
		{
			throw new DivideZeroException();
		});
		assertThrows(DivideZeroException.class, () ->
		{
			throw new DivideZeroException("Illegal division expression");
		});
		assertThrows(DivideZeroException.class, () ->
		{
			throw DivideZeroException.fromNumber(1);
		});
	}
}
