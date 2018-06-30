package org.eeml.math.exception;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * HighestCoefficientBeZeroException refers to having zero as the highest coefficient of a equation
 * which would not be solvable.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */
public class HighestCoefficientBeZeroException extends IllegalArgumentException {
	public HighestCoefficientBeZeroException(@NotNull @Nls String message) {
		super(message);
	}

	public HighestCoefficientBeZeroException() {
		this("Highest degree coefficient of an expression cannot be zero");
	}

	public HighestCoefficientBeZeroException(Class clazz) {
		this("Instance of " + clazz.getSimpleName() + " cannot have zero as the highest coefficient.");
	}
}
