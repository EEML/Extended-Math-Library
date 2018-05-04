package org.eeml.math.equation;

import org.eeml.math.exception.HighestCoefficientBeZeroException;

import java.text.MessageFormat;

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

	public LinearEquationTwo(double a1, double b1, double c1, double a2, double b2, double c2)
	{
		if (a1 == 0 || a2 == 0 || b1 == 0 || b2 == 0)
			throw new HighestCoefficientBeZeroException("Neither a nor b can be zero");
		this.a1 = a1;
		this.a2 = a2;
		this.b1 = b1;
		this.b2 = b2;
		this.c1 = c1;
		this.c2 = c2;
		this.x = (c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1);
		this.y = (c1 * a2 - c2 * a1) / (b1 * a2 - b2 * a1);
	}

	public String toString()
	{
		return MessageFormat.format("{0}x" + (this.b1 > 0 ? "+" : "") + "{1}y={2}", this.a1, this.b1, this.c1)
				+ "\n"
				+ MessageFormat.format("{0}x" + (this.b2 > 0 ? "+" : "") + "{1}y={2}", this.a2, this.b2, this.c2)
				+ "\n"
				+ MessageFormat.format("x={0}\ty={1}", this.x, this.y);
	}
}
