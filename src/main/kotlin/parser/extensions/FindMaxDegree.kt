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

fun List<PolynomialTerm>.findPolynomialByDegree(degree: Int): PolynomialTerm? {
	var polynomial: PolynomialTerm? = null
	this.forEach(fun(p: PolynomialTerm) {
		if (p.degree == degree)
			polynomial = p
	})
	return polynomial
}