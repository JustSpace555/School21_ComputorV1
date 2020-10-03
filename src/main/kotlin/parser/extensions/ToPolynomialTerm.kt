package parser.extensions

import globalextensions.times
import models.PolynomialTerm
import parser.SignalCodes
import java.lang.NumberFormatException
import kotlin.math.absoluteValue

fun getConstNumber(input: String): Pair<Number, SignalCodes> {

	if (input.first().isLetter())
		return Pair(1, SignalCodes.OK)

	val numberListStr =
		if (input.contains('*'))
			input.split('*').filter {
				!it.contains('^') && !it.contains('x') && !it.contains('X')
			}
		else
			listOf(input)

	var number: Number = 1

	numberListStr.forEach {
		if (it.contains('.')) {
			try { number *= it.toDouble() }
			catch (e: NumberFormatException) { return Pair(0, SignalCodes.WRONG_NUMBER_FORMAT) }
		} else {
			try { number *= it.toInt() }
			catch (e: NumberFormatException) { return Pair(0, SignalCodes.WRONG_NUMBER_FORMAT) }
		}
	}

	if (number.toDouble() - number.toInt() == 0.0)
		number = number.toInt()

	return Pair(number, SignalCodes.OK)
}

fun getDegree(input: String): Pair<Int, SignalCodes> {
	if (!input.contains('^')) {
		return if (input.last().isDigit() && (input.contains('x') || input.contains('X')))
			Pair(0, SignalCodes.WRONG_DEGREE_FORMAT)
		else if (input.contains('x') || input.contains('X'))
			Pair(1, SignalCodes.OK)
		else
			Pair(0, SignalCodes.OK)
	}

	val degree = try {
		input.slice(input.indexOf('^') + 1 until input.length).toInt()
	} catch (e: NumberFormatException) {
		return Pair(0, SignalCodes.WRONG_DEGREE_FORMAT)
	}

	return Pair(degree, SignalCodes.OK)
}

fun toPolynomialTerm(input: String): Pair<PolynomialTerm, SignalCodes> {

	val emptyPolynomialTerm = PolynomialTerm(0, 0)

	input.map {
		if (it.isLetter() && !(it == 'x' || it == 'X'))
			return Pair(emptyPolynomialTerm, SignalCodes.WRONG_ARGUMENT_NAME)
	}

	val number = getConstNumber(input).also {
		if (it.second != SignalCodes.OK)
			return Pair(emptyPolynomialTerm, it.second)
	}

	val degree = getDegree(input).also {
		if (it.second != SignalCodes.OK)
			return Pair(emptyPolynomialTerm, it.second)
	}

	return Pair(PolynomialTerm(number.first, degree.first), SignalCodes.OK)
}