package computor.models.exception

abstract class ArgumentException : ComputorException()

class ArgumentsAmountException : ArgumentException() {
	override val message: String = "Wrong amount of arguments."
}

class PolynomialArgumentNameException(value: Any) : ArgumentException() {
	override val message: String = "Wrong argument '$value' name. Must be 'x' or 'X'."
}