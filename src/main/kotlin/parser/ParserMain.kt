package parser

import models.PolynomialTerm
import parser.extensions.findMaxDegree
import parser.extensions.putSpaces
import parser.extensions.simplifyPolynomial
import parser.extensions.toPolynomialList

private fun parserError(signal: SignalCodes) = Triple(listOf<PolynomialTerm>(), -1, signal)

fun parser(input: String): Triple<List<PolynomialTerm>, Int, SignalCodes> {
	val inputArray: List<String> = putSpaces(input).split(' ')

	if (!inputArray.contains("=") || inputArray.lastIndexOf("=") != inputArray.indexOf("="))
		return parserError(SignalCodes.WRONG_AMOUNT_EQUAL_SIGNS)

	val listPair = toPolynomialList(inputArray)

	if (listPair.second != SignalCodes.OK) return parserError(listPair.second)

	val maxDegree = findMaxDegree(listPair.first)
	if (maxDegree > 2) return parserError(SignalCodes.HIGHER_SECOND_DEGREE)
	val simpledPolynomial = simplifyPolynomial(listPair.first)

	if (simpledPolynomial[1].number == 0 && simpledPolynomial[2].number == 0) {
		return if (simpledPolynomial[0].number == 0)
			parserError(SignalCodes.EVERY_NUMBER_IS_SOLUTION)
		else
			parserError(SignalCodes.NO_SOLUTION)
	}

	return Triple(simpledPolynomial, maxDegree, SignalCodes.OK)
}