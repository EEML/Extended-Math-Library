package org.eeml.math.equation;

import org.junit.Test;

public class QuadraticEquationTest
{
	QuadraticEquation quadraticEquation1 = new QuadraticEquation(1, 2, 1);
	QuadraticEquation quadraticEquation2 = new QuadraticEquation(1, 0, 0);
	QuadraticEquation quadraticEquation3 = new QuadraticEquation(1, 3, 4);
	QuadraticEquation quadraticEquation4 = new QuadraticEquation(-1, 3, 5);
	QuadraticEquation quadraticEquation5 = new QuadraticEquation(-4, 0, 9);
	QuadraticEquation quadraticEquation6 = new QuadraticEquation(5, -10, 0);

	@Test
	public void testToString()
	{
		System.out.println(quadraticEquation6);

	}
}
