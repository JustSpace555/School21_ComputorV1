package parser.extensions

import globalextensions.times
import models.PolynomialTerm
import parser.SignalCodes

fun toPolynomialList(input: List<String>): Pair<List<PolynomialTerm>, SignalCodes> {
	val output = mutableListOf<PolynomialTerm>()
	var isWasEquality = false

	for (element in input) {
		if (element == "=") {
			isWasEquality = true
			continue
		}
		val term = toPolynomialTerm(element)
		if (term.second != SignalCodes.OK)
			return Pair(output, term.second)

		if (isWasEquality)
			term.first.number *= -1
		output.add(term.first)
	}
	return Pair(output.toList(), SignalCodes.OK)
}