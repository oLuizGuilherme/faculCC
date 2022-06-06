package unidade05;

public class FilaContigua {
	
	private int[] vet;
	private int nElem;
	
	public FilaContigua() {
		vet = new int[10];
		nElem = 0;
	}
	
	public boolean eVazia() {
		return nElem == 0;
	}
	
	public boolean eCheia() {
		return nElem == vet.length;
	}
	
	public int tamanho() {
		return nElem;
	}
	
	public int head() {
		return vet[0];
	}
	
	public int tail() {
		return vet[nElem -1];
	}
	
	public void enqueue(int elemento) {
		if (eCheia()) {
			return;
		}
		if (!eVazia()) {
			for (int i = nElem -1; i >= 0; i--) {
				vet[i+1] = vet[i];
			}
		}
		vet[0] = elemento;
		nElem++;
	}
	
	public int dequeue() {
		if (eVazia()) {
			return 999999999;
		}
		int tail = tail();
		nElem--;
		return tail;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (int i = nElem -1; i >= 0; i--) {
			string.append(vet[i] + " ");
		}
		return string.toString();
	}

}
