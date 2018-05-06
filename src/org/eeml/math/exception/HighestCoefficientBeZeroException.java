package org.eeml.math.exception;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

public class HighestCoefficientBeZeroException extends IllegalArgumentException
{
	public HighestCoefficientBeZeroException(@NotNull @Nls String message)
	{
		super(message);
	}

	public HighestCoefficientBeZeroException()
	{
		this("Highest degree coefficient of an expression cannot be zero");
	}

	public HighestCoefficientBeZeroException(Class clazz)
	{
		this("Instance of " + clazz.getSimpleName() + " cannot have zero as the highest coefficient.");
	}
}