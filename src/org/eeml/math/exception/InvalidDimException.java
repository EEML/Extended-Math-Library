package org.eeml.math.exception;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * InvalidDimException refers to having mismatch when pairing two sets of data.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class InvalidDimException extends IllegalArgumentException {
	public InvalidDimException(@NotNull @Nls String message) {
		super(message);
	}

	public InvalidDimException() {
		this("Invalid Dim");
	}

	public InvalidDimException(Class clazz) {
		this("Access to " + clazz.getSimpleName() + " has invalid dim.");
	}
}
