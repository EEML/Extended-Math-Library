package org.eeml.math.exception;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * NotSolvableException refers to being unable to find a proper solution to a equation.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */
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
