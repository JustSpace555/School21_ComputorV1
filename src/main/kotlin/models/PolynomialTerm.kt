package models

import globalextensions.plus

data class PolynomialTerm(var number: Number, var degree: Int) {
	override fun toString(): String {
		return if (number == 0) ""
		else {
			return when (degree) {
				0 -> "$number"
				1 -> "$number * x"
				else -> "$number * x^$degree"
			}
		}
	}

	operator fun plus(input: PolynomialTerm): PolynomialTerm = this.copy(number = number + input.number)
}