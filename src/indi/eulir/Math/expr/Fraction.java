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

	public void oppositeNumber()
	{
		this.setSign(!this.sign);
	}

	public boolean getSign()
	{
		return this.sign;
	}

	public void reciprocal()
	{
		int temp = this.numerator;
		this.numerator = this.denominator;
		this.denominator = temp;
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
		if (!this.sign)
			return a.subtract(new Fraction(this.numerator, this.denominator, true));
		if (!a.sign)
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
		if (this.sign)
		{
			Fraction temp = new Fraction(a.numerator, a.denominator, true);
			return this.add(temp);
		}
		Fraction temp = new Fraction(a.numerator, a.denominator, true);
		return temp.add(this);
	}

	public Fraction multiply(Fraction a)
	{
		int m = this.numerator;
		int n = this.denominator;
		int o = a.numerator;
		int p = a.denominator;
		int g1 = MathLibrary.gcd(m, p);
		m /= g1;
		p /= g1;
		int g2 = MathLibrary.gcd(n, o);
		n /= g2;
		o /= g2;
		return new Fraction(m * o, n * p, this.sign == a.sign);
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
}
