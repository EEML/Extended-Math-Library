package org.eeml.math.expr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComplexNumberTest
{
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
	public void testToString()
	{
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
}
