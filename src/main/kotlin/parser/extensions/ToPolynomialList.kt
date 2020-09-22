package parser.extensions

import models.Equality
import models.Polynomial
import models.PolynomialTerm
import parser.SignalCodes

fun String.toPolynomialTerm(): PolynomialTerm {

	val numberStr = this.slice(0 until this.indexOf('*'))
	val number = if (numberStr.contains('.')) numberStr.toDouble() else numberStr.toInt()

	val degree = this.slice(this.indexOf('^') + 1 .. this.length).toInt()
	return PolynomialTerm(number, degree)
}

fun toPolynomialList(input: List<String>): Pair<List<PolynomialTerm>, SignalCodes> {
	val output = mutableListOf<PolynomialTerm>()
	var isWasEquality = false

	for (element in input) {
		if (element == "=") {
			isWasEquality = true
			continue
		}
		val term = element.toPolynomialTerm()
		if (isWasEquality)
			term.number = term.number.toDouble() * -1
		output.add(term)
	}
	return Pair(output.toList(), SignalCodes.OK)
}