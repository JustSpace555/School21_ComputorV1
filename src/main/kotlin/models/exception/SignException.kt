package computor.models.exception

abstract class SignException : ComputorException()

class EqualSignAmountException : SignException() {
	override val message: String = "Wrong amount of equal signs. Must be 1."
}