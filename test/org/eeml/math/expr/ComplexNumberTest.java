package org.eeml.math.expr;

import org.eeml.math.exception.DivideZeroException;
import org.junit.Test;

import static org.eeml.math.ThrowTestTemplate.assertThrows;
import static org.junit.Assert.*;

public class ComplexNumberTest {
	private ComplexNumber complexNumber1 = new ComplexNumber(2.4, 9.5);
	private ComplexNumber complexNumber2 = new ComplexNumber(5, -0.4);
	private ComplexNumber complexNumber3 = new ComplexNumber(-4, 8.876);
	private ComplexNumber complexNumber4 = new ComplexNumber(-4, -2);
	private ComplexNumber complexNumber5 = new ComplexNumber(0, 1);
	private ComplexNumber complexNumber6 = new ComplexNumber(0, -0.01);
	private ComplexNumber complexNumber7 = new ComplexNumber(-323, 0);
	private ComplexNumber complexNumber8 = new ComplexNumber(1, 0);
	private ComplexNumber complexNumber9 = new ComplexNumber(0, 0);
	private ComplexNumber complexNumber10 = new ComplexNumber(3, -1);

	@Test
	public void testToString() {
		assertEquals("2.4+9.5i", complexNumber1.toString());
		assertEquals("5-0.4i", complexNumber2.toString());
		assertEquals("-4+8.876i", complexNumber3.toString());
		assertEquals("-4-2i", complexNumber4.toString());
		assertEquals("i", complexNumber5.toString());
		assertEquals("-0.01i", complexNumber6.toString());
		assertEquals("-323", complexNumber7.toString());
		assertEquals("1", complexNumber8.toString());
		assertEquals("0", complexNumber9.toString());
		assertEquals("3-i", complexNumber10.toString());
	}

	@Test
	public void testAdd() {
		assertEquals("7.4+9.1i", complexNumber1.add(complexNumber2).toString());
		assertEquals("-8+6.876i", complexNumber3.add(complexNumber4).toString());
		assertEquals("0.99i", complexNumber5.add(complexNumber6).toString());
		assertEquals("-316", complexNumber7.add(7).toString());
		assertEquals("-8.3", complexNumber8.add(-9.3).toString());
		assertEquals("-2", complexNumber9.add(-2).toString());
		assertEquals("7.345-i", complexNumber10.add(4.345).toString());
	}

	@Test
	public void testSubtract() {
		assertEquals("3-i", complexNumber10.subtract(complexNumber9).toString());
		assertEquals("324", complexNumber8.subtract(complexNumber7).toString());
		assertEquals("-1.01i", complexNumber6.subtract(complexNumber5).toString());
		assertEquals("-12-2i", complexNumber4.subtract(8).toString());
		assertEquals("-1+8.876i", complexNumber3.subtract(-3).toString());
		assertEquals("0.655-0.4i", complexNumber2.subtract(4.345).toString());
		assertEquals("8+9.5i", complexNumber1.subtract(-5.6).toString());
	}

	@Test
	public void testMultiply() {
		assertEquals("16.7+26.1i", complexNumber1.multiply(complexNumber10).toString());
		assertEquals("0", complexNumber2.multiply(complexNumber9).toString());
		assertEquals("-4+8.876i", complexNumber3.multiply(complexNumber8).toString());
		assertEquals("-17.2-8.6i", complexNumber4.multiply(4.3).toString());
		assertEquals("-3.4i", complexNumber5.multiply(-3.4).toString());
		assertEquals("0", complexNumber6.multiply(0).toString());
		assertEquals("323", complexNumber7.multiply(-1).toString());
	}

	@Test
	public void testDivide() {
		assertEquals("0.788-0.626i", complexNumber1.divide(complexNumber3).toString());
		assertEquals("-0.96+0.58i", complexNumber2.divide(complexNumber4).toString());
		assertEquals("-887.6-400i", complexNumber3.divide(complexNumber6).toString());
		assertEquals("-44.247", complexNumber7.divide(7.3).toString());
		assertEquals("-0.303", complexNumber8.divide(-3.3).toString());
		assertEquals("0", complexNumber9.divide(3).toString());
		assertEquals("-0.333+0.111i", complexNumber10.divide(-9).toString());
	}

	@Test
	public void testTransferable() {
		assertFalse(complexNumber1.transferable());
		assertFalse(complexNumber2.transferable());
		assertFalse(complexNumber3.transferable());
		assertFalse(complexNumber4.transferable());
		assertFalse(complexNumber5.transferable());
		assertFalse(complexNumber6.transferable());
		assertTrue(complexNumber7.transferable());
		assertTrue(complexNumber8.transferable());
		assertTrue(complexNumber9.transferable());
		assertFalse(complexNumber10.transferable());
	}

	@Test
	public void testToDouble() {
		if (complexNumber7.transferable())
			assertEquals(-323, complexNumber7.toDouble(), 0.001);
		if (complexNumber8.transferable())
			assertEquals(1, complexNumber8.toDouble(), 0.001);
		if (complexNumber9.transferable())
			assertEquals(0, complexNumber9.toDouble(), 0.001);
	}

	@Test
	public void testEquals() {
		assertFalse(complexNumber1.equals(complexNumber2));
		assertFalse(complexNumber3.equals(new Object()));
		assertFalse(complexNumber4.equals(complexNumber5));
		ComplexNumber complexNumber = complexNumber6;
		assertTrue(complexNumber6.equals(complexNumber));
		assertFalse(complexNumber7.equals(complexNumber8));
		ComplexNumber complexNumber11 = new ComplexNumber(3, -1);
		assertTrue(complexNumber10.equals(complexNumber11));
	}

	@Test
	public void testThrows() {
		assertThrows(DivideZeroException.class, () -> complexNumber1.divide(complexNumber9));
		assertThrows(DivideZeroException.class, () -> complexNumber2.divide(0));
		assertThrows(IllegalArgumentException.class, () -> complexNumber1.toDouble());
		assertThrows(IllegalArgumentException.class, () -> complexNumber2.toDouble());
	}

	@Test
	public void testHashcode() {
		assertNotEquals(complexNumber1.hashCode(), complexNumber2.hashCode());
		assertNotEquals(complexNumber3.hashCode(), complexNumber4.hashCode());
		assertNotEquals(complexNumber5.hashCode(), complexNumber6.hashCode());
		assertNotEquals(complexNumber7.hashCode(), complexNumber8.hashCode());
		assertNotEquals(complexNumber9.hashCode(), complexNumber10.hashCode());
		ComplexNumber complexNumber = new ComplexNumber(3, -1);
		assertEquals(complexNumber10.hashCode(), complexNumber.hashCode());
	}
}
