package org.eeml.math.statistics;

import org.jetbrains.annotations.Contract;

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

	/**
	 * default constructor
	 */
	public OneVarInteger() {
		this(new ArrayList<>());
	}

	/**
	 * constructor
	 *
	 * @param stats data list
	 */
	public OneVarInteger(ArrayList<Integer> stats) {
		this.stats = stats;
		temp = stats.toArray(new Integer[0]);
		Arrays.sort(temp);
	}

	/**
	 * @return mean
	 */
	public double getMean() {
		return (double) getSum() / getTotality();
	}

	/**
	 * @return squared sum
	 */
	public int getSumSquared() {
		int sumSquared = 0;
		for (int a : stats)
			sumSquared += a * a;
		return sumSquared;
	}

	/**
	 * @return sample standard deviation
	 */
	public double getSampleStandardDeviation() {
		double mean = getMean();
		double sd = 0;
		for (double a : stats)
			sd += (a - mean) * (a - mean);
		return Math.sqrt(sd / (getTotality() - 1));
	}

	/**
	 * @return standard deviation
	 */
	public double getStandardDeviation() {
		double mean = getMean();
		double sd = 0;
		for (double a : stats)
			sd += (a - mean) * (a - mean);
		return Math.sqrt(sd / getTotality());
	}

	/**
	 * @return sum
	 */
	public int getSum() {
		int sum = 0;
		for (int a : stats)
			sum += a;
		return sum;
	}

	/**
	 * @return totality
	 */
	public int getTotality() {
		return stats.size();
	}

	/**
	 * @return min
	 */
	public int getMin() {
		return temp[0];
	}

	/**
	 * @return max
	 */
	public int getMax() {
		return temp[temp.length - 1];
	}

	/**
	 * To judge whether the list of data has mode.
	 * When there is at least one number appears at least twice in the list, it has mode.
	 *
	 * @return True if the data has mode, false otherwise.
	 */
	public boolean hasMode() {
		HashSet<Integer> set = new HashSet<>(stats);
		return set.size() != stats.size();
	}

	/**
	 * Mode of the list of data.
	 * If and only if the data has mode can it calculate mode(When there is at least
	 * one number appears at least twice in the list, it has mode). Therefore, the method
	 * {@code hasMode} should almost always be called before calling method {@code getMode}.
	 *
	 * @return mode
	 * @throws IllegalArgumentException when the list of data has no mode.
	 */
	public int getMode() {
		if (!hasMode())
			throw new IllegalArgumentException("This list of data has no mode.");
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

	/**
	 * @return median
	 */
	public double getMedian() {
		return median(temp);
	}

	/**
	 * @return Q1
	 */
	public double getQ1() {
		Integer[] arr = new Integer[temp.length / 2];
		System.arraycopy(temp, 0, arr, 0, temp.length / 2);
		return median(arr);
	}

	/**
	 * @return Q3
	 */
	public double getQ3() {
		Integer[] arr = new Integer[temp.length / 2];
		System.arraycopy(temp, (temp.length & 1) == 0 ? temp.length / 2 : temp.length / 2 + 1, arr, 0, temp.length / 2);
		return median(arr);
	}

	/**
	 * toString method overridden from super class
	 *
	 * @return return String formed in
	 * "mean=
	 * sum=
	 * sum^2
	 * sample SD=
	 * SD=
	 * min=
	 * max=
	 * mode=
	 * median=
	 * Q1=
	 * Q3="
	 */
	@Override
	public String toString() {
		return MessageFormat.format("{0}{1}{2}{3}{4}{5}{6}{7}" + (hasMode() ? "{8}" : "") + "{9}{10}{11}",
				MessageFormat.format("mean={0}\n", getMean()),
				MessageFormat.format("sum={0}\n", getSum()),
				MessageFormat.format("sum^2={0}\n", getSumSquared()),
				MessageFormat.format("sample SD={0}\n", getSampleStandardDeviation()),
				MessageFormat.format("SD={0}\n", getStandardDeviation()),
				MessageFormat.format("n={0}\n", getTotality()),
				MessageFormat.format("min={0}\n", getMin()),
				MessageFormat.format("max={0}\n", getMax()),
				MessageFormat.format("mode={0}\n", hasMode() ? getMode() : ""),
				MessageFormat.format("median={0}\n", getMedian()),
				MessageFormat.format("Q1={0}\n", getQ1()),
				MessageFormat.format("Q3={0}", getQ3()));
	}

	/**
	 * equals method overridden form super class
	 *
	 * @param obj the compared object
	 * @return true if two lists of data are equal in no particular order,
	 * otherwise false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof OneVarInteger))
			return false;
		OneVarInteger oneVarInteger = (OneVarInteger) obj;
		return Arrays.equals(oneVarInteger.temp, this.temp);
	}

	/**
	 * hashCode method overridden from super class
	 *
	 * @return hashCode of the data.
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(temp);
	}

	/**
	 * median for any array
	 *
	 * @param arr any number array
	 * @return median
	 */
	@Contract(pure = true)
	private static double median(Integer[] arr) {
		int len = arr.length;
		if ((len & 1) == 0)
			return (arr[len >> 1] + arr[(len >> 1) - 1]) / 2.0;
		return arr[len >> 1];
	}
}
