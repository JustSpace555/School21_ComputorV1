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

	fun toGeneralString(): String =
		when {
			sign == 0.0 -> ""

			sign > 0.0 -> {
				if (degree > 0)
					" + $number * X^$degree"
				else
					this.toString()
			}

			else -> {
				if (degree > 0)
					" - ${number.toDouble() * -1} * X^$degree"
				else
					this.toString()

			}
		}

	operator fun plus(input: PolynomialTerm): PolynomialTerm = this.copy(number = number + input.number)
}