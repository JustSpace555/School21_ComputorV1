package computor.models

import globalextensions.tryCastToInt

data class Fraction(private val numerator: Number, private val denominator: Number) {
	override fun toString(): String = "${numerator.tryCastToInt()} / ${denominator.tryCastToInt()}"
}