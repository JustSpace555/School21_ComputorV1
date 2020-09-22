package parser.extensions

import models.Equality
import models.Polynomial
import models.PolynomialTerm

fun findMaxDegree(input: List<Polynomial>): Int {
	var maxDegree = 0

	for (term in input) {
		if (term is PolynomialTerm && term.degree > maxDegree)
			maxDegree = term.degree
	}

	return maxDegree
}