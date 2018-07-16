package org.eeml.math;

import static org.junit.Assert.fail;

public class AssertTemplate {
	public static void assertThrows(Class<? extends Throwable> clazz, Runnable function) {
		try {
			function.run();
		} catch (Throwable e) {
			if (e.getClass() == clazz)
				System.out.println("Successfully thrown " + e.getClass().getSimpleName() + ", message: " + e.getMessage());
			else fail("Error: expected: " + clazz.getSimpleName() + ", get: " + e.getClass().getSimpleName());
			return;
		}
		fail("No exceptions thrown!");
	}

	public static void assert2DArrayEquals(double[][] arr1, double[][] arr2) {
		if (arr1.length != arr2.length || arr1[0].length != arr2[0].length)
			fail("Arrays of different sizes!");
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				if (Math.abs(arr1[i][j] - arr2[i][j]) > 0.001)
					fail("Arrays not equals");
			}
		}
	}
}
