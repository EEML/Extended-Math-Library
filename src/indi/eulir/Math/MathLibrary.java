package indi.eulir.Math;

public class MathLibrary
{
	/**
	 * Return greatest common divisor of the argument
	 * @param a first parameter
	 * @param b second parameter
	 * @return greatest common divisor of the argument
	 */
	public static int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}


	public static void main(String[] args)
	{

	}
}
