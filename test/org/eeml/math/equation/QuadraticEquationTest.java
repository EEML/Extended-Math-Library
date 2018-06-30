package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.eeml.math.expr.ComplexNumber;
import org.junit.Test;

import static org.eeml.math.ThrowTestTemplate.assertThrows;
import static org.junit.Assert.*;

public class QuadraticEquationTest {
	QuadraticEquation quadraticEquation1 = new QuadraticEquation(1, 2, 1);
	QuadraticEquation quadraticEquation2 = new QuadraticEquation(1, 0, 0);
	QuadraticEquation quadraticEquation3 = new QuadraticEquation(1, 3, 4);
	QuadraticEquation quadraticEquation4 = new QuadraticEquation(-1, 3, 5);
	QuadraticEquation quadraticEquation5 = new QuadraticEquation(-4, 0, 9);
	QuadraticEquation quadraticEquation6 = new QuadraticEquation(5, -10, 0);
	QuadraticEquation quadraticEquation7 = new QuadraticEquation(-9, -2, -1);

	@Test
	public void testToString() {
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
	public void testThrows() {
		assertThrows(HighestCoefficientBeZeroException.class, () -> new QuadraticEquation(0, 8, 9));
		assertThrows(HighestCoefficientBeZeroException.class, () -> new QuadraticEquation(0, -3, -4));
	}

	@Test
	public void testGetFirstSolution() {
		assertEquals(new ComplexNumber(-1, 0), quadraticEquation1.getFirstSolution());
		assertEquals(new ComplexNumber(0, 0), quadraticEquation2.getFirstSolution());
		assertEquals(new ComplexNumber(-1.5, 1.323), quadraticEquation3.getFirstSolution());
		assertEquals(new ComplexNumber(-1.193, 0), quadraticEquation4.getFirstSolution());
		assertEquals(new ComplexNumber(-1.5, 0), quadraticEquation5.getFirstSolution());
		assertEquals(new ComplexNumber(2, 0), quadraticEquation6.getFirstSolution());
		assertEquals(new ComplexNumber(-0.111, -0.314), quadraticEquation7.getFirstSolution());
	}

	@Test
	public void testGetSecondSolution() {
		assertEquals(new ComplexNumber(-1, 0), quadraticEquation1.getSecondSolution());
		assertEquals(new ComplexNumber(0, 0), quadraticEquation2.getSecondSolution());
		assertEquals(new ComplexNumber(-1.5, -1.323), quadraticEquation3.getSecondSolution());
		assertEquals(new ComplexNumber(4.193, 0), quadraticEquation4.getSecondSolution());
		assertEquals(new ComplexNumber(1.5, 0), quadraticEquation5.getSecondSolution());
		assertEquals(new ComplexNumber(0, 0), quadraticEquation6.getSecondSolution());
		assertEquals(new ComplexNumber(-0.111, 0.314), quadraticEquation7.getSecondSolution());
	}

	@Test
	public void testGetDelta() {
		assertEquals(0, quadraticEquation1.getDelta());
		assertEquals(0, quadraticEquation2.getDelta());
		assertEquals(-7, quadraticEquation3.getDelta());
		assertEquals(29, quadraticEquation4.getDelta());
		assertEquals(144, quadraticEquation5.getDelta());
		assertEquals(100, quadraticEquation6.getDelta());
		assertEquals(-32, quadraticEquation7.getDelta());
	}

	@Test
	public void testEquals() {
		QuadraticEquation quadraticEquation = quadraticEquation1;
		assertTrue(quadraticEquation.equals(quadraticEquation1));
		assertFalse(quadraticEquation2.equals(new Object()));
		assertFalse(quadraticEquation3.equals(quadraticEquation4));
		assertFalse(quadraticEquation5.equals(quadraticEquation6));
		QuadraticEquation quadraticEquation8 = new QuadraticEquation(-9, -2, -1);
		assertTrue(quadraticEquation7.equals(quadraticEquation8));
	}

	@Test
	public void testHashcode() {
		QuadraticEquation quadraticEquation8 = new QuadraticEquation(-9, -2, -1);
		assertEquals(quadraticEquation7.hashCode(), quadraticEquation8.hashCode());
		assertNotEquals(quadraticEquation1.hashCode(), quadraticEquation2.hashCode());
		assertNotEquals(quadraticEquation3.hashCode(), quadraticEquation4.hashCode());
		assertNotEquals(quadraticEquation5.hashCode(), quadraticEquation6.hashCode());
	}
}
