package output

import parser.SignalCodes

fun printErrorOutput(signal: SignalCodes) {
	println(
		when (signal) {
			SignalCodes.WRONG_DEGREE_FORMAT -> "Wrong degree format"
			SignalCodes.HIGHER_SECOND_DEGREE -> "The polynomial degree is strictly greater than 2, I can't solve."
			SignalCodes.WRONG_AMOUNT_ARGS -> "Wrong amount of arguments"
			else -> "Something went wrong :("
	})
}