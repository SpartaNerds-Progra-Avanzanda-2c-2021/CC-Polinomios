import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolinomioTest {

	Polinomio p1;
	
	@Before
	public void setUp() {
		double[] c1 = { 0, 2, 4, 2 };
		p1 = new Polinomio(c1);
	}
	
	@Test
	public void testEvaluarMSucesivas() {
		assertEquals(8.0, p1.evaluarMSucesivas(1), 0.1);
	}

	@Test
	public void testEvaluarRecursiva() {
		assertEquals(8.0, p1.evaluarRecursiva(1), 0.1);
	}
	
	@Test
	public void testEvaluarRecursivaPar() {
		assertEquals(8.0, p1.evaluarRecursivaPar(1), 0.1);
	}
}
