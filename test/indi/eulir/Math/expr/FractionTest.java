package indi.eulir.Math.expr;

public class FractionTest
{
	public static void main(String[] args)
	{
		//test constructor
		Fraction a = new Fraction(1, 2);
		Fraction b = new Fraction(-4, 2);
		Fraction c = new Fraction(-6, -99);
		Fraction d = new Fraction(3, -2);
		System.out.println(a + " " + b + " " + c + " " + d);
		//Fraction e = new Fraction(3,0);
		System.out.println();
		//System.out.println(c.add(d));
		//test add
		System.out.println(a.add(b));
		System.out.println(a.add(c));
		System.out.println(a.add(d));
		System.out.println(b.add(c));
		System.out.println(b.add(d));
		System.out.println(c.add(d));
		System.out.println();

		//test subtract
		System.out.println(a.subtract(b));
		System.out.println(a.subtract(c));
		System.out.println(a.subtract(d));
		System.out.println(b.subtract(c));
		System.out.println(b.subtract(d));
		System.out.println(c.subtract(d));
	}
}
