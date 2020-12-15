package parser.extensions

import globalextensions.times
import models.PolynomialTerm

fun toPolynomialList(input: List<String>): List<PolynomialTerm> {
	val output = mutableListOf<PolynomialTerm>()
	var isWasEquality = false

	for (element in input) {
		if (element == "=") {
			isWasEquality = true
			continue
		}

		val term = toPolynomialTerm(element)
		if (isWasEquality)
			term.number *= -1

		output.add(term)
	}
	return output.toList()
}