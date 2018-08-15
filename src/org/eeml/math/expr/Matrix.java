package org.eeml.math.expr;

public class Matrix {
	private double[][] matrix;

	public Matrix(double[][] matrix) {
		this.matrix = matrix;
	}

	public Matrix(double[] array) {
		double[][] m = new double[1][array.length];
		m[0] = array;
		this.matrix = m;
	}

}
