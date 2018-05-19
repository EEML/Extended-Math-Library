package org.eeml.math;

/**
 * This class mainly contains some mathematics methods which can be
 * generally used when solving math problems.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math
 * @since v1.0.0
 */
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

	/**
	 * Return true if the given number is a perfect square.
	 * False otherwise.
	 *
	 * @param a given number
	 * @return true or false
	 */
	public static boolean isSquare(int a)
	{
		int b = (int) Math.sqrt(a);
		return b * b == a;
	}

	/**
	 * Return true if the given number is a perfect square.
	 * False otherwise.
	 *
	 * @param a given number
	 * @return true or false
	 */
	public static boolean isSquare(long a)
	{
		long b = (long) Math.sqrt(a);
		return b * b == a;
	}
}
