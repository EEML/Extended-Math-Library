package indi.eulir.math.expr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest
{
	private Fraction a = new Fraction(1, 2);
	private Fraction b = new Fraction(-4, 2);
	private Fraction c = new Fraction(-6, -99);
	private Fraction d = new Fraction(3, -2);

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
	}
}
