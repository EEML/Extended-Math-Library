package org.eeml.math.expr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoDVectorTest {
	TwoDVector twoDVector1 = new TwoDVector(2, 4);
	TwoDVector twoDVector2 = new TwoDVector(-2, 32.2);

	@Test
	public void testToString() {
		assertEquals("(2,4)", twoDVector1.toString());
		assertEquals("(-2,32.2)", twoDVector2.toString());

	}
}