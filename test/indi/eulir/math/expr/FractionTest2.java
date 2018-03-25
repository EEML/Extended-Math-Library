package indi.eulir.math.expr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest2
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
	public void testAdd() {
		assertEquals("-3/2", a.add(b).toString());
		assertEquals("37/66", a.add(c).toString());
		assertEquals("-1", a.add(d).toString());
		assertEquals("-64/33", b.add(c).toString());
		assertEquals("-7/2", b.add(d).toString());
		assertEquals("-95/66", c.add(d).toString());

	}
}