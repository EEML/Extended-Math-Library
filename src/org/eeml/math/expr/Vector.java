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

	private Vector(ArrayList<Double> list) {
		this.list = list;
	}

	public Vector add(double c) {
		ArrayList<Double> alter = new ArrayList<>();
		for (Double aList : list) {
			alter.add(aList + c);
		}
		return new Vector(alter);
	}

	public Vector add(Vector v) {
		if (v.getDimension() != this.getDimension())
			throw new IllegalArgumentException("dimension mismatch");
		ArrayList<Double> alter = new ArrayList<>();
		for (int i = 0; i < v.getDimension(); i++) {
			alter.add(this.list.get(i) + v.list.get(i));
		}
		return new Vector(alter);
	}

	public Vector subtract(double c) {
		ArrayList<Double> alter = new ArrayList<>();
		for (Double aList : list) {
			alter.add(aList - c);
		}
		return new Vector(alter);
	}

	public Vector subtract(Vector v) {
		if (v.getDimension() != this.getDimension())
			throw new IllegalArgumentException("dimension mismatch");
		ArrayList<Double> alter = new ArrayList<>();
		for (int i = 0; i < v.getDimension(); i++) {
			alter.add(this.list.get(i) - v.list.get(i));
		}
		return new Vector(alter);
	}

	public Vector multiply(double c) {
		ArrayList<Double> alter = new ArrayList<>();
		for (Double aList : list) {
			alter.add(aList * c);
		}
		return new Vector(alter);
	}

	public double multiply(Vector v) {
		if (v.getDimension() != this.getDimension())
			throw new IllegalArgumentException("dimension mismatch");
		double mul = 0;
		for (int i = 0; i < v.getDimension(); i++) {
			mul += v.list.get(i) * this.list.get(i);
		}
		return mul;
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
