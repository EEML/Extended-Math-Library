package org.eeml.math.statistics;

import org.eeml.math.exception.InvalidDimException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.eeml.math.AssertTemplate.assertThrows;
import static org.junit.Assert.assertEquals;

public class TwoVarTest {
	TwoVar twoVar1;
	TwoVar twoVar2;

	private void init() {
		ArrayList<Double> list1 = new ArrayList<>(Arrays.asList(3.2D, 4D, 8D, 8.3D, 9D, 1D, 6.5D, 1D, 3D));
		ArrayList<Double> list2 = new ArrayList<>(Arrays.asList(38.37D, 26.3D, 16.9D, 38.28D, 1.16D, 4.35D, 40.2D, 15.23D, 36.6D));
		twoVar1 = new TwoVar(list1, list2);
	}

	@Test
	public void testThrows() {
		ArrayList<Double> list1 = new ArrayList<>(Arrays.asList(3.2D, 4D, 8D, 8.3D, 9D, 1D, 6.5D, 1D, 3D, 4D, 1D, 3.2D));
		ArrayList<Double> list2 = new ArrayList<>(Arrays.asList(38.37D, 26.3D, 16.9D, 38.28D, 1.16D, 4.35D, 40.2D, 15.23D, 36.6D));
		assertThrows(InvalidDimException.class, () -> new TwoVar(list1, list2));
	}

	@Test
	public void testGetMean() {
		init();
		assertEquals(4.35, twoVar1.getYMean(), 0.001);
	}

	@Test
	public void testGetSum() {
		init();
		assertEquals(52.2, twoVar1.getYSum(), 0.001);
	}

	@Test
	public void testGetSumSquared() {
		init();
		assertEquals(320.62, twoVar1.getYSumSquared(), 0.001);
	}

	@Test
	public void testGetSampleStandardDeviation() {
		init();
		assertEquals(2.9162, twoVar1.getYSampleStandardDeviation(), 0.001);
	}

	@Test
	public void testGetStandardDeviation() {
		init();
		assertEquals(2.7921, twoVar1.getYStandardDeviation(), 0.001);
	}

	@Test
	public void testGetTotality() {
		init();
		assertEquals(12, twoVar1.getTotility());
	}

	@Test
	public void testGetMin() {
		init();
		assertEquals(1, twoVar1.getMinY(), 0.001);
	}

	@Test
	public void testGetMax() {
		init();
		assertEquals(9, twoVar1.getMaxY(), 0.001);
	}
}
