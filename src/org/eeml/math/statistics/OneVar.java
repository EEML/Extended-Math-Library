package org.eeml.math.statistics;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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
	private double Q1;
	private double Q3;

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
		sampleStandardDeviation = Math.sqrt(sumSquared / (totality - 1));
		standardDeviation = Math.sqrt(sumSquared / totality);
		temp = stats.toArray(temp);
		Arrays.sort(temp);
	}

	public double getMean()
	{
		return mean;
	}

	public double getSumSquared()
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
		min = temp[0];
		return min;
	}

	public double getMax()
	{
		max = temp[temp.length - 1];
		return max;
	}

	public double getMode()
	{
		HashSet<Double> uniqueData = new HashSet<>(stats);
		HashMap<Integer, Double> map = new HashMap<>();
		int[] count = new int[uniqueData.size()];
		int j = 0;
		for (Double d : uniqueData)
		{
			for (Double double2 : stats)
				if (d.equals(double2))
					count[j]++;
			map.put(count[j], d);
			j++;
		}
		int k = 0;
		for (int i : count)
			k = Math.max(k, i);
		mode = map.get(k);
		return mode;
	}

	public double getMedian()
	{
		int len = temp.length;
		if (len % 2 == 0)
			return (temp[len / 2] + temp[len / 2 + 1]) / 2;
		median = temp[len / 2];
		return median;
	}

	public double getQ1()
	{
		return Q1;
	}

	public double getQ3()
	{
		return Q3;
	}

	@Override
	public String toString()
	{
		return MessageFormat.format("mean={0}\n", getMean()) +
				MessageFormat.format("sum={0}\n", getSum()) +
				MessageFormat.format("sum^2={0}\n", getSumSquared()) +
				MessageFormat.format("sample SD={0}\n", getSampleStandardDeviation()) +
				MessageFormat.format("SD={0}\n", getStandardDeviation()) +
				MessageFormat.format("n={0}\n", getTotality()) +
				MessageFormat.format("min={0}\n", getMin()) +
				MessageFormat.format("max={0}\n", getMax()) +
				MessageFormat.format("mode={0}\n", getMode()) +
				MessageFormat.format("median={0}\n", getMedian()) +
				MessageFormat.format("Q1={0}\n", getQ1()) +
				MessageFormat.format("Q3={0}\n", getQ3());
	}

}
