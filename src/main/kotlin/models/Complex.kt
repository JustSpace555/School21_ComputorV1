package models

import globalextensions.compareTo
import globalextensions.div
import globalextensions.times

class Complex(private val re: Number, private val im: Number): Number() {
	override fun toByte(): Byte { TODO("Not yet implemented") }
	override fun toChar(): Char { TODO("Not yet implemented") }
	override fun toDouble(): Double { TODO("Not yet implemented") }
	override fun toFloat(): Float { TODO("Not yet implemented") }
	override fun toInt(): Int { TODO("Not yet implemented") }
	override fun toLong(): Long { TODO("Not yet implemented") }
	override fun toShort(): Short { TODO("Not yet implemented") }

	override fun toString(): String {
		if (re.toDouble() == 0.0)
			return "${im}i"

		var tempIm = im
		val signString = if (im < 0) {
			tempIm *= -1
			" - "
		} else {
			" + "
		}
		return "$re$signString${tempIm}i"
	}

	operator fun div(input: Number): Complex = Complex(this.re / input, this.im / input)
}