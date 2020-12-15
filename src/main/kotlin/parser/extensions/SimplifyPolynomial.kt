package parser.extensions

import computor.globalFlags
import computor.parser.Flags
import models.PolynomialTerm
import output.ok.getReducedForm

fun simplifyPolynomial(input: List<PolynomialTerm>): List<PolynomialTerm> {
	val polynomialMap: MutableMap<Int, PolynomialTerm> = mutableMapOf()

	input.forEach {
		val mapPol = polynomialMap[it.degree] ?: PolynomialTerm(0, it.degree)
		polynomialMap[it.degree] = mapPol + it
	}

	return polynomialMap
		.map { it.value }
		.filter { it.number != 0 }
		.sortedByDescending { it.degree }
}