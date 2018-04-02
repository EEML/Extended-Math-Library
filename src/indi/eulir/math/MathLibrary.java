package indi.eulir.math;

public class MathLibrary
{
	/**
	 * Return greatest common divisor of the argument
	 *
	 * @param a first parameter
	 * @param b second parameter
	 * @return greatest common divisor of the argument
	 */
	public static int gcd(int a, int b)
	{
		return b == 0 ? a : gcd(b, a % b);
	}
}
