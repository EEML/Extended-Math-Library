package org.eeml.math.statistics;

import org.eeml.math.exception.InvalidDimException;

import java.util.ArrayList;

public class TwoVar {
	private ArrayList<Double> list1;
	private ArrayList<Double> list2;

	private OneVar statList1;
	private OneVar statList2;

	public TwoVar(ArrayList<Double> x, ArrayList<Double> y) throws Throwable {
		this.list1 = x;
		this.list2 = y;
		statList1 = new OneVar(x);
		statList2 = new OneVar(y);
		if (statList1.getTotality() != statList2.getTotality()) {
			statList1 = null;
			statList2 = null;
			throw new InvalidDimException("Dim mismatch");
		}
	}

	public double getXMean() {
		return statList1.getMean();
	}

	public double getXSum() {
		return statList1.getSum();
	}

	public double getXSumSquared() {
		return statList1.getSumSquared();
	}

	public double getXSampleStandardDeviation() {
		return statList1.getSampleStandardDeviation();
	}

	public double getXStandardDeviation() {
		return statList1.getStandardDeviation();
	}

	public double getMinX() {
		return statList1.getMin();
	}

	public double getMaxX() {
		return statList1.getMax();
	}

	public double getYMean() {
		return statList2.getMean();
	}

	public double getYSum() {
		return statList2.getSum();
	}

	public double getYSumSquared() {
		return statList2.getSumSquared();
	}

	public double getYSampleStandardDeviation() {
		return statList2.getSampleStandardDeviation();
	}

	public double getYStandardDeviation() {
		return statList2.getStandardDeviation();
	}

	public double getMinY() {
		return statList2.getMin();
	}

	public double getMaxY() {
		return statList2.getMax();
	}

	public int getTotality() {
		return statList1.getTotality();
	}
}
