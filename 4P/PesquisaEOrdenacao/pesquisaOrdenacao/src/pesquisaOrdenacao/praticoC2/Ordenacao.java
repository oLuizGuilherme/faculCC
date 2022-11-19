package pesquisaOrdenacao.praticoC2;

import java.io.IOException;

public class Ordenacao {

	private static long[] tempoInsertionSort = new long[5];
	private static long[] tempoBubbleSort = new long[5];
	private static long[] tempoQuickSort = new long[5];
	private static long[] tempoSelectionSort = new long[5];
	private static long[] tempoShellSort = new long[5];
	private static long[] tempoMergeSort = new long[5];

	public static void main(String[] args) throws IOException {

		int quantidade = 100;
		int[] vetor = gerarNumerosDecrescentes(quantidade);
		rodarOrdenacao(vetor, 0);

		quantidade = 1000;
		vetor = gerarNumerosDecrescentes(quantidade);
		rodarOrdenacao(vetor, 1);
		
		quantidade = 10000;
		vetor = gerarNumerosDecrescentes(quantidade);
		rodarOrdenacao(vetor, 2);
		
		quantidade = 100000;
		vetor = gerarNumerosDecrescentes(quantidade);
		rodarOrdenacao(vetor, 3);
		
		quantidade = 1000000;
		vetor = gerarNumerosDecrescentes(quantidade);
		rodarOrdenacao(vetor, 4);
		
		System.out.println(tempoInsertionSort[0] + " " + tempoInsertionSort[1] + " " + tempoInsertionSort[2] + " " + tempoInsertionSort[3] + " " + tempoInsertionSort[4]);
		System.out.println(tempoBubbleSort[0] + " " + tempoBubbleSort[1] + " " + tempoBubbleSort[2] + " " + tempoBubbleSort[3] + " " + tempoBubbleSort[4]);
		System.out.println(tempoQuickSort[0] + " " + tempoQuickSort[1] + " " + tempoQuickSort[2] + " " + tempoQuickSort[3] + " " + tempoQuickSort[4]);
		System.out.println(tempoSelectionSort[0] + " " + tempoSelectionSort[1] + " " + tempoSelectionSort[2] + " " + tempoSelectionSort[3] + " " + tempoSelectionSort[4]);
		System.out.println(tempoShellSort[0] + " " + tempoShellSort[1] + " " + tempoShellSort[2] + " " + tempoShellSort[3] + " " + tempoShellSort[4]);
		System.out.println(tempoMergeSort[0] + " " + tempoMergeSort[1] + " " + tempoMergeSort[2] + " " + tempoMergeSort[3] + " " + tempoMergeSort[4]);
		
//		HistogramDataset grafico = new HistogramDataset();
//		grafico.addSeries("key", tempoInsertionSort, 5);
//		
//		JFreeChart oGraficoAqui = ChartFactory.createHistogram("La ele", "Algoritmos", "tempo", grafico);
//		
//		ChartUtils.saveChartAsPNG(new File("laEle.png"), oGraficoAqui, 500, 500);

	}

	private static void rodarOrdenacao(int[] vetor, int pos) {
		long tempoInicial = System.currentTimeMillis();
		insertionSort(vetor);
		long tempoFinal = System.currentTimeMillis();
		tempoInsertionSort[pos] = (tempoFinal - tempoInicial);

		tempoInicial = System.currentTimeMillis();
		bubbleSort(vetor);
		tempoFinal = System.currentTimeMillis();
		tempoBubbleSort[pos] = (tempoFinal - tempoInicial);

		try {
			tempoInicial = System.currentTimeMillis();
			quickSort(vetor, 0, vetor.length - 1);
			tempoFinal = System.currentTimeMillis();
			tempoQuickSort[pos] = (tempoFinal - tempoInicial);
		} catch (StackOverflowError e) {
			tempoQuickSort[pos] = -1;
		}

		tempoInicial = System.currentTimeMillis();
		selectionSort(vetor);
		tempoFinal = System.currentTimeMillis();
		tempoSelectionSort[pos] = (tempoFinal - tempoInicial);

		tempoInicial = System.currentTimeMillis();
		shellSort(vetor);
		tempoFinal = System.currentTimeMillis();
		tempoShellSort[pos] = (tempoFinal - tempoInicial);

		tempoInicial = System.currentTimeMillis();
		mergeSort(vetor, vetor.length);
		tempoFinal = System.currentTimeMillis();
		tempoMergeSort[pos] = (tempoFinal - tempoInicial);
	}

	private static int[] gerarNumerosAleatorios(int tam) {
		int[] array = new int[tam];
		for (int i = 0; i < tam; i++) {
			array[i] = (int) (Math.random() * tam);
		}
		return array;
	}

	private static int[] gerarNumerosCrescentes(int tam) {
		int[] array = new int[tam];
		int num = 0;
		for (int i = 0; i < tam; i++) {
			array[i] = num;
			num += 2;
		}
		return array;
	}

	private static int[] gerarNumerosDecrescentes(int tam) {
		int[] array = new int[tam];
		int num = tam;
		for (int i = 0; i < tam; i++) {
			array[i] = num;
			num--;
		}
		return array;
	}

	// INSERTION SORT
	private static void insertionSort(int[] vetor) {
		int j;
		int i;
		int key;

		for (j = 1; j < vetor.length; j++) {
			key = vetor[j];
			for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) {
				vetor[i + 1] = vetor[i];
			}
			vetor[i + 1] = key;
		}
	}

	// BUBBLE SORT
	private static void bubbleSort(int[] vetor) {
		boolean troca = true;
		int aux;
		while (troca) {
			troca = false;
			for (int i = 0; i < vetor.length - 1; i++) {
				if (vetor[i] > vetor[i + 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
					troca = true;
				}
			}
		}
	}

	// QUICK SORT
	private static void quickSort(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = dividir(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivo - 1);
			quickSort(vetor, posicaoPivo + 1, fim);
		}
	}

	private static int dividir(int[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[f])
				f--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}

	// SELECTION SORT
	private static void selectionSort(int[] array) {
		for (int fixo = 0; fixo < array.length - 1; fixo++) {
			int menor = fixo;

			for (int i = menor + 1; i < array.length; i++) {
				if (array[i] < array[menor]) {
					menor = i;
				}
			}
			if (menor != fixo) {
				int t = array[fixo];
				array[fixo] = array[menor];
				array[menor] = t;
			}
		}
	}

	// SHELL SORT
	private static void shellSort(int[] arrayToSort) {
		int n = arrayToSort.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int key = arrayToSort[i];
				int j = i;
				while (j >= gap && arrayToSort[j - gap] > key) {
					arrayToSort[j] = arrayToSort[j - gap];
					j -= gap;
				}
				arrayToSort[j] = key;
			}
		}
	}

	// MERGE SORT
	private static void mergeSort(int[] a, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(a, l, r, mid, n - mid);
	}

	private static void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}

}
