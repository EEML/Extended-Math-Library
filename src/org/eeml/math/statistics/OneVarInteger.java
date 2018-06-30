package org.eeml.math.statistics;

import java.text.MessageFormat;
import java.util.*;

/**
 * This class mainly implements the statistics method: one variable statistics for integer type. To
 * calculate the mean, the mode, or the median of a list of data, statistician may use this class,
 * especially when this group of data is like age in year(whose data should and must use integer
 * type).
 * Maintained by <a href="https://github.com/EEML">EEML</a>. see more on <code>eeml.github.io</code>
 *
 * @author EULIR
 * @see org.eeml.math;
 * @since v1.0.0
 */
class OneVarInteger {
	private ArrayList<Integer> stats;

	private Integer[] temp;

	public OneVarInteger() {
		this(new ArrayList<>());
	}

	public OneVarInteger(ArrayList<Integer> stats) {
		this.stats = stats;
		temp = stats.toArray(temp);
		Arrays.sort(temp);
	}

	public double getMean() {
		return getSum() / getTotality();
	}

	public int getSumSquared() {
		int sumSquared = 0;
		for (int a : stats)
			sumSquared += a * a;
		return sumSquared;
	}

	public double getSampleStandardDeviation() {
		double mean = getMean();
		double sd = 0;
		for (double a : stats)
			sd += (a - mean) * (a - mean);
		return Math.sqrt(sd / getTotality() - 1);
	}

	public double getStandardDeviation() {
		double mean = getMean();
		double sd = 0;
		for (double a : stats)
			sd += (a - mean) * (a - mean);
		return Math.sqrt(sd / getTotality());
	}

	public int getSum() {
		int sum = 0;
		for (int a : stats)
			sum += a;
		return sum;
	}

	public int getTotality() {
		return stats.size();
	}

	public int getMin() {
		return temp[0];
	}

	public int getMax() {
		return temp[temp.length - 1];
	}

	public int getMode() {
		HashSet<Integer> uniqueData = new HashSet<>(stats);
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] count = new int[uniqueData.size()];
		int j = 0;
		for (Integer d : uniqueData) {
			for (Integer integer : stats)
				if (d.equals(integer))
					count[j]++;
			map.put(count[j], d);
			j++;
		}
		int k = 0;
		for (int i : count)
			k = Math.max(k, i);
		return map.get(k);
	}

	public double getMedian() {
		return median(temp);
	}

	public double getQ1() {
		Integer[] arr = new Integer[temp.length / 2];
		System.arraycopy(temp, 0, arr, 0, temp.length / 2);
		return median(arr);
	}

	public double getQ3() {
		Integer[] arr = new Integer[temp.length / 2];
		System.arraycopy(temp, temp.length / 2, arr, 0, temp.length / 2);
		return median(arr);
	}

	@Override
	public String toString() {
		return MessageFormat.format("{0}{1}{2}{3}{4}{5}{6}{7}{8}{9}{10}{11}",
				MessageFormat.format("mean={0}\n", getMean()),
				MessageFormat.format("sum={0}\n", getSum()),
				MessageFormat.format("sum^2={0}\n", getSumSquared()),
				MessageFormat.format("sample SD={0}\n", getSampleStandardDeviation()),
				MessageFormat.format("SD={0}\n", getStandardDeviation()),
				MessageFormat.format("n={0}\n", getTotality()),
				MessageFormat.format("min={0}\n", getMin()),
				MessageFormat.format("max={0}\n", getMax()),
				MessageFormat.format("mode={0}\n", getMode()),
				MessageFormat.format("median={0}\n", getMedian()),
				MessageFormat.format("Q1={0}\n", getQ1()),
				MessageFormat.format("Q3={0}\n", getQ3()));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof OneVarInteger))
			return false;
		OneVarInteger oneVarInteger = (OneVarInteger) obj;
		return Arrays.equals(oneVarInteger.temp, this.temp);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(temp);
	}

	private static double median(Integer[] arr) {
		int len = arr.length;
		if ((len & 1) == 0)
			return (arr[len / 2] + arr[len / 2 - 1]) / 2.0;
		return arr[len >> 2];
	}
}
