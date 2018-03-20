package indi.eulir.Math.expr;

import indi.eulir.Math.MathLibrary;

/**
 * @author EULIR
 * @apiNote
 * @since 1.0.0
 */

public class Fraction
{
	private boolean sign;
	private int numerator;
	private int denominator;

	Fraction(int numerator, int denominator)
	{
		if (denominator == 0)
			throw new ArithmeticException("denominator cannot be zero");
		Boolean sign = true;
		if (numerator < 0)
			sign = false;
		if (denominator < 0)
			sign = !sign;
		this.sign = sign;
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);
		int gcd = MathLibrary.gcd(numerator, denominator);
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
	}

	private Fraction(int numerator, int denominator, boolean sign)
	{
		if (denominator == 0)
			throw new ArithmeticException("denominator cannot be zero");
		if (numerator < 0 || denominator < 0)
			throw new IllegalArgumentException();
		this.sign = sign;
		int gcd = MathLibrary.gcd(numerator, denominator);
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
	}

	private void setSign(boolean boo)
	{
		this.sign = boo;
	}

	public boolean getSign()
	{
		return this.sign;
	}

	public Fraction add(Fraction a)
	{
		if (!this.sign && !a.sign)
		{
			int newNumerator = this.numerator * a.denominator + this.denominator * a.numerator;
			int newDenominator = this.denominator * a.denominator;
			int gcd = MathLibrary.gcd(newDenominator, newNumerator);
			return new Fraction(newNumerator / gcd, newDenominator / gcd, false);
		}
		if (!this.sign && a.sign)
			return a.subtract(new Fraction(this.numerator, this.denominator, true));
		if (this.sign && !a.sign)
			return this.subtract(new Fraction(a.numerator, a.denominator, true));
		int newNumerator = this.numerator * a.denominator + this.denominator * a.numerator;
		int newDenominator = this.denominator * a.denominator;
		int gcd = MathLibrary.gcd(newDenominator, newNumerator);
		return new Fraction(newNumerator / gcd, newDenominator / gcd, true);
	}

	public Fraction subtract(Fraction a)
	{
		if (this.sign && a.sign)
		{
			int newNumerator = this.numerator * a.denominator - this.denominator * a.numerator;
			int newDenominator = this.denominator * a.denominator;
			int gcd = MathLibrary.gcd(newDenominator, newNumerator);
			return new Fraction(newNumerator / gcd, newDenominator / gcd);
		}
		if (!this.sign && a.sign)
		{
			Fraction newFraction1 = new Fraction(this.numerator, this.denominator, true);
			Fraction newFraction2 = new Fraction(a.numerator, a.denominator, true);
			Fraction base = newFraction1.add(newFraction2);
			return new Fraction(base.numerator, base.denominator, false);
		}
		if (this.sign && !a.sign)
		{
			a.setSign(true);
			return this.add(a);
		}
		a.setSign(true);
		return a.subtract(this);

	}

	public Fraction multify(Fraction a)
	{
		return new Fraction(1, 1);
	}

	public String toString()
	{
		String str = "";
		if (!sign)
			str = "-";
		if (denominator == 1)
			return str + String.valueOf(numerator);
		return str + numerator + "/" + denominator;
	}

	public static void main(String[] args)
	{
		Fraction a = new Fraction(-1, 2);
		Fraction b = new Fraction(-3, 4);
		System.out.println(a);
		a = a.subtract(b);
		System.out.println(a);
	}
}
