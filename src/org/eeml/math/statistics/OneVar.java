package org.eeml.math.statistics;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class OneVar
{
	private ArrayList<Double> stats;

	private Double[] temp;

	public OneVar()
	{
		this(new ArrayList<>());
	}

	public OneVar(ArrayList<Double> stats)
	{
		this.stats = stats;
		temp = stats.toArray(temp);
		Arrays.sort(temp);
	}

	public double getMean()
	{
		return getSum() / getTotality();
	}

	public double getSumSquared()
	{
		double sumSquared = 0;
		for (double a : stats)
			sumSquared += a;
		return sumSquared;
	}

	public double getSampleStandardDeviation()
	{
		return getStandardDeviation() * getTotality() / (getTotality() - 1);
	}

	public double getStandardDeviation()
	{
		double mean = getMean();
		double sd = 0;
		for (double a : stats)
			sd += (a - mean) * (a - mean);
		return sd / getTotality();
	}

	public double getSum()
	{
		double sum = 0;
		for (double a : stats)
			sum += a;
		return sum;
	}

	public int getTotality()
	{
		return stats.size();
	}

	public double getMin()
	{
		return temp[0];
	}

	public double getMax()
	{
		return temp[temp.length - 1];
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
		return map.get(k);
	}

	public double getMedian()
	{
		int len = temp.length;
		if (len % 2 == 0)
			return (temp[len >> 2] + temp[len >> 2 + 1]) / 2;
		return temp[len >> 2];
	}

	public double getQ1()
	{
		return 0;
	}

	public double getQ3()
	{
		return 0;
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
