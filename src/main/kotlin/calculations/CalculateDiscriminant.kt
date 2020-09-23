package calculations

import models.FullPolynomial
import kotlin.math.pow

fun calculateDiscriminant(polynomial: FullPolynomial) {
	val a = polynomial.secondDegreeTerm.number.toDouble()
	val b = polynomial.firstDegreeTerm.number.toDouble()
	val c = polynomial.zeroDegreeTerm.number.toDouble()

	val d = b.pow(2) - 4 * a * c
}