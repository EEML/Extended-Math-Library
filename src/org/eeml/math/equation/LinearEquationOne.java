package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * This class mainly implements linear equation with one unknown. It provides methods like
 * getSolution.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */
public class LinearEquationOne implements Comparable
{
	private double a;
	private double b;
	private double c;
	private double x;

	public LinearEquationOne(double a, double b)
	{
		if (a == 0)
			throw new HighestCoefficientBeZeroException();
		this.a = a;
		this.b = b;
		this.c = 0;
		this.x = -this.b / this.a;
	}

	public LinearEquationOne(int a, int b)
	{
		if (a == 0)
			throw new HighestCoefficientBeZeroException();
		this.a = (double) a;
		this.b = (double) b;
		this.c = 0;
		this.x = -this.b / this.a;
	}

	public LinearEquationOne(double a, double b, double c)
	{
		if (a == 0)
			throw new IllegalArgumentException("a should not be 0 since a is the highest-degree coefficient");
		if (Math.abs(c) < 0.00001)
			throw new IllegalStateException("You should use another constructor");
		this.a = a;
		this.b = b;
		this.c = c;
		this.x = (this.c - this.b) / this.a;
	}

	public LinearEquationOne(int a, int b, int c)
	{
		if (a == 0)
			throw new IllegalArgumentException("a should not be 0 since a is the highest-degree coefficient");
		if (Math.abs(c) < 0.00001)
			throw new IllegalStateException("You should use another constructor");
		this.a = (double) a;
		this.b = (double) b;
		this.c = (double) c;
		this.x = (this.c - this.b) / this.a;
	}

	public double getSolution()
	{
		return x;
	}

	/**
	 * toString method overridden from super class
	 *
	 * @return return String formed in
	 * ax+b=c
	 */
	@Override
	public String toString()
	{
		if (this.a == 1)
			if (this.b == 0)
				return MessageFormat.format("x={0}\tx={1}", this.c, Math.abs(this.x) < 0.000001 ? 0 : this.x);
			else
				return MessageFormat.format("x" + (this.b < 0 ? "" : "+") + "{0}={1}\tx={2}", this.b, this.c, Math.abs(this.x) < 0.000001 ? 0 : this.x);
		else if (this.a == -1)
			if (this.b == 0)
				return MessageFormat.format("-x={0}\tx={1}", this.c, Math.abs(this.x) < 0.000001 ? 0 : this.x);
			else
				return MessageFormat.format("-x" + (this.b < 0 ? "" : "+") + "{0}={1}\tx={2}", this.b, this.c, Math.abs(this.x) < 0.000001 ? 0 : this.x);
		else if (this.b == 0)
			return MessageFormat.format("{0}x={1}\tx={2}", this.a, this.c, Math.abs(this.x) < 0.000001 ? 0 : this.x);
		else
			return MessageFormat.format("{0}x" + (this.b < 0 ? "" : "+") + "{1}={2}\tx={3}", this.a, this.b, this.c, Math.abs(this.x) < 0.000001 ? 0 : this.x);
	}

	/**
	 * compareTo method implemented from Comparable interface.
	 *
	 * @param o the compared object
	 * @return negative number if this equation root{@code this} is less than
	 * the compared equation root{@code o} while positive number when larger.
	 * 0 when two equation roots are equal.
	 * @throws IllegalArgumentException when {@code o is not a linear equation}
	 */
	@Override
	public int compareTo(@NotNull Object o)
	{
		if (!(o instanceof LinearEquationOne))
			throw new IllegalArgumentException();
		if (o.equals(this))
			return 0;
		return this.x > ((LinearEquationOne) o).x ? 1 : -1;
	}

	/**
	 * equals method overridden form super class
	 *
	 * @param obj the compared object
	 * @return true if two linear equations are equal, otherwise false.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (!(obj instanceof LinearEquationOne))
			return false;
		LinearEquationOne linearEquationOne = (LinearEquationOne) obj;
		return this.a == linearEquationOne.a && this.b == linearEquationOne.b && this.c == linearEquationOne.c;
	}


	/**
	 * hashCode method overridden from super class
	 *
	 * @return hashCode of the linear equation.
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(a, b, c, x);
	}
}
