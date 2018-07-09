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
	 * toString method overridden from super class
	 *
	 * @return return String formed in
	 * "df=
	 * χ2="
	 */
	@Override
	public String toString() {
		return MessageFormat.format("df={0}\nχ2={1}", getDf(), getChiSquared());
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
	public boolean equals(Object obj){
		if (obj == this)
			return true;
		if (!(obj instanceof ChiSquaredTest))
			return false;
		ChiSquaredTest chiSquaredTest = (ChiSquaredTest) obj;
		return Arrays.deepEquals(chiSquaredTest.observed, this.observed);
	}
}
