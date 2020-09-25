package models

import globalextensions.plus
import kotlin.math.sign

data class PolynomialTerm(var number: Number, val degree: Int) {
	private val sign: Double = number.toDouble().sign

	override fun toString(): String =
		if (sign == 0.0)
			""
		else
			"$number * X^$degree"

	operator fun plus(input: PolynomialTerm): PolynomialTerm = this.copy(number = number + input.number)
}