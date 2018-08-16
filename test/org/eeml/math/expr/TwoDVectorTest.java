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

	@Test
	public void testAdd() {
		assertEquals("(3,5)",twoDVector1.add(1).toString());
		assertEquals("(2.5,4.5)",twoDVector1.add(0.5).toString());
		assertEquals("(0,36.2)",twoDVector1.add(twoDVector2).toString());
	}

	@Test
	public void testSubtract() {
		assertEquals("(1,3)",twoDVector1.subtract(1).toString());
		assertEquals("(1.5,3.5)",twoDVector1.subtract(0.5).toString());
		assertEquals("(4,-28.2)",twoDVector1.subtract(twoDVector2).toString());
	}
}