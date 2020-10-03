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

	val listPair = toPolynomialList(inputArray)

	if (listPair.second != SignalCodes.OK) return parserError(listPair.second)

	var maxDegree = findMaxDegree(listPair.first)
	if (maxDegree > 2) return parserError(SignalCodes.HIGHER_SECOND_DEGREE)

	val simpledPolynomial = simplifyPolynomial(listPair.first)
	if (simpledPolynomial[2 - maxDegree].number.toDouble() == 0.0)
		maxDegree = findMaxDegree(simpledPolynomial)

	if (simpledPolynomial[0].number == 0 && simpledPolynomial[1].number == 0) {
		return if (simpledPolynomial[2].number == 0)
			parserError(SignalCodes.EVERY_NUMBER_IS_SOLUTION)
		else
			parserError(simpledPolynomial, maxDegree, SignalCodes.NO_SOLUTION)
	}

	return Triple(simpledPolynomial, maxDegree, SignalCodes.OK)
}