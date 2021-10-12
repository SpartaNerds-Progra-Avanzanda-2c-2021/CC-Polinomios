import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolinomioTest {

	Polinomio p1;
	Polinomio p2;
	Polinomio p3;
	
	@Before
	public void setUp() {
		double[] c1 = { 0, 2, 4, 2 };
		p1 = new Polinomio(c1);
		double[] c2 = { 0, 4, 2, 2 };
		p2 = new Polinomio(c2);
		p3 = new Polinomio(c1);
	}
	
	@Test
	public void testEvaluarMSucesivas() {
		assertEquals(18.0, p1.evaluarMSucesivas(2), 0.1);
	}

	@Test
	public void testEvaluarRecursiva() {
		assertEquals(8.0, p1.evaluarRecursiva(1), 0.1);
	}
	
	@Test
	public void testEvaluarRecursivaPar() {
		assertEquals(8.0, p1.evaluarRecursivaPar(1), 0.1);
	}
	
	@Test
	public void testEvaluarHorner() {
		assertEquals(22.0, p2.evaluarHorner(2), 0.1);
	}
	
	@Test
	public void testEvaluarHorner2() {
		assertEquals(18.0, p3.evaluarHorner(2), 0.1);
	}
}
