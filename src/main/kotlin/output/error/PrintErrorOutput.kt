package output.error

import models.PolynomialTerm
import output.ok.printOkOutput
import parser.SignalCodes

fun printErrorOutput(polynomial: List<PolynomialTerm>, degree: Int, signal: SignalCodes) {
	when (signal) {
		SignalCodes.WRONG_NUMBER_FORMAT -> println("Wrong number format.")
		SignalCodes.WRONG_DEGREE_FORMAT -> println("Wrong degree format.")
		SignalCodes.HIGHER_SECOND_DEGREE -> println("The polynomial degree is strictly greater than 2, I can't solve.")
		SignalCodes.WRONG_AMOUNT_ARGS -> println("Wrong amount of arguments.")
		SignalCodes.WRONG_AMOUNT_EQUAL_SIGNS -> println("Wrong amount of equal signs. Must be 1.")
		SignalCodes.WRONG_ARGUMENT_NAME -> println("Wrong argument name. Must be 'x' or 'X'.")

		SignalCodes.EVERY_NUMBER_IS_SOLUTION -> {
			printOkOutput(polynomial, degree)
			println("Every value for X is a solution.")
		}

		SignalCodes.NO_SOLUTION -> {
			printOkOutput(polynomial, degree)
			println("There is no solution because the equation is inconsistent.")
		}

		else -> println("Something went wrong :(")
	}
}