public class Polinomio {
	private int grado;
	private double[] coeficientes;

	// La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n
	// la posicion n contiene al termino independiente.

	public Polinomio(double[] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = coeficientes.length;
	}

	double evaluarMSucesivas(double x) {
		double resultado = 0;
		for (int i = 0; i < grado; i++) {
			resultado += this.coeficientes[i]*potencia(x, this.grado-i);
		}
		
		return resultado;
	}

	private double potencia(double x, int n) {
		return Math.pow(x, n);
	}
	
	double evaluarRecursiva(double x) {
		// TODO
		return 0;
	}

	double evaluarRecursivaPar(double x) {
		// TODO
		return 0;
	}

	double evaluarProgDinamica(double x) {
		// TODO
		return 0;
	}

	double evaluarMejorada(double x) {
		// TODO
		return 0;
	}

	double evaluarPow(double x) {
		return Math.pow(x, this.grado);
	}

	double evaluarHorner(double x) {
		// TODO
		return 0;
	}
}
