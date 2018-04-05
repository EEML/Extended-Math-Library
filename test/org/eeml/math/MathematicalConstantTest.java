package org.eeml.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is the test class of MathematicalConstant class
 * Maintained by EEML. see more on <code>eeml.github.io<code/>
 *
 * @author EULIR
 * @version v1.0.0
 * @coverage 100%
 * @see org.eeml.math
 */
public class MathematicalConstantTest
{
	@Test
	public void testConstant()
	{
		assertEquals(0, MathematicalConstant.ZERO);
		assertEquals(1, MathematicalConstant.UNITY);
		assertEquals(3.141592653589793, MathematicalConstant.PI, 0.0001);
		assertEquals(2.718281828459045, MathematicalConstant.E, 0.0001);
		assertEquals(1.414213562373095, MathematicalConstant.PYTHAGORAS_CONSTANT, 0.0001);
		assertEquals(1.732050807568877, MathematicalConstant.THEODORUS_CONSTANT, 0.0001);
		assertEquals(0.577215664901532, MathematicalConstant.EULER_MASCHERONO_CONSTANT, 0.0001);
		assertEquals(1.618033988749894, MathematicalConstant.GOLDEN_RATIO, 0.0001);
		assertEquals(0.261497212847642, MathematicalConstant.MEISSEL_MERTEBS_CONSTANT, 0.0001);
		assertEquals(0.280169499023869, MathematicalConstant.BERNASTEIN_CONSTANT, 0.0001);
		assertEquals(0.303663002898732, MathematicalConstant.GAUSS_KUZMIN_WIRSING_CONSTANT, 0.0001);
		assertEquals(0.353236371854995, MathematicalConstant.HAFNER_SARNAK_MCCURLEY_CONSTANT, 0.0001);
		assertEquals(0.567143290409783, MathematicalConstant.OMEGA_CONSTANT, 0.0001);
		assertEquals(0.660161815846869, MathematicalConstant.TWIN_PRIME_CONSTANT, 0.0001);
		assertEquals(0.764223653589220, MathematicalConstant.LANDAU_PAMANUJAN_CONSTANT, 0.0001);
		assertEquals(0.915965594177219, MathematicalConstant.CATALAN_CONSTANT, 0.0001);
		assertEquals(1.306377883863080, MathematicalConstant.MILLS_CONSTANT, 0.0001);
		assertEquals(1.324717957244746, MathematicalConstant.PLASTIC_CONSTANT, 0.0001);
		assertEquals(1.451369234883381, MathematicalConstant.RAMANUJAN_SOLDNER_CONSTANT, 0.0001);
		assertEquals(2.502907875095892, MathematicalConstant.FERGENBAUM_CONSTANT, 0.0001);
		assertEquals(3.359885666243177, MathematicalConstant.RECIPROCAL_FIBONACCI_CONSTANT, 0.0001);

		MathematicalConstant mathematicalConstant = new MathematicalConstant();
	}
}