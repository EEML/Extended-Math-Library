package org.eeml.math.expr;

public class TwoDVector {
	private double x;
	private double y;

	public TwoDVector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public TwoDVector add(TwoDVector a) {
		return new TwoDVector(this.x + a.x, this.y + a.y);
	}

	public TwoDVector subtract(TwoDVector a) {
		return new TwoDVector(this.x - a.x, this.y - a.y);
	}

	public double multiply(TwoDVector a) {
		return this.x * a.y + this.y * a.x;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
