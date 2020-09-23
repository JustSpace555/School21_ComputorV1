package parser.extensions

import models.PolynomialTerm
import parser.SignalCodes
import java.lang.NumberFormatException

private fun String.toPolynomialTerm(): Pair<PolynomialTerm, SignalCodes> {

	val numberStr = this.slice(0 until this.indexOf('*'))
	val number = if (numberStr.contains('.')) numberStr.toDouble() else numberStr.toInt()

	val degree = try {
		this.slice(this.indexOf('^') + 1 until this.length).toInt()
	} catch (e: NumberFormatException) {
		return Pair(PolynomialTerm(0, 0), SignalCodes.WRONG_DEGREE_FORMAT)
	}
	return Pair(PolynomialTerm(number, degree), SignalCodes.OK)
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
		if (term.second != SignalCodes.OK)
			return Pair(output, term.second)

		if (isWasEquality)
			term.first.number = term.first.number.toDouble() * -1
		output.add(term.first)
	}
	return Pair(output.toList(), SignalCodes.OK)
}