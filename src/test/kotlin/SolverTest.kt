import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import parser.SignalCodes
import parser.parser
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class SolverTest {

	private val out = ByteArrayOutputStream()
	private val originalOut = System.out

	@Before
	fun setUpStream() {
		System.setOut(PrintStream(out))
	}

	@After
	fun restoreStream() {
		System.setOut(originalOut)
	}

	@Test
	fun testLinearEquationSolver() {
		val inputs: Array<Array<String>> = arrayOf(
			arrayOf("", "Reduced form: 0 = 0\nPolynomial degree: 0\nEvery value for x is a solution\n"),
			arrayOf("0.0 = 0.0", "Reduced form: 0 = 0\nPolynomial degree: 0\nEvery value for x is a solution\n"),
			arrayOf("00 = 0*1", "Reduced form: 0 = 0\nPolynomial degree: 0\nEvery value for x is a solution\n"),
			arrayOf("00 = 0*0", "Reduced form: 0 = 0\nPolynomial degree: 0\nEvery value for x is a solution\n"),
			arrayOf(
				"1",
				"Reduced form: 1 * X^0 = 0\nPolynomial degree: 0\nThere is no solution because the equation is inconsistent\n"
			),
			arrayOf("1*1 + x = 1 + x", "Reduced form: 0 = 0\nPolynomial degree: 0\nEvery value for x is a solution\n"),
			arrayOf("5 * X^2 = 5 * X^2", "Reduced form: 0 = 0\nPolynomial degree: 0\nEvery value for x is a solution\n"),
			arrayOf("1 + x", "Reduced form: 1 * X^1 + 1 * X^0 = 0\nPolynomial degree: 1\nThe solution is: -1.0\n"),
			arrayOf("2 * 1 * x ^ 1 = 3", "Reduced form: 2 * X^1 - 3 * X^0 = 0\nPolynomial degree: 1\nThe solution is: 1.5\n"),
			arrayOf("-2 * x ^ 1 = 3", "Reduced form: -2 * X^1 - 3 * X^0 = 0\nPolynomial degree: 1\nThe solution is: -1.5\n"),
			arrayOf("2.0 * x ^ 1 = -3.0", "Reduced form: 2 * X^1 + 3 * X^0 = 0\nPolynomial degree: 1\nThe solution is: -1.5\n"),
			arrayOf(
				"5 = 2*2 + 7 * x",
				"Reduced form: -7 * X^1 + 1 * X^0 = 0\nPolynomial degree: 1\nThe solution is: 0.14285714285714285\n"
			),
			arrayOf("-1 + x + 2*1 = 2 - 1 + x", "Reduced form: 0 = 0\nPolynomial degree: 0\nEvery value for x is a solution\n"),
			arrayOf(
				"1*1 + x = -1*1 + x",
				"Reduced form: 2 * X^0 = 0\nPolynomial degree: 0\nThere is no solution because the equation is inconsistent\n"
			)
		)
		testInputs(inputs)
	}

	@Test
	fun testQuadraticEquationSolver() {
		val inputs: Array<Array<String>> = arrayOf(
			arrayOf("x ^ 2 + 0 = 0", "Reduced form: 1 * X^2 = 0\nPolynomial degree: 2\nDiscriminant: 0.0\nThe solution is: 0.0\n"),
			arrayOf(
				"5 * 10 * 0.1 * X^0 + 13 * 1.0 * X^1 + 3 * X^2 = 1 * X^0 + 1 * X^1",
				"Reduced form: 3 * X^2 + 12 * X^1 + 4 * X^0 = 0\nPolynomial degree: 2\nDiscriminant: 96.0\nThe two solutions are:\n-3.632993161855452\n-0.3670068381445481\n"
			),
			arrayOf(
				"x^2 - 15 * X + 56 = 0",
				"Reduced form: 1 * X^2 - 15 * X^1 + 56 * X^0 = 0\nPolynomial degree: 2\nDiscriminant: 1.0\nThe two solutions are:\n7.0\n8.0\n"
			),
			arrayOf(
				"x2 - 15 * X1 + 56 = 0",
				"Reduced form: 1 * X^2 - 15 * X^1 + 56 * X^0 = 0\nPolynomial degree: 2\nDiscriminant: 1.0\nThe two solutions are:\n7.0\n8.0\n"
			),
			arrayOf(
				"+2 * X^2 + 7 * X + 4",
				"Reduced form: 2 * X^2 + 7 * X^1 + 4 * X^0 = 0\nPolynomial degree: 2\nDiscriminant: 17.0\nThe two solutions are:\n-2.7807764064044154\n-0.7192235935955849\n"
			),
			arrayOf(
				"5.0 * -2 * -0.5 * X^0 + 3 * X^1 + 3 * X^2 = 1 * X^0 + 0 * X^1",
				"Reduced form: 3 * X^2 + 3 * X^1 + 4 * X^0 = 0\nPolynomial degree: 2\nDiscriminant: -39.0\nThe two solutions are:\n-0.5 - 1.0408329997330663i\n-0.5 + 1.0408329997330663i\n"
			),
			arrayOf(
				"5.0 * -2 * -0.5 * X0 + 3 * X1 + 3 * X2 = 1 * X0 + 0 * X1",
				"Reduced form: 3 * X^2 + 3 * X^1 + 4 * X^0 = 0\nPolynomial degree: 2\nDiscriminant: -39.0\nThe two solutions are:\n-0.5 - 1.0408329997330663i\n-0.5 + 1.0408329997330663i\n"
			)
		)
		testInputs(inputs)
	}

	/*
	@Test
	fun testCubicEquationSolver() {
		val inputs: Array<Array<String>> = arrayOf(
			arrayOf(
				"2*x3 - 4*x2 - 22*x + 24",
				"Reduced form: 2 * X^3 - 4 * X^2 - 22 * X^1 + 24 * X^0 = 0\nPolynomial degree: 3\nThe solutions are:\n3.9999999999999996\n-2.999999999999999\n0.9999999999999996\n"
			),
			arrayOf(
				"3*x3 - 10*x2 + 14*x + 27",
				"Reduced form: 3 * X^3 - 10 * X^2 + 14 * X^1 + 27 * X^0 = 0\nPolynomial degree: 3\nThe solutions are:\n-0.9999999999999933\n2.1666666666666634 + 2.0749832663314605i\n2.1666666666666634 - 2.0749832663314605i\n"
			),
			arrayOf(
				"x3 + 6*x2 + 12*x + 8",
				"Reduced form: 1 * X^3 + 6 * X^2 + 12 * X^1 + 8 * X^0 = 0\nPolynomial degree: 3\nThe solution is: -2.0\n"
			),
			arrayOf(
				"1 * X^3 + 2 * X^2 + 1 * X^1 - 4 * X^0 = 0",
				"Reduced form: 1 * X^3 + 2 * X^2 + 1 * X^1 - 4 * X^0 = 0\nPolynomial degree: 3\nThe solutions are:\n1.000000000000003\n-1.5000000000000016 + 1.3228756555322925i\n-1.5000000000000016 - 1.3228756555322925i\n"
			)
		)
		testInputs(inputs)
	}
	*/

//	@Test
//	fun testGreaterThanCubicEquation() {
//		val inputs: Array<Array<String>> = arrayOf(
//			arrayOf(
//				"x ^ 4 = -1.1",
//				"Reduced form: 1 * X^4 + 1.1 * X^0 = 0\nPolynomial degree: 4\nThe Polynomial degree is strictly greater than 3, I can't solve\n"
//			),
//			arrayOf(
//				"x ^ 99999999",
//				"Reduced form: 1 * X^99999999 = 0\nPolynomial degree: 99999999\nThe Polynomial degree is strictly greater than 3, I can't solve\n"
//			)
//		)
//		testInputs(inputs)
//	}

	private fun testInputs(inputs: Array<Array<String>>) {
		for (input in inputs) {
			if (input.size != 2) continue
			out.reset()

			val polynomial = parser(input[0])
			if (polynomial.third != SignalCodes.OK)
				throw Exception("Test fail on: ${input[0]} with ${polynomial.third}\n")

			solver(polynomial)
			assertEquals(input[1], out.toString())
		}
	}
}