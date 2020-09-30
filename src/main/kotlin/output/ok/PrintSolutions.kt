package output.ok

import models.Discriminant
import java.util.*

private fun printAppropriateNumber(input: Number) {
	if (input is Int)
		println(input)
	else
		System.out.printf(Locale.US, "%.6f\n", input)
}

fun printSolutions(solutions: List<Number>, discriminant: Discriminant) {
	println("Discriminant: $discriminant")
	when(solutions.size) {
		2 -> {
			println("Discriminant is strictly positive, the two solutions are:")
			printAppropriateNumber(solutions[0])
			printAppropriateNumber(solutions[1])
		}
		1 -> {
			println("The solution is:")
			printAppropriateNumber(solutions[0])
		}
		0 -> {
			println("Discriminant is strictly negative. There are no solutions.")
		}
	}
}