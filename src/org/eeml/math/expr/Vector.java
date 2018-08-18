package org.eeml.math.expr;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Vector {
	private ArrayList<Double> list;

	public Vector(Double... arguments) {
		list = new ArrayList<>();
		list.addAll(Arrays.asList(arguments));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (int i = 0; i < list.size() - 1; i++) {
			sb.append(MessageFormat.format("{0},", list.get(i)));
		}
		sb.append(MessageFormat.format("{0})", list.get(list.size() - 1)));
		return sb.toString();
	}
}
