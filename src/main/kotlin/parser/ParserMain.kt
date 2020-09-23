package parser

import models.EmptyPolynomial
import models.FullPolynomial
import models.Polynomial
import models.PolynomialTerm
import parser.extensions.findMaxDegree
import parser.extensions.putSpaces
import parser.extensions.simplifyPolynomial
import parser.extensions.toPolynomialList

private fun parserError(signal: SignalCodes) = Pair(EmptyPolynomial(), signal)

fun parser(input: String): Pair<Polynomial, SignalCodes> {
	val inputArray: List<String> = putSpaces(input).split(' ')
	val listPair = toPolynomialList(inputArray)

	if (listPair.second != SignalCodes.OK) return parserError(listPair.second)

	val maxDegree = findMaxDegree(listPair.first)
	if (maxDegree > 2) return parserError(SignalCodes.HIGHER_SECOND_DEGREE)
	val simpledPolynomial = simplifyPolynomial(listPair.first)
	return Pair(FullPolynomial(simpledPolynomial, maxDegree), SignalCodes.OK)
}