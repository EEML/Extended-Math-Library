package indi.eulir.Math.expr;

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
		System.out.println(a + " " + b + " " + c + " " + d);
		//Fraction e = new Fraction(3,0);
		System.out.println();

		//test add
		System.out.println("test add");
		System.out.println(a.add(b));
		System.out.println(a.add(c));
		System.out.println(a.add(d));
		System.out.println(b.add(c));
		System.out.println(b.add(d));
		System.out.println(c.add(d));
		System.out.println();

		//test subtract
		System.out.println("test subtract");
		System.out.println(a.subtract(b));
		System.out.println(a.subtract(c));
		System.out.println(a.subtract(d));
		System.out.println(b.subtract(c));
		System.out.println(b.subtract(d));
		System.out.println(c.subtract(d));
		System.out.println();

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
	}
}
