package org.eeml.math.expr.shape;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.MessageFormat;

public class Line {
	private double a;
	private double b;
	private double c;

	public Line(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void print() {
		Graphics2D graphic = new BufferedImage(400, 400, BufferedImage.TYPE_4BYTE_ABGR).createGraphics();
		graphic.drawLine(0, (int) (-c / b), 400, (int) (-c / b - (400 * a) / b));
	}

	@Override
	public String toString() {
		if (this.a == 1)
			if (this.b == 0)
				return MessageFormat.format("x={0}\tx={1}", this.c, 0);
			else
				return MessageFormat.format("x" + (this.b < 0 ? "" : "+") + "{0}={1}\tx={2}", this.b, this.c, 0);
		else if (this.a == -1)
			if (this.b == 0)
				return MessageFormat.format("-x={0}\tx={1}", this.c, 0);
			else
				return MessageFormat.format("-x" + (this.b < 0 ? "" : "+") + "{0}={1}\tx={2}", this.b, this.c, 0);
		else if (this.b == 0)
			return MessageFormat.format("{0}x={1}\tx={2}", this.a, this.c, 0);
		else
			return MessageFormat.format("{0}x" + (this.b < 0 ? "" : "+") + "{1}={2}\tx={3}", this.a, this.b, this.c, 0);
	}
}
