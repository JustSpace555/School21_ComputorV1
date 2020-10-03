package calculations

import globalextensions.*
import models.Discriminant
import models.PolynomialTerm
import kotlin.math.sqrt

private fun calculateTwoArg(discriminant: Discriminant, func: (Double) -> Double): Number {
	val res = (-discriminant.argB + func(sqrt(discriminant.result.toDouble()))) / (2 * discriminant.argA)
	if (res.toDouble() - res.toInt() == 0.0)
		return res.toInt()
	return res.toDouble()
}

private fun calculateOneArg(discriminant: Discriminant): Number {
	val res = if (discriminant.argA.toDouble() == 0.0)
		-discriminant.argC.toDouble() / discriminant.argB
	else
		-discriminant.argB / (2 * discriminant.argA)
	if (res.toDouble() - res.toInt() == 0.0)
		return res.toInt()
	return res.toDouble()
}

fun calculateSolutions(polynomial: List<PolynomialTerm>): Triple<Discriminant, Number?, Number?> {
	val discriminant = Discriminant(polynomial)
	return when {
		discriminant.result < 0 -> Triple(discriminant, null, null)
		discriminant.result.toDouble() == 0.0 -> Triple(discriminant, calculateOneArg(discriminant), null)
		else ->
			Triple(
					discriminant,
					calculateTwoArg(discriminant, Double::unaryMinus), calculateTwoArg(discriminant, Double::unaryPlus)
			)
	}
}