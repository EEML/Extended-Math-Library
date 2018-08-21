package org.eeml.math.expr;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Vector {
	private ArrayList<Double> list;

	public Vector(Double... arguments) {
		list = new ArrayList<>();
		list.addAll(Arrays.asList(arguments));
	}

	public int getDimension() {
		return list.size();
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

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Vector))
			return false;
		Vector vector = (Vector) obj;
		return list.equals(vector.list);
	}

	@Override
	public int hashCode() {
		return Objects.hash(list);
	}
}
