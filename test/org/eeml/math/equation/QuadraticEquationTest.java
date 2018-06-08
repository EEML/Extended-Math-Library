package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.eeml.math.expr.ComplexNumber;
import org.junit.Test;

import static org.eeml.math.ThrowTestTemplate.assertThrows;
import static org.junit.Assert.assertEquals;

public class QuadraticEquationTest
{
	QuadraticEquation quadraticEquation1 = new QuadraticEquation(1, 2, 1);
	QuadraticEquation quadraticEquation2 = new QuadraticEquation(1, 0, 0);
	QuadraticEquation quadraticEquation3 = new QuadraticEquation(1, 3, 4);
	QuadraticEquation quadraticEquation4 = new QuadraticEquation(-1, 3, 5);
	QuadraticEquation quadraticEquation5 = new QuadraticEquation(-4, 0, 9);
	QuadraticEquation quadraticEquation6 = new QuadraticEquation(5, -10, 0);
	QuadraticEquation quadraticEquation7 = new QuadraticEquation(-9, -2, -1);

	@Test
	public void testToString()
	{
		assertEquals("x^2+2x+1=0\n" +
				"x1=x2=-1", quadraticEquation1.toString());
		assertEquals("x^2=0\n" +
				"x1=x2=0", quadraticEquation2.toString());
		assertEquals("x^2+3x+4=0\n" +
				"x1=-1.5+1.323i\n" +
				"x2=-1.5-1.323i", quadraticEquation3.toString());
		assertEquals("-x^2+3x+5=0\n" +
				"x1=-1.193\n" +
				"x2=4.193", quadraticEquation4.toString());
		assertEquals("-4x^2+9=0\n" +
				"x1=-1.5\n" +
				"x2=1.5", quadraticEquation5.toString());
		assertEquals("5x^2-10x=0\n" +
				"x1=2\n" +
				"x2=0", quadraticEquation6.toString());
		assertEquals("-9x^2-2x-1=0\n" +
				"x1=-0.111-0.314i\n" +
				"x2=-0.111+0.314i", quadraticEquation7.toString());
	}

	@Test
	public void testThrows()
	{
		assertThrows(HighestCoefficientBeZeroException.class, () -> new QuadraticEquation(0, 8, 9));
		assertThrows(HighestCoefficientBeZeroException.class, () -> new QuadraticEquation(0, -3, -4));
	}

	@Test
	public void testGetFirstSolution()
	{
		assertEquals(new ComplexNumber(-1, 0), quadraticEquation1.getFirstSolution());

	}
}
