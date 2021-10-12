import java.util.Arrays;

public class Polinomio {
	private int grado;
	private double[] coeficientes;

	// La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n
	// la posicion n contiene al termino independiente.

	public Polinomio(double[] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = coeficientes.length;
	}

	// O(n)
	double evaluarMSucesivas(double x) {
		double resultado = 0;
		for (int i = 0; i < grado; i++)
			resultado += this.coeficientes[i]*potencia(x, this.grado-i);
		
		return resultado;
	}

	// O(n)
	double evaluarRecursiva(double x) {
		return auxEvaluarRecursiva(x, this.coeficientes);
	}
	
	private double auxEvaluarRecursiva(double x, double[] coeficientes) {
		if (coeficientes.length == 1)
			return coeficientes[0];
		
		return coeficientes[0] * x * potencia(x, coeficientes.length-1)
				+ auxEvaluarRecursiva(x, Utils.subArray(coeficientes, 1, coeficientes.length - 1));
	}

	// O(n)
	double evaluarRecursivaPar(double x) {
		return auxEvaluarRecursivaPar(x, this.coeficientes);
	}

	private double auxEvaluarRecursivaPar(double x, double[] coeficientes) {
		if (coeficientes.length == 1)
			return coeficientes[0];
		
		int n = coeficientes.length;
		
		return coeficientes[0] * ( (n%2==0)?(potencia(x*x, n/2)):(x * potencia(x, n-1)) )
				+ auxEvaluarRecursiva(x, Utils.subArray(coeficientes, 1, coeficientes.length - 1));
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

	// O(n)
	double evaluarHorner(double x) {
		double resultado = 0;
		for (int i = 0; i < grado; i++)
			resultado = this.coeficientes[i]+ x*resultado;
		return resultado;
	}

	private double potencia(double x, double n) {
		return Math.pow(x, n);
	}
}
