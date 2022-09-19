package pesquisaOrdenacao.praticoC1;

public class Atividade {

	public static void main(String[] args) {

		// FATORIAL
//		System.out.println(fatorial(3));

		// INICIAR MATRIZ
//		int[][] mat = new int[10][10];
//		iniciaMatriz(mat);
//		System.out.println(mat);

		// FIBONACCI

	}

	/*
	 * para o método "fatorial"
	 * Resposta: 3n+4
	 */
	private static int fatorial(int n) {
		int i;
		int fat = 1; // 1

		for (i = 1; i <= n; i++) { // 2n+2
			fat *= i; // n
		}

		return fat; // 1
	}

	/*
	 * para o método "iniciaMatriz"
	 * mat.length = a 
	 * mat[l].length = b 
	 * Resposta: 3ab + 4a + 2
	 */
	private static void iniciaMatriz(int[][] mat) {
		int l, c;
		for (l = 0; l < mat.length; l++) // 2a+2
			for (c = 0; c < mat[l].length; c++) // a*(2b+2) = 2ab + 2a
				mat[1][c] = 0; // a*b
	}

	/*
	 * para o método "fibonacci"
	 * para n == 1: 3 
	 * para n == 2: 4 
	 * 6n
	 */
	private static int fibonacci(int n) {
		int f1, f2, f3 = 0, i; // 1
		if (n == 1) // 1
			return 0; // 1
		if (n == 2) // 1
			return 1; // 1
		f1 = 0; // 1
		f2 = 1; // 1
		for (i = 3; i <= n; i++) { // 2*(n-1) = 2n - 2
			f3 = f1 + f2; // 2 (n-1)
			f1 = f2; // (n-1)
			f2 = f3; // (n-1)
		}

		return f3; // 1
	}

	/*
	 * para o método "integral"
	 * 13n+10
	 */
	public Double integral(double a, double b, int n) {
		double h;
		double soma;
		double x;
		double y;
		int c;
		int i;
		h = (b - a) / n; // 3
		soma = Math.sin(a) + Math.sin(b); // 4

		for (i = 1; i < n; i++) { // n + n
			x = a + i * h; // 3n
			y = Math.sin(x); // 2n
			c = 2 * (i % 2 + 1); // 4n
			soma += c * y; // 2n
		}

		return (soma * h) / 3; // 3
	}

	/*
	 * para o método "existe"
	 * no pior dos casos = 4n+2 
	 * no melhor dos casos = 5
	 */
	public boolean existe(double[] vet, double x) {
		int i;
		i = 0; // 1
		while (i < vet.length && x != vet[i]) { // 3n ou 3
			i++; // n 
		}
		return (i < vet.length); // 1
	}

	/*
	 * para o método "posicao"
	 * no pior dos casos = 4n+3 
	 * no melhor dos casos = 7
	 */
	public int posicao(double[] vet, double x) {
		int i;
		i = -1; // 1
		do {
			i++; // n ou 1
		} while (i < vet.length && x != vet[i]); // 3n ou 3
		if (i == vet.length) { // 1
			return -1; // 1
		} else {
			return i; // 1
		}
	}

	/*
	 * para o método "multiplicacao"
	 * para m1[0].length != m -> 5
	 * 2n+7+(n*(2p+2)+n*p*(2m+2) + 2m
	 * para n = m = p -> (2n^3) + (2n^2) + 6n +7
	 */
	public int[][] multiplicacao(int[][] m1, int[][] m2) {
		int[][] mult;
		int i;
		int j;
		int k;
		int m;
		int n;
		int p;
		m = m2.length; // 1
		n = m1.length; // 1
		p = m2[0].length; // 1
		if (m1[0].length != m) { // 1
			return null; // para m1[0].length != m -> 1
		}
		mult = new int[n][p]; // 1
		for (i = 0; i < n; i++) { // 2n+2
			for (j = 0; j < p; j++) { // n*(2p+2)
				for (k = 0; k < m; k++) { // n*p(2m+2)
					mult[i][j] += m1[i][k] * m2[k][j]; // 2m
				}
			}
		}
		return mult; // 1
	}

	/*
	 * para método "calculo1"
	 * 
	 */
	public int calculo1(int n) {
		int i;
		int j;
		int result;
		result = 0; // 1

		for (i = 2; i <= n; i++) { // 2n
			for (j = i; j <= n; j++) { // (n-1) * sinceramente que daqui pra baixo eu não tenho nem noção de como equacionar
				result++;
			}
		}
		return result;
	}

	public int calculo2(int n) {
		int i;
		int j;
		int result;
		result = 0;
		for (i = 1; i <= n; i++) {
			for (j = i + 1; j <= 2 * n + i; j++) {
				result += j;
			}
		}
		return result;
	}

	public int calculo3(int n) {
		int i;
		int j;
		int result;
		result = 0;

		for (i = 1; i <= n; i++) {
			for (j = (i + 1); j <= (n + i); j++) {
				result += j;
			}
		}
		return result;
	}

	public int calculo4(int n) {
		int i;
		int j;
		int result;
		result = 0;
		for (i = 1; i <= n; i++) {
			for (j = (i + 1); j <= n; j++) {
				result += j;
			}
		}
		return result;
	}

	public void intersecao(int[] vet1, int[] vet2, int[] inter) {
		int i;
		int j;
		int k;
		k = 0;
		for (i = 0; i < vet1.length; i++) {
			j = 0;
			while (j < vet2.length) {
				if (vet1[i] == vet2[j]) {
					inter[k] = vet1[i];
					k++;
					j = vet2.length;
				} else {
					if (vet1[i] > vet2[j]) {
						j++;
					} else {
						j = vet2.length;
					}
				}
			}
		}
	}

}
