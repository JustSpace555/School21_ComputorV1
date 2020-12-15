package globalextensions

import computor.models.exception.PolynomialNumberDivideByZeroException

fun Number.invokeOperation(operation: (Double, Double) -> Double, other: Number): Number =
	operation(this.toDouble(), other.toDouble()).tryCastToInt()

operator fun Number.plus(other: Number): Number = invokeOperation(Double::plus, other)
operator fun Number.times(other: Number): Number = invokeOperation(Double::times, other)
operator fun Number.minus(other: Number): Number = invokeOperation(Double::minus, other)
operator fun Number.div(other: Number): Number {
	if (other.compareTo(0) == 0) throw PolynomialNumberDivideByZeroException()
	return invokeOperation(Double::div, other)
}

operator fun Number.unaryMinus(): Number = this * -1

operator fun Number.compareTo(other: Number): Int =
	when {
		this.toDouble() - other.toDouble() > 0.0 -> 1
		this.toDouble() - other.toDouble() == 0.0 -> 0
		else -> -1
	}

fun Number.tryCastToInt(): Number =
		if (this.toDouble() - this.toInt() == 0.0)
			this.toInt()
		else
			this.toDouble()