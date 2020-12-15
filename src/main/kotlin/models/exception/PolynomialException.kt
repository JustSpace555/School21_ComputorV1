package computor.models.exception

abstract class PolynomialException : ComputorException()

class PolynomialMaxDegreeException : PolynomialException() {
	override val message: String = "The polynomial degree is strictly greater than 2, I can't solve."
}