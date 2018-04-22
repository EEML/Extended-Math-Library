package org.eeml.math.equation;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class LinearEquation implements Comparable
{
	private double a;
	private double b;
	private double c;
	private double x;

	public LinearEquation(double a, double b)
	{
		if (a == 0)
			throw new IllegalArgumentException("a should not be 0 since a is the highest-degree coefficient");
		this.a = a;
		this.b = b;
		this.c = 0.0D;
		this.x = -this.b / this.a;
	}

	public LinearEquation(int a, int b)
	{
		if (a == 0)
			throw new IllegalArgumentException("a should not be 0 since a is the highest-degree coefficient");
		this.a = (double) a;
		this.b = (double) b;
		this.c = 0.0D;
		this.x = -this.b / this.a;
	}

	public LinearEquation(double a, double b, double c)
	{
		if (a == 0)
			throw new IllegalArgumentException("a should not be 0 since a is the highest-degree coefficient");
		this.a = a;
		this.b = b;
		this.c = c;
		this.x = (this.c - this.b) / this.a;
	}

	public LinearEquation(int a, int b, int c)
	{
		if (a == 0)
			throw new IllegalArgumentException("a should not be 0 since a is the highest-degree coefficient");
		this.a = (double) a;
		this.b = (double) b;
		this.c = (double) c;
		this.x = (this.c - this.b) / this.a;
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
		return this.b == 0 ? this.a + "x=" + 0 : this.a + "x+" + this.b + "=" + this.c;
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
		if (!(o instanceof LinearEquation))
			throw new IllegalArgumentException();
		if (o.equals(this))
			return 0;
		return this.x > ((LinearEquation) o).x ? 1 : -1;
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
		if (!(obj instanceof LinearEquation))
			return false;
		LinearEquation linearEquation = (LinearEquation) obj;
		return this.a == linearEquation.a && this.b == linearEquation.b && this.c == linearEquation.c;
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
