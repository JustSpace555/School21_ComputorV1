package globalextensions

operator fun Number.plus(input: Number): Number {
	if (input is Int && this is Int)
		return this + input
	return this.toDouble() + input.toDouble()
}

operator fun Number.times(input: Number): Number {
	if (input is Int && this is Int)
		return this * input
	return this.toDouble() * input.toDouble()
}

operator fun Number.minus(input: Number): Number {
	if (input is Int && this is Int)
		return this - input
	return this.toDouble() - input.toDouble()
}

operator fun Number.div(input: Number): Number {
	if (input is Int && this is Int)
		return this / input
	return this.toDouble() / input.toDouble()
}

operator fun Number.unaryMinus(): Number = this * -1

operator fun Number.compareTo(input: Number): Int = (this.toDouble() - input.toDouble()).toInt()

fun Number.tryCastToInt(): Number =
		if (this.toDouble() - this.toInt() == 0.0)
			this.toInt()
		else
			this.toDouble()