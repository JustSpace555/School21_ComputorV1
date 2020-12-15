package models

import computor.globalFlags
import computor.parser.Flags
import globalextensions.compareTo
import globalextensions.plus

data class PolynomialTerm(var number: Number, var degree: Int) {
	override fun toString(): String =
		when {

			globalFlags.contains(Flags.REDUCED_FORM) && number.compareTo(0) == 0 -> ""

			globalFlags.contains(Flags.REDUCED_FORM) -> {
				val xString = when (degree) {
					0 -> ""
					1 -> " * x"
					else -> " * x^$degree"
				}
				"$number$xString"
			}

			else -> "$number * X^$degree"
		}

	operator fun plus(input: PolynomialTerm): PolynomialTerm = this.copy(number = number + input.number)
}