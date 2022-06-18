package c3a2;

public class LCPessoa {

	private Pessoa[] listaCont;
	private int nElem;

	public LCPessoa(int tam) {
		this.listaCont = new Pessoa[tam];
		this.nElem = 0;
	}

	public Pessoa getPessoa(int posicao) {
		if (posicao >= 0 && posicao < this.nElem) {
			return this.listaCont[posicao];
		} else {
			return null;
		}
	}

	public int getnElem() {
		return nElem;
	}

	public int tamanho() {
		return listaCont.length;
	}

	public boolean eVazio() {
		return nElem == 0;
	}

	public boolean eCheio() {
		return nElem == listaCont.length;
	}

	public int pesquisa(Pessoa pessoa) {
		for (int i = 0; i < this.nElem; i++) {
			if (pessoa.getCpf() == listaCont[i].getCpf())
				return i;
		}
		return -1;
	}

	public void insereFim(Pessoa pessoa) {
		if (this.eCheio()) {
			int tam = (int) (this.listaCont.length * 1.5);
			Pessoa[] maior = new Pessoa[tam];
			for (int i = 0; i < this.nElem; i++) {
				maior[i] = this.listaCont[i];
			}
			this.listaCont = maior;
		}
		this.listaCont[this.nElem] = pessoa;
		this.nElem++;
	}
	
	public boolean remove (Pessoa pessoa) {
		int pos = this.pesquisa(pessoa);
		if (pos == -1) {
			return false;
		}else {
			this.listaCont[pos] = this.listaCont[this.nElem-1];
			this.nElem--;
			return true;
		}
	}
	
	public String toString () {
		String aux;
		if (this.eVazio()) {
			return "";
		}else {
			aux = "| ";
			for (int i=0; i<this.nElem; i++) {
				aux += this.listaCont[i] +" | ";
			}
		}
		return aux;
	}

}
