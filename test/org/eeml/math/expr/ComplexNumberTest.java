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

	@Test
	public void testAdd()
	{
		assertEquals("7.4+9.1i", complexNumber1.add(complexNumber2).toString());
		assertEquals("-8+6.876i", complexNumber3.add(complexNumber4).toString());
		assertEquals("0.99i", complexNumber5.add(complexNumber6).toString());
		assertEquals("-316", complexNumber7.add(7).toString());
		assertEquals("-8.3", complexNumber8.add(-9.3).toString());
		assertEquals("-2", complexNumber9.add(-2).toString());
		assertEquals("7.345-i", complexNumber10.add(4.345).toString());
	}

	@Test
	public void testSubtract()
	{
		assertEquals("3-i", complexNumber10.subtract(complexNumber9).toString());
		assertEquals("324", complexNumber8.subtract(complexNumber7).toString());
		assertEquals("-1.01i", complexNumber6.subtract(complexNumber5).toString());
		assertEquals("-12-2i", complexNumber4.subtract(8).toString());
		assertEquals("-1+8.876i", complexNumber3.subtract(-3).toString());
		assertEquals("0.655-0.4i", complexNumber2.subtract(4.345).toString());
		assertEquals("8+9.5i", complexNumber1.subtract(-5.6).toString());
	}

	@Test
	public void testMultiply()
	{
		assertEquals("16.7+26.1i", complexNumber1.multiply(complexNumber10).toString());
		assertEquals("0", complexNumber2.multiply(complexNumber9).toString());
		assertEquals("-4+8.876i", complexNumber3.multiply(complexNumber8).toString());
		assertEquals("-17.2-8.6i", complexNumber4.multiply(4.3).toString());
		assertEquals("-3.4i", complexNumber5.multiply(-3.4).toString());
		assertEquals("0", complexNumber6.multiply(0).toString());
		assertEquals("323", complexNumber7.multiply(-1).toString());
	}

	@Test
	public void testDivide()
	{
		assertEquals("0.788-0.626i", complexNumber1.divide(complexNumber3).toString());
		assertEquals("", complexNumber2.divide(complexNumber4).toString());
	}
}
