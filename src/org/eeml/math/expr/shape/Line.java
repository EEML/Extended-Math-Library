package org.eeml.math.expr.shape;

import javax.swing.*;
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

	public void print(int width, int length) {
		Graphics2D graphic = new BufferedImage(400, 400, BufferedImage.TYPE_4BYTE_ABGR).createGraphics();
		graphic.drawLine(0, (int) (-c / b), 400, (int) (-c / b - (400 * a) / b));
		new JFrame("Preview") {{
			setLayout(new BorderLayout());
			add(new JComponent() {
				@Override
				protected void paintComponent(Graphics g) {
					//g.drawImage();
					super.paintComponent(g);
				}
			}, BorderLayout.CENTER);
			pack();
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setResizable(true);
		}}.setVisible(true);
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

	public static void main(String[] args) {
		new Line(1, 2, 3).print();
	}
}
