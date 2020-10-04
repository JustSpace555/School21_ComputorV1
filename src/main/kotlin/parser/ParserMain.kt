package parser

import models.PolynomialTerm
import parser.extensions.findMaxDegree
import parser.extensions.putSpaces
import parser.extensions.simplifyPolynomial
import parser.extensions.toPolynomialList

private fun parserError(signal: SignalCodes) = Triple(listOf<PolynomialTerm>(), 0, signal)
private fun parserError(polynomial: List<PolynomialTerm>, degree: Int, signal: SignalCodes) =
		Triple(polynomial, degree, signal)

fun parser(input: String): Triple<List<PolynomialTerm>, Int, SignalCodes> {
	val inputArray: List<String> = putSpaces(input).split(' ').filter { it.isNotEmpty() && it.isNotBlank() }

	if (inputArray.lastIndexOf("=") != inputArray.indexOf("="))
		return parserError(SignalCodes.WRONG_AMOUNT_EQUAL_SIGNS)

	val listPair = toPolynomialList(inputArray).also {
		if (it.second != SignalCodes.OK) return parserError(it.second)
	}

	var maxDegree = findMaxDegree(listPair.first).also {
		if (it > 2) return parserError(SignalCodes.HIGHER_SECOND_DEGREE)
	}

	val simpledPolynomial = simplifyPolynomial(listPair.first).also {
		if (it[2 - maxDegree].number.toDouble() == 0.0)
			maxDegree = findMaxDegree(it)

		if (it[0].number == 0 && it[1].number == 0) {
			return if (it[2].number == 0)
				parserError(SignalCodes.EVERY_NUMBER_IS_SOLUTION)
			else
				parserError(it, maxDegree, SignalCodes.NO_SOLUTION)
		}
	}

	return Triple(simpledPolynomial, maxDegree, SignalCodes.OK)
}