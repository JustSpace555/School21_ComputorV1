package parser.extensions

import models.PolynomialTerm

fun findMaxDegree(input: List<PolynomialTerm>): Int {
	var maxDegree = 0

	for (term in input) {
		if (term.degree > maxDegree)
			maxDegree = term.degree
	}

	return maxDegree
}