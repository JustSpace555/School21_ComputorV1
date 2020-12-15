package computor.models.exception

abstract class NumberException : ComputorException()

class PolynomialNumberFormatException(value: Any) : NumberException() {
	override val message: String = "Wrong number format. Can't parse $value to number"
}

class PolynomialDegreeFormatException(value: Any) : NumberException() {
	override val message: String = "Wrong degree format. Can't parse $value to degree (int)"
}

class PolynomialNumberDivideByZeroException : NumberException() {
	override val message: String = "It's impossible to divide number by zero"
}