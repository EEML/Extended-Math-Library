package org.eeml.math.statistics;

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
}
