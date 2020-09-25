package output

import globalextensions.compareTo
import globalextensions.times
import models.PolynomialTerm
import java.lang.StringBuilder
import java.util.*

private fun getReducedForm(polynomial: List<PolynomialTerm>): String {
	if (polynomial[0].number == 0 && polynomial[1].number == 0 && polynomial[2].number == 0)
		return "0"

	val output = StringBuilder()
	polynomial.map {
		if (it.number < 0)
			output.append(" - ${ it.number * -1 } * X^${it.degree}")
		else
			output.append(" + $it")
	}

	output.delete(0, 2)
	if (polynomial[0].number < 0)
		output.append("-", 0, 0)
	return output.toString()
}

fun printOkOutput(polynomial: List<PolynomialTerm>, degree: Int) {
	println("Reduced form: ${getReducedForm(polynomial)} = 0")
	println("Polynomial degree: $degree")
}

private fun printAppropriateNumber(input: Number) {
	if (input is Int)
		println(input)
	else
		System.out.printf(Locale.US, "%.6f\n", input)
}

fun printSolutions(solutions: List<Number>) {
	when(solutions.size) {
		2 -> {
			println("Discriminant is strictly positive, the two solutions are:")
			printAppropriateNumber(solutions[0])
			printAppropriateNumber(solutions[1])
		}
		1 -> {
			println("The solution is:")
			printAppropriateNumber(solutions[0])
		}
		0 -> {
			println("Discriminant is strictly negative. There are no solutions.")
		}
	}
}