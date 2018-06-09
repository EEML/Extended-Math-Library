package org.eeml.math.statistics;

import java.util.ArrayList;
import java.util.Arrays;

public class OneVar
{
	private ArrayList<Double> stats;

	private double mean;
	private double sum;
	private double sumSquared;
	private double sampleStandardDeviation;
	private double standardDeviation;
	private int totality;
	private double min;
	private double max;
	private double mode;
	private double median;

	private Double[] temp;

	public OneVar()
	{
		this(new ArrayList<>());
	}

	public OneVar(ArrayList<Double> stats)
	{
		this.stats = stats;
		for (double d : this.stats)
		{
			sum += d;
			sumSquared += d * d;
		}
		totality = this.stats.size();
		mean = sum / totality;
		sampleStandardDeviation = sumSquared / (totality - 1);
		standardDeviation = sumSquared / totality;
		temp = stats.toArray(temp);
		Arrays.sort(temp);
	}

	public double getMean()
	{
		return mean;
	}

	public double getSumSqared()
	{
		return sumSquared;
	}

	public double getSampleStandardDeviation()
	{
		return sampleStandardDeviation;
	}

	public double getStandardDeviation()
	{
		return standardDeviation;
	}

	public double getSum()
	{
		return sum;
	}

	public int getTotality()
	{
		return totality;
	}

	public double getMin()
	{
		return min = temp[0];
	}

	public double getMax()
	{
		return max = temp[temp.length - 1];
	}

	public double getMode()
	{
		return mode;
	}

	public double getMedian()
	{
		return median;
	}
}
