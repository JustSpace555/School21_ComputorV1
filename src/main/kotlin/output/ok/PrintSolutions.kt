package output.ok

import models.Discriminant

fun printSolutions(answer: Triple<Discriminant, Any, Any?>, degree: Int) {
	if (degree >= 2)
		println("Discriminant: ${answer.first}")
	if (answer.third != null) {
		println("The two solutions are:")
		println(answer.second)
		println(answer.third)
	} else {
		println("The solution is: ${answer.second}")
	}
}