package models

import globalextensions.minus
import globalextensions.times

class Discriminant(polynomial: List<PolynomialTerm>) {
	val argA = polynomial[2].number
	val argB = polynomial[1].number
	val argC = polynomial[0].number

	val result = argB * argB - 4 * argA * argC

	override fun toString(): String = result.toString()
}