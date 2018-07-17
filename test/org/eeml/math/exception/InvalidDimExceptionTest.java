package org.eeml.math.exception;

import org.eeml.math.statistics.TwoVar;
import org.junit.Test;

import static org.eeml.math.AssertTemplate.assertThrows;

public class InvalidDimExceptionTest {
	@Test
	public void testThrow() {
		assertThrows(InvalidDimException.class, () -> {
			throw new InvalidDimException();
		});
		assertThrows(InvalidDimException.class, () -> {
			throw new InvalidDimException("invalid");
		});
		assertThrows(InvalidDimException.class, () -> {
			throw new InvalidDimException(TwoVar.class);
		});
	}
}
