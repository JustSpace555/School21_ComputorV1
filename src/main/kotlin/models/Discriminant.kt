package models

import globalextensions.minus
import globalextensions.times
import parser.extensions.findPolynomialByDegree

class Discriminant(polynomial: List<PolynomialTerm>) {
	val argA = polynomial.findPolynomialByDegree(2)?.number ?: 0
	val argB = polynomial.findPolynomialByDegree(1)?.number ?: 0
	val argC = polynomial.findPolynomialByDegree(0)?.number ?: 0

	val result = if (argA.toDouble() == 0.0)
		0
	else
		argB * argB - 4 * argA * argC

	override fun toString(): String = result.toString()
}