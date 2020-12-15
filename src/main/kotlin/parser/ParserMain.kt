package parser

import computor.models.exception.EqualSignAmountException
import computor.models.exception.EveryNumberIsSolutionException
import computor.models.exception.NoSolutionException
import computor.models.exception.PolynomialMaxDegreeException
import models.PolynomialTerm
import parser.extensions.*

fun parser(input: String): Pair<List<PolynomialTerm>, Int> {
	val inputArray: List<String> = putSpaces(input).split(' ').filter { it.isNotEmpty() && it.isNotBlank() }

	if (inputArray.lastIndexOf("=") != inputArray.indexOf("="))
		throw EqualSignAmountException()

	var maxDegree: Int
	val simpledPolynomial = simplifyPolynomial(toPolynomialList(inputArray)).also {

		 maxDegree = findMaxDegree(it).also { degree ->
			if (degree > 2) throw PolynomialMaxDegreeException()
		}

		if (it.findPolynomialByDegree(2) == null && it.findPolynomialByDegree(1) == null) {
			if (it.findPolynomialByDegree(0) == null)
				throw EveryNumberIsSolutionException(it, maxDegree)
			else
				throw NoSolutionException(it, maxDegree)
		}
	}

	return Pair(simpledPolynomial, maxDegree)
}