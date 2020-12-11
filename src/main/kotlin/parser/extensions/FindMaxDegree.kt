package parser.extensions

import models.PolynomialTerm

fun findMaxDegree(input: List<PolynomialTerm>): Int {
	var maxDegree = 0

	for (term in input) {
		if (term.number.toDouble() != 0.0 && term.degree > maxDegree)
			maxDegree = term.degree
	}

	return maxDegree
}