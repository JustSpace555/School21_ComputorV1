package output.ok

import models.Discriminant

fun printSolutions(answer: Triple<Discriminant, Number?, Number?>, degree: Int) {
	if (degree >= 2)
		println("Discriminant: ${answer.first}")
	if (answer.second != null) {
		if (answer.third != null) {
			println("The two solutions are:")
			println(answer.second)
			println(answer.third)
		} else {
			println("The solution is: ${answer.second}")
		}
	} else {
		println("Discriminant is strictly negative. There are no solutions.")
	}
}