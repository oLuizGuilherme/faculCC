package unidade02;

public class LCInteiro {
	private int[] listaCont;
	private int nElem;
	
	public LCInteiro (int tamanho) {
		this.listaCont = new int[tamanho];
		this.nElem = 0;
	}
	/* getNum (posicao) => retorna o elemento que esta na posicao (parametro). 
	 * Caso a posicao não seja valida, retorna null.
	 */
	public Integer getNum (int posicao) {
		if (posicao>=0 && posicao<this.nElem) { // verifica se a posicao e valida
			return this.listaCont[posicao];
		}else {
			return null;
		}	
	}
	/*
	 * getNElem() => retorna a quantidade de elementos da lista.
	 */
	public int getNElem() {
		return this.nElem;
	}
	/*
	 * tamanho () => retorna o tamanho do vetor
	 */
	public int tamanho() {
		return this.listaCont.length;
	}
	/*
	 * eVazio() => retorna verdadeiro se a lista estiver vazia e 
	 * falso caso contrário.
	 */
	public boolean eVazio () {
		if (this.nElem==0) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * eCheio() => retorna verdadeiro se a lista estiver cheia e 
	 * falso caso contrário.
	 */
	public boolean eCheio () {
		if (this.nElem==this.listaCont.length) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * pesquisa (num) => deve fazer uma pesquisa sequencial até encontrar num, 
	 * retornando sua posição. Se ele não existir, deve retornar -1
	 */
	public int pesquisa(int num) {
		for (int i=0; i<this.nElem; i++) {
			if (this.listaCont[i]==num)
				return i;
		}
		return -1;
	}
	/*
	 * insereFim (num) => insere um número no final da lista e retorna 0. 
	 * Se ela estiver cheia, não deve inserir e deve retornar -1.
	 */
	public void insereFim(int num) {
		if (this.eCheio()) {
			// aumenta o vetor em 1.5
			int tam = (int)(this.listaCont.length*1.5);
			int[] maior = new int[tam];
			for (int i=0; i<this.nElem; i++) {
				maior[i] = this.listaCont[i];
			}
			this.listaCont = maior;
		}
		this.listaCont[this.nElem] = num;
		this.nElem++;
	}
	/*
	 * deve remover um elemento da lista. 
	 * Se conseguir, deve retornar true, se não conseguir, 
	 * retorna false.
	 */
	public boolean remove (int num) {
		int pos = this.pesquisa(num);
		if (pos == -1) {
			return false;
		}else {
			this.listaCont[pos] = this.listaCont[this.nElem-1];
			this.nElem--;
			return true;
		}
	}
	/*
	 * retornar uma String contendo todos os elementos da lista, 
	 * do primeiro até o último.
	 */
	public String toString () {
		String aux;
		if (this.eVazio()) {
			return "";
		}else {
			aux = "| ";
			for (int i=0; i<this.nElem; i++) {
				aux += this.listaCont[i]+" | ";
			}
		}
		return aux;
	}
}
