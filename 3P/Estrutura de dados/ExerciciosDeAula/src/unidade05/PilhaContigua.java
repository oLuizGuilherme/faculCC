package unidade05;

public class PilhaContigua {
	
	private int[] vet;
	private int nElem;
	
	public PilhaContigua() {
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
	
	public int topo() {
		return vet[nElem - 1];
	}
	
	public void push(int elemento) {
		if (!eCheia()) {
			vet[nElem] = elemento;
			nElem++;
		}
		
	}
	
	public int pop() {
		if (!eVazia()) {
			int top = topo();
			nElem--;
			return top;
		}
		return 999999999;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < nElem; i++) {
			string.append(vet[i]+ " ");
		}
		return string.toString();
	}

}
