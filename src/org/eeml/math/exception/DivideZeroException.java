package org.eeml.math.exception;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * DivideZeroException refers to the mathematical computing error of mistakenly divide zero.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class DivideZeroException extends ArithmeticException {
	public DivideZeroException(@NotNull @Nls String message) {
		super(message);
	}

	public DivideZeroException() {
		this("A number cannot divide zero");
	}

	@NotNull
	@Contract("_ -> !null")
	public static DivideZeroException fromNumber(int num) {
		return new DivideZeroException(num + " cannot divide zero!");
	}
}