package Polinomio;
import java.util.Arrays;
import java.util.Iterator;

public class Polinomio {
	private int grado;
	private double[] coeficientes;

	// La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n
	// la posicion n contiene al termino independiente.

	public Polinomio(double[] coeficientes) {
		this.coeficientes = coeficientes;
		this.grado = coeficientes.length;
	}

	// O(n^2)
	double evaluarMSucesivas(double x) {
		double resultado = 0;
		for (int i = 0; i < grado; i++)
			resultado += this.coeficientes[i]*potencia(x, this.grado-i-1);
		
		return resultado;
	}

	// O(n^2)
	double evaluarRecursiva(double x) {
		return auxEvaluarRecursiva(x, this.grado);
	}
	private double auxEvaluarRecursiva(double x, int gradoActual) {
		if (gradoActual == 1)return coeficientes[this.grado-gradoActual];
		
		double resultado = coeficientes[this.grado-gradoActual] * potencia(x, gradoActual-1);
		return resultado + auxEvaluarRecursiva(x,gradoActual-1);
	}

	// O(n^2)
	double evaluarRecursivaPar(double x) {
		return auxEvaluarRecursivaPar(x, this.grado);
	}

	private double auxEvaluarRecursivaPar(double x, int gradoActual) {
		if (gradoActual == 1)return coeficientes[this.grado-gradoActual];
		
		double exponente;
		if(gradoActual%2==0) {
			exponente = potencia(x*x, gradoActual/2);
		}else {
			exponente = potencia(x, gradoActual-1);
		}
		
		double resultado = coeficientes[this.grado-gradoActual] * exponente;
		return resultado + auxEvaluarRecursiva(x,gradoActual-1);
	}

	//O(n)
	double evaluarProgDinamica(double x) {
		double resultado = 0;
		
		double exponentesCalculados[] = new double[this.grado];
		exponentesCalculados[0] = 1;
		for (int i = 1 ; i< grado ; i++) {
			exponentesCalculados[i] = exponentesCalculados[i-1]*x; 
		}
		
		for (int i = grado-1; i>=0 ; i--) {
			resultado += this.coeficientes[i]*exponentesCalculados[this.grado-i-1];
		}
		return resultado;
	}

	//O(n)
	double evaluarMejorada(double x) {
		double resultado = 0;
		double exponenteEvaluadoActual = 1;
		for (int i = grado-1 ; i>=0 ; i--) {
			resultado += this.coeficientes[i]*exponenteEvaluadoActual;
			exponenteEvaluadoActual *= x;	
		}
		return resultado;
	}

	// O(n)
	double evaluarPow(double x) {
		double resultado = 0;
		for (int i = 0; i < grado; i++)
			resultado += this.coeficientes[i]*Math.pow(x, this.grado-i-1);
		
		return resultado;
	}

	// O(n)
	double evaluarHorner(double x) {
		double resultado = 0;
		for (int i = 0; i < grado; i++)
			resultado = this.coeficientes[i]+ x*resultado;
		return resultado;
	}

	//O(n)
	private double potencia(double x, double n) {
		double resultado = 1;
		for (int i = 0; i < n; i++) {
			resultado *= x;
		}
		return resultado;
	}
}
