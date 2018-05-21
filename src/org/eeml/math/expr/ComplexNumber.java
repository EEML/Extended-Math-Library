package org.eeml.math.expr;

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
}
