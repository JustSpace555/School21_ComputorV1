package output.ok

import computor.globalFlags
import computor.parser.Flags
import globalextensions.compareTo
import globalextensions.times
import models.Discriminant
import models.PolynomialTerm
import java.lang.StringBuilder

fun getReducedForm(polynomial: List<PolynomialTerm>): String {
	val outputString =
		if (polynomial.isEmpty() || polynomial.all { it.number.compareTo(0) == 0 }) {
			"0"
		} else {
			polynomial.joinToString(" + ").replace(" + -", " - ")
		}

	return if (globalFlags.contains(Flags.REDUCED_FORM)) {
		outputString
			.replace("X", "x")
			.replace("^1", "")
			.replace(Regex(" ? x\\^0"), "")
			.replace("1 * ", "")
	} else {
		outputString
	}
}

fun printOkOutput(polynomial: List<PolynomialTerm>, degree: Int) {
	println("Reduced form: ${getReducedForm(polynomial)} = 0")
	println("Polynomial degree: $degree")
}
