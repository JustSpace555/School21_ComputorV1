import models.PolynomialTerm
import org.junit.Test
import kotlin.test.assertEquals

class PolynomialTermTests {

	@Test
	fun toStringTest() {
		val t = PolynomialTerm(1, 2)
		assertEquals(t.toString(), "1 * X^2")

		t.number = 0
		t.degree = 0
		assertEquals(t.toString(), "")

		t.number = 2.3
		assertEquals(t.toString(), "2.3 * X^0")

		t.number = -1.1
		t.degree = 2
		assertEquals(t.toString(), "-1.1 * X^2")
	}

	@Test
	fun testAdd() {
		var t1 = PolynomialTerm(10, 2)
		val t2 = PolynomialTerm(-10, 2)

		t1 += t2
		assertEquals(t1.number, 0)
		assertEquals(t1.degree, 2)
	}
}