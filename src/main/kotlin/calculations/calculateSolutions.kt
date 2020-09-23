package calculations

import models.PolynomialResult
import models.TwoSolutions

fun calculateSolutions(d: Double): PolynomialResult =
	when {
		d > 0 -> TwoSolutions()
	}