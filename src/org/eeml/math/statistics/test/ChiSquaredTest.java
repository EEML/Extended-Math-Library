package org.eeml.math.statistics.test;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Objects;

/**
 * This class mainly implements the statistics test: chi-squared test.
 * A chi-squared test, also written as χ2 test, is any statistical hypothesis test
 * where the sampling distribution of the test statistic is a chi-squared
 * distribution when the null hypothesis is true. Without other qualification,
 * 'chi-squared test' often is used as short for Pearson's chi-squared test.
 * The chi-squared test is used to determine whether there is a significant difference
 * between the expected frequencies and the observed frequencies in one or more
 * categories.
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */
public class ChiSquaredTest {
	private double chiSquared;
	private int df;

	private double[][] observed;
	private double[][] expected;

	/**
	 * @param matrix the observed matrix entered
	 */
	public ChiSquaredTest(double[][] matrix) {
		this.observed = matrix;
		this.df = (matrix.length - 1) * (matrix[0].length - 1);
		double[] h = new double[matrix.length];
		double[] v = new double[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				h[i] += matrix[i][j];
				v[i] += matrix[j][i];
			}
		}
		this.expected = new double[matrix.length][matrix[0].length];
		double sum = 0.0D;
		chiSquared = 0.0D;
		for (double aH : h) sum += aH;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				expected[i][j] = h[i] * v[j] / sum;
				chiSquared += (observed[i][j] - expected[i][j]) * (observed[i][j] - expected[i][j]) / expected[i][j];
			}
		}
	}

	/**
	 * @return degree of freedom
	 */
	public int getDf() {
		return df;
	}

	/**
	 * @return χ2
	 */
	public double getChiSquared() {
		return chiSquared;
	}

	/**
	 * @return observed matrix
	 */
	public double[][] getObserved() {
		return observed;
	}

	/**
	 * @return expected matrix
	 */
	public double[][] getExpected() {
		return expected;
	}


	/**
	 * @return p-value
	 */
	public double getPValue() {
		if (chiSquared < 0 || df < 1) {
			return 0.0;
		}
		double k = ((double) df) * 0.5;
		double v = chiSquared * 0.5;
		if (df == 2) {
			return Math.exp(-1.0 * v);
		}
		double log = log(k, v);
		if (Math.exp(log) <= 1e-8
				|| Double.isNaN(Math.exp(log))
				|| Double.isInfinite(Math.exp(log))) {
			return 1e-14;
		}
		double gamma = Math.log(getApproxGamma(k));
		log -= gamma;
		if (Math.exp(log) > 1) {
			return 1e-14;
		}
		return 1.0 - Math.exp(log);
	}

	/**
	 * Incomplete gamma function
	 * In mathematics, the upper incomplete gamma function and lower incomplete gamma
	 * function are types of special functions, which arise as solutions to various mathematical
	 * problems such as certain integrals.
	 * This is a private method only for calculating p-value use.
	 *
	 * @param n parameter
	 * @return gamma function value
	 */
	private static double getApproxGamma(double n) {
		final double RECIP_E = 0.36787944117144232159552377016147D;
		final double TWOPI = 6.283185307179586476925286766559D;
		double d = 1.0 / (10.0 * n);
		d = 1.0 / ((12 * n) - d);
		d = (d + n) * RECIP_E;
		d = Math.pow(d, n);
		d *= Math.sqrt(TWOPI / n);
		return d;
	}

	/**
	 * log function
	 * This is a private method only for calculating p-value use.
	 *
	 * @param s parameter
	 * @param z parameter
	 * @return log function value
	 */
	private static double log(double s, double z) {
		if (z < 0.0) {
			return 0.0;
		}
		double sc = (Math.log(z) * s) - z - Math.log(s);
		double k = KM(s, z);
		return Math.log(k) + sc;
	}

	/**
	 * Confluent hyper-geometric function
	 * In mathematics, a confluent hyper-geometric function is a solution of a confluent
	 * hyper-geometric equation, which is a degenerate form of a hyper-geometric differential
	 * equation where two of the three regular singularities merge into an irregular singularity.
	 * This is a private method only for calculating p-value use.
	 *
	 * @param s parameter
	 * @param z parameter
	 * @return confluent hyper-geometric function value
	 */
	private static double KM(double s, double z) {
		double sum = 1.0;
		double nom = 1.0;
		double d = 1.0;
		double log_nom = Math.log(nom);
		double log_d = Math.log(d);
		double log_s;
		double log_z = Math.log(z);
		for (int i = 0; i < 1000; ++i) {
			log_nom += log_z;
			s++;
			log_s = Math.log(s);
			log_d += log_s;
			double log_sum = log_nom - log_d;
			sum += Math.exp(log_sum);
		}
		return sum;
	}

	/**
	 * toString method overridden from super class
	 *
	 * @return return String formed in
	 * "df=
	 * χ2=
	 * p="
	 */
	@Override
	public String toString() {
		return MessageFormat.format("df={0}\nχ2={1}\np={2}", getDf(), getChiSquared(), getPValue());
	}

	/**
	 * hashCode method overridden from super class
	 *
	 * @return hashCode of the matrix.
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(observed);
	}

	/**
	 * equals method overridden form super class
	 *
	 * @param obj the compared object
	 * @return true if two observed matrix are equal, otherwise false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof ChiSquaredTest))
			return false;
		ChiSquaredTest chiSquaredTest = (ChiSquaredTest) obj;
		return Arrays.deepEquals(chiSquaredTest.observed, this.observed);
	}
}
