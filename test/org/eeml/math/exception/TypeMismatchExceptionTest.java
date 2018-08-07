package org.eeml.math.exception;

import org.junit.Test;

import static org.eeml.math.AssertTemplate.assertThrows;

public class TypeMismatchExceptionTest {
	@Test
	public void testThrow() {
		assertThrows(TypeMismatchException.class, () -> {
			throw new TypeMismatchException();
		});
		assertThrows(TypeMismatchException.class, () -> {
			throw new TypeMismatchException("mismatch");
		});
		assertThrows(TypeMismatchException.class, () -> {
			throw new TypeMismatchException(Double.class);
		});
	}
}
