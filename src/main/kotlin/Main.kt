import models.FullPolynomial
import output.printErrorOutput
import output.printOkOutput
import parser.SignalCodes
import parser.parser

fun main(args: Array<String>) {
	if (args.size != 2) {
		printErrorOutput(SignalCodes.WRONG_AMOUNT_ARGS)
		return
	}

	val polynomial = parser(args[1])

	if (polynomial.second != SignalCodes.OK) {
		printErrorOutput(polynomial.second)
		return
	}

	printOkOutput(polynomial.first as FullPolynomial)
}