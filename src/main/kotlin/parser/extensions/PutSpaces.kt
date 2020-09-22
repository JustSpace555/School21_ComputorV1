package parser.extensions

import java.lang.StringBuilder

fun putSpaces(input: String): String {
	val output = StringBuilder("")
	var i = 0

	while (i in input.indices) {
		if (input[i] == ' ') i++

		else if (input[i] == '+' || input[i] == '=' ||
			(input[i] == '-' && i + 1 in input.indices && !input[i + 1].isDigit())
		) {
			output.append(" ${input[i++]} ")
		}

		else (output.append(input[i++]))
	}
	return output.toString()
}