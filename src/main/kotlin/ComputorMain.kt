package computor

import calculations.calculateSolutions
import computor.models.exception.ArgumentsAmountException
import computor.models.exception.ComputorException
import computor.parser.Flags
import computor.parser.parserFlags
import models.PolynomialTerm
import output.ok.printOkOutput
import output.ok.printSolutions
import parser.parser
import java.lang.Exception

val listOfPossibleFlags: List<String> = listOf("-r", "-f", "-u")
val globalFlags: MutableList<Flags> = mutableListOf()

fun solver(polynomial: Pair<List<PolynomialTerm>, Int>) {
	val solutions = calculateSolutions(polynomial.first)

	printOkOutput(polynomial.first, polynomial.second)
	printSolutions(solutions, polynomial.second)
}

fun main(args: Array<String>) {
	try {
		parserFlags(args)
		if (globalFlags.contains(Flags.USAGE)) {
			println("-r: Show reduced form")
			println("-f: Show result in fraction")
			println("-u: Show this dialog message")
			return
		}
		val filtered = args.filter { it !in listOfPossibleFlags }
		if (filtered.size != 1) throw ArgumentsAmountException()
		solver(parser(filtered.first()))
	} catch (cExp: ComputorException) {
		println(cExp.message)
	} catch (exc: Exception) {
		println("Something went wrong :(")
		println(exc.message)
	}
}
