package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.eeml.math.expr.ComplexNumber;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * This class mainly implements quadratic equation. It provides methods like
 * getSolution.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */
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
	 * @throws HighestCoefficientBeZeroException when {@code a} equals zero.
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
			x1 = new ComplexNumber(-b / (double) (2 * a), 0);
			x2 = x1;
		} else if (delta > 0)
		{
			x1 = new ComplexNumber((-b + Math.sqrt(delta)) / (2 * a), 0);
			x2 = new ComplexNumber((-b - Math.sqrt(delta)) / (2 * a), 0);
		} else
		{
			x1 = new ComplexNumber(-b / (double) (2 * a), Math.sqrt(-delta) / (2 * a));
			x2 = new ComplexNumber(-b / (double) (2 * a), -Math.sqrt(-delta) / (2 * a));
		}
	}

	/**
	 * getter of the first solution
	 *
	 * @return solution x1
	 */
	public ComplexNumber getFirstSolution()
	{
		return x1;
	}

	/**
	 * getter of the second solution
	 *
	 * @return solution x2
	 */
	public ComplexNumber getSecondSolution()
	{
		return x2;
	}

	/**
	 * getter of delta
	 *
	 * @return delta
	 */
	public int getDelta()
	{
		return delta;
	}

	/**
	 * toString method overridden from super class
	 *
	 * @return return String formed in
	 * ax^2+bx+c=0
	 * x1=
	 * x2=
	 * OR
	 * ax^2+bx+c=0
	 * x1=x2=
	 */
	public String toString()
	{
		String a = MessageFormat.format("{0}", this.a);
		String b = MessageFormat.format("{0}", this.b);
		String c = MessageFormat.format("{0}", this.c);
		StringBuilder str = new StringBuilder();
		str.append(this.a == 1 ? "" : (this.a == -1 ? "-" : a)).append("x^2");
		if (this.b != 0)
			str.append(this.b > 0 ? "+" : "").append(this.b == 1 ? "" : (this.b == -1 ? "-" : b)).append("x");
		if (this.c != 0)
			str.append(this.c > 0 ? "+" : "").append(c);
		str.append("=0").append("\n").append("x1=");
		if (delta == 0)
			str.append("x2=").append(MessageFormat.format("{0}", x1));
		else
			str.append(MessageFormat.format("{0}", x1)).append("\n").append("x2=").append(MessageFormat.format("{0}", x2));
		return str.toString();
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
