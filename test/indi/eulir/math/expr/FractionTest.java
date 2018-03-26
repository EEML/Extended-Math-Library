package indi.eulir.math.expr;

public class FractionTest
{
	public static void main(String[] args)
	{
		//test constructor
		System.out.println("test constructor");
		Fraction a = new Fraction(1, 2);
		Fraction b = new Fraction(-4, 2);
		Fraction c = new Fraction(-6, -99);
		Fraction d = new Fraction(3, -2);

		//test oppositeNumber;
		System.out.println("test oppositeNumber");
		a.oppositeNumber();
		System.out.println(a);
		a.oppositeNumber();
		System.out.println(a);
		System.out.println();

		//test reciprocal
		System.out.println("test reciprocal");
		a.reciprocal();
		System.out.println(a);
		a.reciprocal();
		System.out.println(a);
		b.reciprocal();
		System.out.println(b);
		b.reciprocal();
		System.out.println(b);
		System.out.println();

		//test multiply
		System.out.println("test multiply");
		System.out.println(a.multiply(b));
		System.out.println(a.multiply(c));
		System.out.println(a.multiply(d));
		System.out.println(b.multiply(c));
		System.out.println(b.multiply(d));
		System.out.println(c.multiply(d));
		System.out.println();

		//test divide
		System.out.println("test divide");
		System.out.println(a.divide(b));
		System.out.println(a.divide(c));
		System.out.println(a.divide(d));
		System.out.println(b.divide(c));
		System.out.println(b.divide(d));
		System.out.println(c.divide(d));
	}
}
