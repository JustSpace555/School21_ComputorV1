package models

import globalextensions.minus
import globalextensions.times

class Discriminant(polynomial: List<PolynomialTerm>) {
	val argA = polynomial[0].number
	val argB = polynomial[1].number
	val argC = polynomial[2].number

	val result = if (argA.toDouble() == 0.0)
		0
	else
		argB * argB - 4 * argA * argC

	override fun toString(): String = result.toString()
}