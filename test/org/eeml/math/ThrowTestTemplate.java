package org.eeml.math;

import static org.junit.Assert.fail;

public class ThrowTestTemplate
{
	public static void assertThrows(Class<? extends Throwable> clazz, Runnable function)
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
}
