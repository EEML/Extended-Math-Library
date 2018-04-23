package org.eeml.math.expr;

import org.eeml.math.MathLibrary;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class mainly implements the math expression fraction including methods like add,
 * subtract, multiply, divide, reciprocal, and opposite number etc. The naming
 * principle is the same as java.math.BigInteger.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */

public class Fraction implements Comparable
{
	private boolean sign;
	private int numerator;
	private int denominator;

	/**
	 * @param numerator   numerator of a fraction
	 * @param denominator denominator of a fraction
	 * @throws ArithmeticException when {@code denominator} is 0
	 */
	public Fraction(int numerator, int denominator)
	{
		if (denominator == 0)
			throw new ArithmeticException("denominator cannot be zero");
		this.sign = numerator < 0 == denominator < 0;
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);
		int gcd = MathLibrary.gcd(numerator, denominator);
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
	}

	/**
	 * @param numerator   numerator of a fraction
	 * @param denominator denominator of a fraction
	 * @param sign        sign of a fraction
	 * @throws ArithmeticException      when {@code denominator} is 0
	 * @throws IllegalArgumentException when {@code numerator} or {@code denominator} is negative
	 */
	public Fraction(int numerator, int denominator, boolean sign)
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

	/**
	 * set the sign of the fraction
	 *
	 * @param boo sign of the fraction.True for positive and false for negative.
	 */
	public void setSign(boolean boo)
	{
		this.sign = boo;
	}

	/**
	 * @return Opposite number of the given fraction
	 */
	public Fraction oppositeNumber()
	{
		return new Fraction(numerator, denominator, !sign);
	}

	/**
	 * make the fraction become the opposite number.
	 */
	public void opposite()
	{
		this.setSign(!this.sign);
	}

	/**
	 * getter method of {@code sign}
	 *
	 * @return the sign of the fraction."+" for positive and "-" for negative.
	 */
	public String getSign()
	{
		return this.sign ? "+" : "-";
	}

	/**
	 * getter method of {@code numerator}
	 *
	 * @return the numerator of the fraction
	 */
	public int getNumerator()
	{
		return this.numerator;
	}

	/**
	 * getter method of {@code denominator}
	 *
	 * @return the denominator of the fraction
	 */
	public int getDenominator()
	{
		return this.denominator;
	}

	/**
	 * make the fraction become the reciprocal.
	 */
	public void reciprocal()
	{
		int temp = this.numerator;
		this.numerator = this.denominator;
		this.denominator = temp;
	}

	/**
	 * @param a the addend fraction.
	 * @return a new fraction which stands for the sum of two fractions.
	 */
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

	/**
	 * @param a the minuend number.
	 * @return a new fraction which stands for the difference between two fractions.
	 */
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

	/**
	 * @param a the multiplier fraction.
	 * @return a new fraction which stands for the product of two fractions.
	 */
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

	/**
	 * @param a the dividend fraction.
	 * @return a new fraction which stands for the quotient of two fraction.
	 */
	public Fraction divide(Fraction a)
	{
		Fraction temp = new Fraction(a.numerator, a.denominator, a.sign);
		temp.reciprocal();
		return this.multiply(temp);
	}

	/**
	 * @return the value of the fraction.
	 */
	public double getValue()
	{
		double d = (double) numerator / denominator;
		return sign ? d : -d;
	}

	/**
	 * toString method overridden from super class
	 *
	 * @return return String formed in
	 * "sign" + "numerator" + "/" + "denominator"
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		if (!sign)
			builder.append("-");
		builder.append(numerator);
		if (denominator != 1)
			builder.append("/").append(denominator);
		return builder.toString();
	}

	/**
	 * compareTo method implemented from Comparable interface.
	 *
	 * @param o the compared object
	 * @return negative number if this fraction{@code this} is less than
	 * the compared fraction{@code o} while positive number when larger.
	 * 0 when two fractions are equal.
	 * @throws IllegalArgumentException when {@code o is not a fraction}
	 */
	@Override
	public int compareTo(@NotNull Object o)
	{
		if (!(o instanceof Fraction))
			throw new IllegalArgumentException();
		if (o.equals(this))
			return 0;
		Fraction fraction = (Fraction) o;
		return this.subtract(fraction).getSign().equals("+") ? 1 : -1;
	}

	/**
	 * equals method overridden form super class
	 *
	 * @param obj the compared object
	 * @return true if two fractions are equal, otherwise false.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (!(obj instanceof Fraction))
			return false;
		Fraction fraction = (Fraction) obj;
		return this.sign == fraction.sign && this.numerator == fraction.numerator && this.denominator == fraction.denominator;
	}

	/**
	 * hashCode method overridden from super class
	 *
	 * @return hashCode of the fraction.
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(sign, numerator, denominator);
	}
}