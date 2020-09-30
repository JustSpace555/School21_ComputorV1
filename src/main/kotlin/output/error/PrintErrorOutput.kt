package output.error

import models.PolynomialTerm
import output.ok.printOkOutput
import parser.SignalCodes

fun printErrorOutput(polynomial: List<PolynomialTerm>, degree: Int, signal: SignalCodes) {
	println(
		when (signal) {
			SignalCodes.WRONG_DEGREE_FORMAT -> "Wrong degree format."
			SignalCodes.HIGHER_SECOND_DEGREE -> "The polynomial degree is strictly greater than 2, I can't solve."
			SignalCodes.WRONG_AMOUNT_ARGS -> "Wrong amount of arguments."
			SignalCodes.WRONG_AMOUNT_EQUAL_SIGNS -> "Wrong amount of equal signs. Must be 1."
			SignalCodes.WRONG_ARGUMENT_NAME -> "Wrong argument name. Must be 'x' or 'X'."

			SignalCodes.EVERY_NUMBER_IS_SOLUTION -> {
				printOkOutput(polynomial, degree)
				println("Every value for X is a solution.")
			}

			SignalCodes.NO_SOLUTION -> {
				printOkOutput(polynomial, degree)
				println("There is no solution because the equation is inconsistent.")
			}

			else -> "Something went wrong :("
	})
}