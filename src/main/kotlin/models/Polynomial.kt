package models

interface Polynomial

data class PolynomialTerm(var number: Number, val degree: Int) : Polynomial {
    override fun toString(): String = "$number" + if (degree > 0) " * X ^ $degree" else ""
}

class Equality : Polynomial