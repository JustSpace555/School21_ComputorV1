package output.ok

import globalextensions.compareTo
import globalextensions.times
import models.Discriminant
import models.PolynomialTerm
import java.lang.StringBuilder

private fun getReducedForm(polynomial: List<PolynomialTerm>, degree: Int): String {
	if (polynomial.isEmpty() || polynomial.all { it.number.toDouble() == 0.0 })
		return "0"

	val output = StringBuilder()
	polynomial.map {
		if (it.number != 0) {
			if (it.number < 0)
				output.append(" - ${it.number * -1} * X^${it.degree}")
			else
				output.append(" + $it")
		}
	}

	output.delete(0, 3)
	if (polynomial[2 - degree].number < 0)
		output.insert(0, "-")

	return output.toString()
}

fun printOkOutput(polynomial: List<PolynomialTerm>, degree: Int) {
	println("Reduced form: ${getReducedForm(polynomial, degree)} = 0")
	println("Polynomial degree: $degree")
}