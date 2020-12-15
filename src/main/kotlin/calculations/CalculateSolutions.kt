package calculations

import computor.calculations.sampleSqrt
import computor.globalFlags
import computor.models.Fraction
import computor.parser.Flags
import globalextensions.*
import models.Complex
import models.Discriminant
import models.PolynomialTerm
import kotlin.math.sqrt

private fun calculateComplexArgs(discriminant: Discriminant): Pair<Complex, Complex> {
	val discriminantSqrt = (discriminant.result.toDouble() * -1).sampleSqrt()
	val first = Complex(-discriminant.argB, -discriminantSqrt) / (2 * discriminant.argA)
	val second = Complex(-discriminant.argB, discriminantSqrt) / (2 * discriminant.argA)
	return Pair(first, second)
}

private fun calculateTwoArg(discriminant: Discriminant): Pair<Any, Any> {
	val discriminantSqrt = discriminant.result.toDouble().sampleSqrt()

	lateinit var firstArg: Any
	lateinit var secondArg: Any

	if (globalFlags.contains(Flags.FRACTION)) {
		firstArg = Fraction(-discriminant.argB - discriminantSqrt, 2 * discriminant.argA)
		secondArg = Fraction(-discriminant.argB + discriminantSqrt, 2 * discriminant.argA)
	} else {
		firstArg = ((-discriminant.argB - discriminantSqrt) / (2 * discriminant.argA)).tryCastToInt()
		secondArg = ((-discriminant.argB + discriminantSqrt) / (2 * discriminant.argA)).tryCastToInt()
	}

	return Pair(firstArg, secondArg)
}

private fun calculateOneArg(discriminant: Discriminant): Any =
	if (globalFlags.contains(Flags.FRACTION)) {
		if (discriminant.argA.toDouble() == 0.0) {
			Fraction(-discriminant.argC.toDouble(), discriminant.argB)
		} else {
			Fraction(-discriminant.argB, 2 * discriminant.argA)
		}
	} else {
		(if (discriminant.argA.toDouble() == 0.0)
			-discriminant.argC.toDouble() / discriminant.argB
		else
			-discriminant.argB / (2 * discriminant.argA)
		).tryCastToInt()
	}

fun calculateSolutions(polynomial: List<PolynomialTerm>): Triple<Discriminant, Any, Any?> {
	val discriminant = Discriminant(polynomial)
	return when {
		discriminant.result < 0 -> {
			val complexPair = calculateComplexArgs(discriminant)
			Triple(discriminant, complexPair.first, complexPair.second)
		}
		discriminant.result.compareTo(0) == 0 -> Triple(discriminant, calculateOneArg(discriminant), null)
		else -> {
			val normalPair = calculateTwoArg(discriminant)
			Triple(discriminant, normalPair.first, normalPair.second)
		}
	}
}