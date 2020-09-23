package models

class Discriminant(polynomial: FullPolynomial) {
	val argA = polynomial.secondDegreeTerm.number.toDouble()
	val argB = polynomial.firstDegreeTerm.number.toDouble()
	val argC = polynomial.zeroDegreeTerm.number.toDouble()

	val result = argB * argB - 4 * argA * argC
}