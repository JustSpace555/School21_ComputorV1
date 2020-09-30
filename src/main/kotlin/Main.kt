import calculations.calculateSolutions
import models.Discriminant
import models.PolynomialTerm
import output.error.printErrorOutput
import output.ok.printOkOutput
import output.ok.printSolutions
import parser.SignalCodes
import parser.parser

fun solver(polynomial: Triple<List<PolynomialTerm>, Int, SignalCodes>) {
	val discriminant = Discriminant(polynomial.first)
	val solutions = calculateSolutions(discriminant)

	printOkOutput(polynomial.first, polynomial.second)
	printSolutions(solutions, discriminant)
}

fun main(args: Array<String>) {
	if (args.size != 2) {
		printErrorOutput(listOf(), -1, SignalCodes.WRONG_AMOUNT_ARGS)
		return
	}

	val polynomial = parser(args[1])

	if (polynomial.third != SignalCodes.OK) {
		printErrorOutput(listOf(), -1, polynomial.third)
		return
	}
	solver(polynomial)
}