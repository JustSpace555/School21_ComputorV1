package calculations

import globalextensions.*
import models.Discriminant
import kotlin.math.sqrt

private fun calculateTwoArg(discriminant: Discriminant, func: (Double) -> Double): Number =
	(-discriminant.argB + func(sqrt(discriminant.result.toDouble()))) / (2 * discriminant.argA)

private fun calculateOneArg(discriminant: Discriminant): Number =
	-discriminant.argB / (2 * discriminant.argA)

fun calculateSolutions(discriminant: Discriminant): List<Number> =
	when {
		discriminant.result > 0 -> listOf(
			calculateTwoArg(discriminant, Double::unaryMinus), calculateTwoArg(discriminant, Double::unaryPlus)
		)
		discriminant.result == 0.0 -> listOf(calculateOneArg(discriminant))
		else -> listOf()
	}