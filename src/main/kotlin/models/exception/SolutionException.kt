package computor.models.exception

import models.PolynomialTerm
import output.ok.printOkOutput

abstract class SolutionException(polynomial: List<PolynomialTerm>, degree: Int) : ComputorException() {
	init {
		printOkOutput(polynomial, degree)
	}
}

class EveryNumberIsSolutionException(
	polynomial: List<PolynomialTerm>,
	degree: Int
) : SolutionException(polynomial, degree) {
	override val message: String = "Every value for X is a solution."
}

class NoSolutionException(
	polynomial: List<PolynomialTerm>,
	degree: Int
) : SolutionException(polynomial, degree) {
	override val message: String = "There is no solution because the equation is inconsistent."
}