package org.eeml.math.expr;

import java.text.MessageFormat;
import java.util.Objects;

public class TwoDVector extends Vector {
	private double x;
	private double y;
	private Coordinate coordinate;

	public TwoDVector(double x, double y) {
		this.x = x;
		this.y = y;
		coordinate = new Coordinate(x, y);
	}

	public TwoDVector add(TwoDVector a) {
		return new TwoDVector(this.x + a.x, this.y + a.y);
	}

	public TwoDVector add(double a) {
		return new TwoDVector(this.x + a, this.y + a);
	}

	public TwoDVector subtract(TwoDVector a) {
		return new TwoDVector(this.x - a.x, this.y - a.y);
	}

	public TwoDVector subtract(double a) {
		return new TwoDVector(this.x - a, this.y - a);
	}

	public double multiply(TwoDVector a) {
		return this.x * a.x + this.y * a.y;
	}

	public TwoDVector multiply(double a) {
		return new TwoDVector(this.x * a, this.y * a);
	}

	public Coordinate getCoordinateFormat() {
		return coordinate;
	}

	@Override
	public String toString() {
		return "(" + MessageFormat.format("{0}", x) + "," + MessageFormat.format("{0}", y) + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TwoDVector))
			return false;
		TwoDVector twoDVector = (TwoDVector) obj;
		return this.x == twoDVector.x && this.y == twoDVector.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
