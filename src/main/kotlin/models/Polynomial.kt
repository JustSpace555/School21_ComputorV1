package models

interface Polynomial

data class FullPolynomial(private val polynomialList: List<PolynomialTerm>, val degree: Int): Polynomial {
    val zeroDegreeTerm: PolynomialTerm
        get() = polynomialList[0]

    val firstDegreeTerm: PolynomialTerm
        get() = polynomialList[1]

    val secondDegreeTerm: PolynomialTerm
        get() = polynomialList[2]
}

class EmptyPolynomial: Polynomial