package output

import models.FullPolynomial

fun printOkOutput(polynomial: FullPolynomial) =
	with(polynomial) {
		println("Reduced form: $zeroDegreeTerm $firstDegreeTerm $secondDegreeTerm = 0")
		println("Polynomial degree: $degree")
	}