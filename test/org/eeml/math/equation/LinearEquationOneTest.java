package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.eeml.math.ThrowTestTemplate.assertThrows;
import static org.junit.Assert.*;

public class LinearEquationOneTest
{
	LinearEquationOne line1 = new LinearEquationOne(2, 2, 9);
	LinearEquationOne line2 = new LinearEquationOne(-3, -2, -1);
	LinearEquationOne line3 = new LinearEquationOne(-2.2, 4.5, 6);
	LinearEquationOne line4 = new LinearEquationOne(1, 0);
	LinearEquationOne line5 = new LinearEquationOne(-1, 4, 9);
	LinearEquationOne line6 = new LinearEquationOne(-1, 0);
	LinearEquationOne line7 = new LinearEquationOne(2.432, 31.234);
	LinearEquationOne line8 = new LinearEquationOne(1, 8);
	LinearEquationOne line9 = new LinearEquationOne(2, 0, 8);

	@Test
	public void testToString()
	{
		assertEquals("2x+2=9\tx=3.5", line1.toString());
		assertEquals("-3x-2=-1\tx=-0.333", line2.toString());
		assertEquals("-2.2x+4.5=6\tx=-0.682", line3.toString());
		assertEquals("x=0\tx=0", line4.toString());
		assertEquals("-x+4=9\tx=-5", line5.toString());
		assertEquals("-x=0\tx=0", line6.toString());
		assertEquals("2.432x+31.234=0\tx=-12.843", line7.toString());
		assertEquals("x+8=0\tx=-8", line8.toString());
		assertEquals("2x=8\tx=4", line9.toString());
	}

	@Test
	public void testException()
	{
		assertThrows(HighestCoefficientBeZeroException.class, () -> new LinearEquationOne(0, 4));
		assertThrows(HighestCoefficientBeZeroException.class, () -> new LinearEquationOne(0.0, 0.342));
		assertThrows(IllegalArgumentException.class, () -> new LinearEquationOne(0, 3, 4));
		assertThrows(IllegalArgumentException.class, () -> new LinearEquationOne(0.00, 9, 9.56));
		assertThrows(IllegalStateException.class, () -> new LinearEquationOne(-2, 4, 0));
		assertThrows(IllegalStateException.class, () -> new LinearEquationOne(9, 6.6, 0));
		assertThrows(IllegalArgumentException.class, () -> line1.compareTo(new Object()));
	}

	@Test
	public void testGetSolution()
	{
		assertEquals(3.5, line1.getSolution(), 0.001);
		assertEquals(-0.33, line2.getSolution(), 0.01);
		assertEquals(-0.682, line3.getSolution(), 0.001);
		assertEquals(0, line4.getSolution(), 0.001);
		assertEquals(-5, line5.getSolution(), 0.001);
		assertEquals(0, line6.getSolution(), 0.001);
		assertEquals(-12.843, line7.getSolution(), 0.001);
		assertEquals(-8, line8.getSolution(), 0.001);
		assertEquals(4, line9.getSolution(), 0.001);
	}

	@Test
	public void testCompareTo()
	{
		assertTrue(line1.compareTo(line2) > 0);
		assertTrue(line3.compareTo(line4) < 0);
		assertTrue(line5.compareTo(line6) < 0);
		assertTrue(line7.compareTo(line8) < 0);
		LinearEquationOne linearEquationOne = line1;
		assertEquals(0, line1.compareTo(linearEquationOne));
	}

	@Test
	public void testEquals()
	{
		assertFalse(line1.equals(new Object()));
		assertFalse(line1.equals(line2));
		assertFalse(line1.equals(line7));
		LinearEquationOne linearEquationOne = line2;
		assertTrue(line2.equals(linearEquationOne));
	}

	@Test
	public void testHashcode()
	{
		assertNotEquals(line1.hashCode(), line2.hashCode());
		assertNotEquals(line3.hashCode(), line4.hashCode());
	}
}
