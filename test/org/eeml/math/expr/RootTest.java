package org.eeml.math.expr;

import org.junit.Test;

import static org.eeml.math.ThrowTestTemplate.assertThrows;
import static org.junit.Assert.assertEquals;

public class RootTest
{
	Root root1 = new Root(2);
	Root root2 = new Root(4);
	Root root3 = new Root(8);
	Root root4 = new Root(234);

	@Test
	public void testToString()
	{
		assertEquals("√2", root1.toString());
		assertEquals("2", root2.toString());
		assertEquals("2√2", root3.toString());
		assertEquals("3√26", root4.toString());
	}

	@Test
	public void testThrows()
	{
		assertThrows(ArithmeticException.class, () -> new Root(-7));
		assertThrows(IllegalArgumentException.class, () -> root1.compareTo(new Object()));
	}

	@Test
	public void testMultiply()
	{
		assertEquals("2√2", root1.multiply(root2).toString());
		assertEquals("12√13", root3.multiply(root4).toString());
	}

	@Test
	public void testGetValue()
	{
		assertEquals(1.414, root1.getValue(), 0.001);
		assertEquals(2, root2.getValue(), 0.001);
		assertEquals(2.828, root3.getValue(), 0.001);
		assertEquals(15.297, root4.getValue(), 0.001);
	}

	@Test
	public void testSetterGetter()
	{
		assertEquals(1, root1.getCoefficient());
		assertEquals(2, root2.getCoefficient());
		assertEquals(2, root3.getCoefficient());
		assertEquals(3, root4.getCoefficient());
		assertEquals(2, root1.getBase());
		assertEquals(1, root2.getBase());
		assertEquals(2, root3.getBase());
		assertEquals(26, root4.getBase());
		root1.setCoefficient(2);
		assertEquals(2, root1.getCoefficient());
		root2.setCoefficient(6);
		assertEquals(6, root2.getCoefficient());
	}
}
