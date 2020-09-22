package parser

import models.PolynomialTerm
import parser.extensions.findMaxDegree
import parser.extensions.putSpaces
import parser.extensions.toPolynomialList

private fun parserError(signal: SignalCodes) = Triple(listOf<PolynomialTerm>(), -1, signal)

fun parser(input: String): Triple<List<PolynomialTerm>, Int, SignalCodes> {
	val inputArray: List<String> = putSpaces(input).split(' ')
	val listPair = toPolynomialList(inputArray)

	if (listPair.second != SignalCodes.OK) return parserError(listPair.second)

	val maxDegree = findMaxDegree(listPair.first)
	if (maxDegree > 2) return parserError(SignalCodes.HIGHER_SECOND_DEGREE)
}