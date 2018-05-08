package org.eeml.math.exception;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

public class NotSolvableException extends IllegalStateException
{
	public NotSolvableException(@NotNull @Nls String message)
	{
		super(message);
	}

	public NotSolvableException()
	{
		this("there's no proper solution for the given equation");
	}

	public NotSolvableException(Class clazz)
	{
		this("With the given data, there's no proper solution for " + clazz.getSimpleName());
	}
}
