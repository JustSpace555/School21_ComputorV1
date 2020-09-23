package models

interface PolynomialResult

data class TwoSolutions(val x1: Double, val x2: Double) : PolynomialResult
data class OneSolution(val x1: Double) : PolynomialResult
class ZeroSolutions : PolynomialResult