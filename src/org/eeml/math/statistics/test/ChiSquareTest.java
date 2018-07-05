package org.eeml.math.statistics.test;

public class ChiSquareTest {
	private double chiSquare;
	private int df;

	private double[][] observed;
	private double[][] expected;

	public ChiSquareTest(double[][] matrix) {
		this.observed = matrix;
		this.df = (matrix.length - 1) * (matrix[0].length - 1);

	}

	public int getDf() {
		return df;
	}

	public double getChiSquare() {
		return chiSquare;
	}

	public double[][] getExpected() {
		return expected;
	}
}
