package computor.calculations

import globalextensions.compareTo

fun sampleMax(n1: Number, n2: Number): Number = if (n1 > n2) n1 else n2
fun sampleMin(n1: Number, n2: Number): Number = if (n1 < n2) n1 else n2

fun Double.sampleSqrt(degree: Double = 0.5): Double {
	var lBorder = 0.0
	var rBorder = sampleMax(1, this).toDouble()
	var mid = (lBorder + rBorder) / 2
	val rightDegree = 1 / degree
	var i = 0

	while (mid.samplePow(rightDegree) != this && i < 500) {
		if (lBorder  == rBorder) break

		val p = mid.samplePow(rightDegree)
		when {
			p > this -> rBorder = mid
			p < this -> lBorder = mid
			else -> return p
		}
		mid = (lBorder + rBorder) / 2
		i++
	}
	return mid
}

fun Double.samplePow(degree: Double): Double =
	when(degree) {
		0.0 -> 1.0
		in Double.MIN_VALUE .. 0.0 -> samplePow(degree * -1)
		1.0 -> this
		in 0.0 .. 1.0 -> sampleSqrt(degree)
		else -> {
			var i = -1
			var output = 1.0
			while (++i < degree) output *= this
			output
		}
	}

/*
static double	ft_sqrt(double n, double s)
{
	long double	r_border;
	long double	l_border;
	long double	m;

	l_border = 0;
	r_border = ft_max(1, n);
	s = 1 / s;
	m = (l_border + r_border) / 2;
	while (ft_pow(m, (int)s) != n)
	{
		m = (l_border + r_border) / 2;
		if ((l_border / 10000) * 10000 == (r_border / 10000) * 10000)
			break ;
		if (ft_pow(m, (int)s) > n)
			r_border = m;
		else if (ft_pow(m, (int)s) < n)
			l_border = m;
	}
	return (m);
}
 */