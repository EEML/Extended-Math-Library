package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;
import org.eeml.math.exception.NotSolvableException;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * This class mainly implements linear equation with two unknown. It provides methods like
 * getSolution.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */
public class LinearEquationTwo
{
	/**
	 * form the linear equation with two unknown in the following way:
	 * a1 * x + b1 * y = c1
	 * a2 * x + b2 * y = c2
	 * where a1, a2, b1, b2, c1, c2, x, y represent the above parameters respectively.
	 */
	private double a1;
	private double a2;
	private double b1;
	private double b2;
	private double c1;
	private double c2;
	private double x;
	private double y;

	/**
	 * default constructor
	 */
	public LinearEquationTwo()
	{
		this.a1 = 0;
		this.a2 = 0;
		this.b1 = 0;
		this.b2 = 0;
		this.c1 = 0;
		this.c2 = 0;
		this.x = 0;
		this.y = 0;
	}

	/**
	 * @param a1 coefficient of x in the first equation
	 * @param b1 coefficient of y in the first equation
	 * @param c1 constant coefficient in the first equation
	 * @param a2 coefficient of x in the second equation
	 * @param b2 coefficient of y in the second equation
	 * @param c2 constant coefficient in the first equation
	 * @throws HighestCoefficientBeZeroException when {@code a1}, {@code b1},
	 *                                           {@code a2} or {@code b2} is zero
	 * @throws NotSolvableException              when two equations are the same(including the
	 *                                           situation that they have some coefficient
	 *                                           before the parameters).
	 */
	public LinearEquationTwo(double a1, double b1, double c1, double a2, double b2, double c2)
	{
		if (a1 == 0 || a2 == 0 || b1 == 0 || b2 == 0)
			throw new HighestCoefficientBeZeroException("Neither a nor b can be zero");
		if (a1 * b2 == a2 * b1)
			throw new NotSolvableException();
		this.a1 = a1;
		this.a2 = a2;
		this.b1 = b1;
		this.b2 = b2;
		this.c1 = c1;
		this.c2 = c2;
		this.x = (c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1);
		this.y = (c1 * a2 - c2 * a1) / (b1 * a2 - b2 * a1);
	}

	/**
	 * getter of the solution x
	 *
	 * @return solution x
	 */
	public double getXSolution()
	{
		return x;
	}

	/**
	 * getter of the solution y
	 *
	 * @return solution y
	 */
	public double getYSolution()
	{
		return y;
	}

	/**
	 * toString method overridden from super class
	 *
	 * @return return String formed in
	 * a1 * x + b1 * y = c1
	 * a2 * x + b2 * y = c2
	 */
	public String toString()
	{
		return MessageFormat.format((this.a1 == 1 ? "" : this.a1 == -1 ? "-" : "{0}") + "x" + (this.b1 > 0 ? "+" : "") + (this.b1 == 1 ? "" : this.b1 == -1 ? "-" : "{1}") + "y={2}", this.a1, this.b1, this.c1)
				+ "\n"
				+ MessageFormat.format((this.a2 == 1 ? "" : this.a2 == -1 ? "-" : "{0}") + "x" + (this.b2 > 0 ? "+" : "") + (this.b2 == 1 ? "" : this.b2 == -1 ? "-" : "{0}") + "y={2}", this.a2, this.b2, this.c2)
				+ "\n"
				+ MessageFormat.format("x={0}\ty={1}", this.x, this.y);
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
		if (!(obj instanceof LinearEquationTwo))
			return false;
		LinearEquationTwo linearEquationTwo = (LinearEquationTwo) obj;
		return this.a1 == linearEquationTwo.a1
				&& this.b1 == linearEquationTwo.b1
				&& this.c1 == linearEquationTwo.c1
				&& this.a2 == linearEquationTwo.a2
				&& this.b2 == linearEquationTwo.b2
				&& this.c2 == linearEquationTwo.c2;
	}

	/**
	 * hashCode method overridden from super class
	 *
	 * @return hashCode of the linear equation.
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(a1, b1, c1, a2, b2, c2, x, y);
	}
}
