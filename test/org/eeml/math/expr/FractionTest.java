package org.eeml.math.expr;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is the test class of Fraction class
 *
 * @author EULIR
 * @version v1.0.0
 * @coverage 100%
 * @see org.eeml.math
 */

public class FractionTest
{
	private Fraction a = new Fraction(1, 2);
	private Fraction b = new Fraction(-4, 2);
	private Fraction c = new Fraction(-6, -99);
	private Fraction d = new Fraction(3, -2);

	private static void assertThrows(Class<? extends Throwable> clazz, Runnable function)
	{
		try
		{
			function.run();
		} catch (Throwable e)
		{
			if (e.getClass() == clazz)
				System.out.println("Successfully thrown " + e.getClass().getSimpleName() + ", message: " + e.getMessage());
			else fail("Error: expected: " + clazz.getSimpleName() + ", get: " + e.getClass().getSimpleName());
			return;
		}
		fail("No exceptions thrown!");
	}

	@Test
	public void testException()
	{
		assertThrows(ArithmeticException.class, () -> new Fraction(1, 0));
		assertThrows(ArithmeticException.class, () -> new Fraction(1, 0, true));
		assertThrows(IllegalArgumentException.class, () -> new Fraction(-1, -1, true));
	}

	@Test
	public void testToString()
	{
		assertEquals("1/2", a.toString());
		assertEquals("-2", b.toString());
		assertEquals("2/33", c.toString());
		assertEquals("-3/2", d.toString());
	}

	@Test
	public void testAdd()
	{
		assertEquals("-3/2", a.add(b).toString());
		assertEquals("37/66", a.add(c).toString());
		assertEquals("-1", a.add(d).toString());
		assertEquals("-64/33", b.add(c).toString());
		assertEquals("-7/2", b.add(d).toString());
		assertEquals("-95/66", c.add(d).toString());
	}

	@Test
	public void testSubtract()
	{
		assertEquals("5/2", a.subtract(b).toString());
		assertEquals("29/66", a.subtract(c).toString());
		assertEquals("2", a.subtract(d).toString());
		assertEquals("-68/33", b.subtract(c).toString());
		assertEquals("-1/2", b.subtract(d).toString());
		assertEquals("103/66", c.subtract(d).toString());
	}

	@Test
	public void testMultiply()
	{
		assertEquals("-1", a.multiply(b).toString());
		assertEquals("1/33", a.multiply(c).toString());
		assertEquals("-3/4", a.multiply(d).toString());
		assertEquals("-4/33", b.multiply(c).toString());
		assertEquals("3", b.multiply(d).toString());
		assertEquals("-1/11", c.multiply(d).toString());
	}

	@Test
	public void testDivide()
	{
		assertEquals("-1/4", a.divide(b).toString());
		assertEquals("33/4", a.divide(c).toString());
		assertEquals("-1/3", a.divide(d).toString());
		assertEquals("-33", b.divide(c).toString());
		assertEquals("4/3", b.divide(d).toString());
		assertEquals("-4/99", c.divide(d).toString());
	}

	@Test
	public void testSetSign()
	{
		a.setSign(false);
		assertEquals("-1/2", a.toString());
		a.setSign(true);
		assertEquals("1/2", a.toString());
	}

	@Test
	public void testOppositeNumber()
	{
		assertEquals("-1/2", a.oppositeNumber().toString());
		assertEquals("2", b.oppositeNumber().toString());
		assertEquals("-2/33", c.oppositeNumber().toString());
		assertEquals("3/2", d.oppositeNumber().toString());
	}

	@Test
	public void testOpposite()
	{
		a.opposite();
		assertEquals("-1/2", a.toString());
		a.opposite();
		assertEquals("1/2", a.toString());
	}

	@Test
	public void testGetSign()
	{
		assertEquals("+", a.getSign());
		assertEquals("-", b.getSign());
		assertEquals("+", c.getSign());
		assertEquals("-", d.getSign());
	}

	@Test
	public void testGetValue()
	{
		assertEquals(0.5, a.getValue(), 0.01);
		assertEquals(-2.0, b.getValue(), 0.01);
		assertEquals(0.0606, c.getValue(), 0.01);
		assertEquals(-1.5, d.getValue(), 0.01);
	}

	@Test
	public void testCompareTo()
	{
		assertTrue(a.compareTo(b) > 0);
		assertTrue(a.compareTo(c) > 0);
		assertTrue(a.compareTo(d) > 0);
		assertTrue(b.compareTo(c) < 0);
		assertTrue(b.compareTo(d) < 0);
		assertTrue(c.compareTo(d) > 0);

		Fraction x = new Fraction(2, 4);
		Fraction y = new Fraction(1, 2);
		assertEquals(0, x.compareTo(y));
		assertThrows(IllegalArgumentException.class, () -> a.compareTo(new Object()));
	}

	@Test
	public void testEquals()
	{
		Fraction test1 = new Fraction(1, 3);
		Fraction test2 = test1;
		assertTrue(test1.equals(test2));
		Fraction test3 = new Fraction(2, 6);
		assertTrue(test1.equals(test3));
		Fraction test4 = new Fraction(-1, 2);
		assertFalse(test1.equals(test4));
		Fraction test5 = new Fraction(1, -2);
		assertTrue(test5.equals(test4));
		assertFalse(test1.equals(new Object()));
	}

	@Test
	public void testHashCode()
	{
		Fraction test1 = new Fraction(1, 3);
		Fraction test3 = new Fraction(2, 6);
		Fraction test4 = new Fraction(-1, 2);
		Fraction test5 = new Fraction(1, -2);
		assertEquals(test1.hashCode(), test3.hashCode());
		assertEquals(test4.hashCode(), test5.hashCode());
		assertNotEquals(test1.hashCode(), test4.hashCode());
	}
}
