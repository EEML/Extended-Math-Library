package org.eeml.math.exception;

import org.junit.Test;

import static org.junit.Assert.fail;

public class DivideZeroExceptionTest
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
