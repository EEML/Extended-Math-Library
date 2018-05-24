package org.eeml.math.expr;

import java.text.MessageFormat;

/**
 * This class mainly implements the math expression complex number including methods like add,
 * multiply etc.The naming principle is the same as java.math.BigInteger.
 * Maintained by<a href="https://github.com/EEML">EEML</a>.see more on<code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */

public class ComplexNumber
{
	private double real;
	private double imaginary;

	public ComplexNumber(double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}

	public ComplexNumber add(ComplexNumber a)
	{
		return new ComplexNumber(this.real + a.real, this.imaginary + a.imaginary);
	}

	public ComplexNumber add(int a)
	{
		return new ComplexNumber(this.real + a, this.imaginary);
	}

	public ComplexNumber add(double a)
	{
		return new ComplexNumber(this.real + a, this.imaginary);
	}

	public ComplexNumber multiply(ComplexNumber a)
	{
		double real = this.real * a.real - this.imaginary * a.imaginary;
		double imaginary = this.real * a.imaginary + this.imaginary * a.real;
		return new ComplexNumber(real, imaginary);
	}

	public ComplexNumber multiply(double a)
	{
		return new ComplexNumber(this.real * a, this.imaginary * a);
	}

	/**
	 * toString method overridden from super class
	 *
	 * @return return String formed in
	 * real + imaginary + "i"
	 */
	public String toString()
	{
		if (this.imaginary == 0)
			return MessageFormat.format("{0}", this.real);
		return MessageFormat.format("{0}" + (this.imaginary > 0 ? "+" : "") + (this.imaginary == 1 ? "" : "{1}") + "i", this.real, this.imaginary);
	}
}
