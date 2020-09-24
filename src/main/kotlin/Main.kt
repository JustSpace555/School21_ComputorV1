import calculations.calculateSolutions
import models.Discriminant
import output.printErrorOutput
import output.printOkOutput
import output.printSolutions
import parser.SignalCodes
import parser.parser

fun main(args: Array<String>) {
	if (args.size != 2) {
		printErrorOutput(SignalCodes.WRONG_AMOUNT_ARGS)
		return
	}

	val polynomial = parser(args[1])

	if (polynomial.third != SignalCodes.OK) {
		printErrorOutput(polynomial.third)
		return
	}

	printOkOutput(polynomial.first, polynomial.second)
	val discriminant = Discriminant(polynomial.first)
	val solutions = calculateSolutions(discriminant)

	printSolutions(solutions)
}