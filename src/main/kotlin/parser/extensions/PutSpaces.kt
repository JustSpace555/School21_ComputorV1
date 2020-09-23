package parser.extensions

import java.lang.StringBuilder

fun putSpaces(input: String): String {
	val output = StringBuilder("")
	var i = 0

	while (i in input.indices) {
		when (input[i]) {
			' ' -> i++
			'+' -> { output.append(' '); i++ }
			'=' -> output.append(" ${input[i++]} ")
			'-' -> {
				if (i + 1 in input.indices && input[i + 1] == ' ')
					output.append(" ${input[i]}")
				else
					output.append(input[i])
				i++
			}
			else -> output.append(input[i++])
		}
	}
	return output.toString()
}