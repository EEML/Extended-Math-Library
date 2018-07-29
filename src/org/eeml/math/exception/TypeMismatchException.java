package org.eeml.math.exception;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("WeakerAccess")
public class TypeMismatchException extends IllegalArgumentException {
	public TypeMismatchException(@NotNull @Nls String message) {
		super(message);
	}

	public TypeMismatchException() {
		this("Type mismatch");
	}

	public TypeMismatchException(Class expected) {
		this(expected.getSimpleName() + " is needed here");
	}
}
