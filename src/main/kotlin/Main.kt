import calculations.calculateSolutions
import models.PolynomialTerm
import output.error.checkAndPrintError
import output.error.printErrorOutput
import output.ok.printOkOutput
import output.ok.printSolutions
import parser.SignalCodes
import parser.parser

fun solver(polynomial: Triple<List<PolynomialTerm>, Int, SignalCodes>) {
	val solutions = calculateSolutions(polynomial.first)

	printOkOutput(polynomial.first, polynomial.second)
	printSolutions(solutions, polynomial.second)
}

fun main(args: Array<String>) {
	if (checkAndPrintError(args.size != 2, SignalCodes.WRONG_AMOUNT_ARGS)) return

	val polynomial = parser(args[1]).also {
		if (checkAndPrintError(it.third != SignalCodes.OK, SignalCodes.OK)) return
	}

	solver(polynomial)
}