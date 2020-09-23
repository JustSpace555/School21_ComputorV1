package models

data class PolynomialTerm <T : Number> (var number: T, val degree: Int) {
	override fun toString(): String {
		return if (number is Int)
			(if (number.toInt() < 0) "- ${number.toInt() * -1}" else number.toInt()).toString() + " * X^$degree"
		else
			(if (number.toDouble() < 0) "- ${number.toDouble() * -1}" else number.toDouble()).toString() + " * X^$degree"
	}

	operator fun plus(input: PolynomialTerm<T>): PolynomialTerm<T> =
		if (input.number is Int && this.number is Int)
			this.copy(number = this.number.toInt() + input.number.toInt())
		else
			this.copy(number = this.number.toDouble() + input.number.toDouble())
}