package org.eeml.math.trigonometric;

import org.eeml.math.MathConstant;

import java.text.MessageFormat;

public class Tan {
	private double degree;  //in degrees
	private double value;

	public Tan(double degree, boolean isDegree) {
		if (isDegree) {
			this.degree = degree;
			value = Math.tan(this.degree * MathConstant.PI / 180);
		} else {
			this.degree = degree * 180 / MathConstant.PI;
			value = Math.tan(this.degree * MathConstant.PI / 180);
		}

	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return MessageFormat.format("tan({0}⁰)={1}", degree, getValue());
	}
}
