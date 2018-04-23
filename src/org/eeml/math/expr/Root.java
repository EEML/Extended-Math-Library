package org.eeml.math.expr;

import org.eeml.math.MathLibrary;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class mainly implements the math expression square root. The class allows users to
 * calculate and express the square root of an integer that can be displayed in a appealing way.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */
public class Root implements Comparable
{
	private int coefficient;
	private int base;

	public Root(int base)
	{
		if (base < 0)
			throw new ArithmeticException("Base of a square root cannot be negative");
		if (MathLibrary.isSquare(base))
		{
			this.coefficient = (int) Math.sqrt(base);
			this.base = 0;
			return;
		}
		this.coefficient = 1;
		for (int i = (int) Math.sqrt(base); i >= 2; i--)
			if (base % i == 0 && base % (i * i) == 0)
			{
				this.coefficient *= i;
				base /= i * i;
			}
		this.base = base;
	}

	public int getCoefficient()
	{
		return coefficient;
	}

	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}

	public int getBase()
	{
		return base;
	}

	public void setBase(int base)
	{
		this.base = base;
	}

	public Root multiply(Root a)
	{
		return new Root(this.coefficient * this.coefficient * this.base * a.coefficient * a.coefficient * a.base);
	}

	public double getValue()
	{
		return this.coefficient * Math.sqrt(base);
	}

	/**
	 * toString method overridden from super class
	 *
	 * @return return String formed in
	 * "coefficient" + "√" + "base"
	 */
	@Override
	public String toString()
	{
		if (this.base == 0)
			return String.valueOf(this.coefficient);
		else if (this.coefficient == 1)
			return "√" + this.base;
		else return this.coefficient + "√" + this.base;
	}

	/**
	 * compareTo method implemented from Comparable interface.
	 *
	 * @param o the compared object
	 * @return negative number if this root{@code this} is less than
	 * the compared root{@code o} while positive number when larger.
	 * 0 when two roots are equal.
	 * @throws IllegalArgumentException when {@code o is not a root}
	 */
	@Override
	public int compareTo(@NotNull Object o)
	{
		if (!(o instanceof Root))
			throw new IllegalArgumentException();
		if (o.equals(this))
			return 0;
		return this.getValue() > ((Root) o).getValue() ? 1 : -1;
	}

	/**
	 * equals method overridden form super class
	 *
	 * @param obj the compared object
	 * @return true if two roots are equal, otherwise false.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (!(obj instanceof Root))
			return false;
		Root root = (Root) obj;
		return this.coefficient == root.coefficient && this.base == root.base;
	}

	/**
	 * hashCode method overridden from super class
	 *
	 * @return hashCode of the root.
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(coefficient, base);
	}

}
