package polinomio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolinomioTest {

	Polinomio p1;

	@Before
	public void setUp() {
		double[] c1 = { 0, 3, 1, 2 };
		p1 = new Polinomio(c1);
	}

	@Test
	public void testEvaluarMSucesivas() {
		assertEquals(16, p1.evaluarMSucesivas(2), 0.1);
	}

	@Test
	public void testEvaluarRecursiva() {
		assertEquals(16, p1.evaluarRecursiva(2), 0.1);
	}

	@Test
	public void testEvaluarRecursivaPar() {
		assertEquals(16, p1.evaluarRecursivaPar(2), 0.1);
	}

	@Test
	public void testEvaluarProgDinamica() {
		assertEquals(16, p1.evaluarProgDinamica(2), 0.1);
	}

	@Test
	public void evaluarMejorada() {
		assertEquals(16.0, p1.evaluarMejorada(2), 0.1);
	}

	@Test
	public void testEvaluarPow() {
		assertEquals(16.0, p1.evaluarPow(2), 0.1);
	}

	@Test
	public void testEvaluarHorner() {
		assertEquals(16.0, p1.evaluarHorner(2), 0.1);
	}
}
