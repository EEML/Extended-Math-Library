package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.eeml.math.expr.ComplexNumber;

import java.util.Objects;

public class QuadraticEquation
{
	private int a;
	private int b;
	private int c;

	private int delta;

	private ComplexNumber x1;
	private ComplexNumber x2;

	/**
	 * form the quadratic equation in the form of
	 * ax^2+bx+c=0 where a as the highest coefficient cannot be zero.
	 *
	 * @param a coefficient of quadratic term
	 * @param b coefficient of linear term
	 * @param c constant coefficient
	 */
	public QuadraticEquation(int a, int b, int c)
	{
		if (a == 0)
			throw new HighestCoefficientBeZeroException(QuadraticEquation.class);
		this.a = a;
		this.b = b;
		this.c = c;
		this.delta = b * b - 4 * a * c;
		if (delta == 0)
		{
			x1 = new ComplexNumber(-b / (2 * a), 0);
			x2 = x1;
		} else if (delta > 0)
		{
			x1 = new ComplexNumber((-b + Math.sqrt(delta)) / (2 * a), 0);
			x2 = new ComplexNumber((-b - Math.sqrt(delta)) / (2 * a), 0);
		} else
		{
			x1 = new ComplexNumber(-b / (2 * a), Math.sqrt(-delta) / (2 * a));
			x2 = new ComplexNumber(-b / (2 * a), -Math.sqrt(-delta) / (2 * a));
		}
	}

	public ComplexNumber getFirstSolution()
	{
		return x1;
	}

	public ComplexNumber getSecondSolution()
	{
		return x2;
	}

	/**
	 * equals method overridden form super class
	 *
	 * @param obj the compared object
	 * @return true if two quadratic equations are equal, otherwise false.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (!(obj instanceof QuadraticEquation))
			return false;
		QuadraticEquation quadraticEquation = (QuadraticEquation) obj;
		return this.a == quadraticEquation.a
				&& this.b == quadraticEquation.b
				&& this.c == quadraticEquation.c;
	}

	/**
	 * hashCode method overridden from super class
	 *
	 * @return hashCode of the quadratic equation.
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(a, b, c);
	}
}
