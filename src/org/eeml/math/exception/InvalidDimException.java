package org.eeml.math.exception;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

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
