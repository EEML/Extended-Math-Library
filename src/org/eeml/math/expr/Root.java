package org.eeml.math.expr;

import org.eeml.math.MathLibrary;

public class Root
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

}
