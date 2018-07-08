package org.eeml.math.statistics.test;

public class ChiSquareTest {
	private double chiSquare;
	private int df;

	private double[][] observed;
	private double[][] expected;

	public ChiSquareTest(double[][] matrix) {
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
		chiSquare = 0.0D;
		for (double aH : h) sum += aH;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				expected[i][j] = h[i] * v[j] / sum;
				chiSquare += (observed[i][j] - expected[i][j]) * (observed[i][j] - expected[i][j]) / expected[i][j];
			}
		}
	}

	public int getDf() {
		return df;
	}

	public double getChiSquare() {
		return chiSquare;
	}

	public double[][] getObserved() {
		return observed;
	}

	public double[][] getExpected() {
		return expected;
	}
}
