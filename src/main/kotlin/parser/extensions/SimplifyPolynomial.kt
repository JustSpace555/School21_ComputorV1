package parser.extensions

import models.PolynomialTerm

fun simplifyPolynomial(input: List<PolynomialTerm>): List<PolynomialTerm> {
	var secondDegreePolynomial = PolynomialTerm(0, 2)
	var firstDegreePolynomial = PolynomialTerm(0, 1)
	var zeroDegreePolynomial = PolynomialTerm(0, 0)

	for (term in input) {
		when (term.degree) {
			2 -> secondDegreePolynomial += term
			1 -> firstDegreePolynomial += term
			0 -> zeroDegreePolynomial += term
		}
	}

	return listOf(zeroDegreePolynomial, firstDegreePolynomial, secondDegreePolynomial)
}