package unidade02;

public class LCVeiculo {

	private Veiculo[] listaCont;
	private int nElem;

	public LCVeiculo(int tam) {
		listaCont = new Veiculo[tam];
		nElem = 0;
	}

	public int getnElem() {
		return nElem;
	}

	public Veiculo[] getListaCont() {
		return listaCont;
	}

	public void setListaCont(Veiculo[] listaCont) {
		this.listaCont = listaCont;
	}

	public boolean insere(Veiculo veiculo, int pos) {

		if (pos < 0 || pos >= this.listaCont.length) {
			return false;
		}
		if (eCheio()) {
			Veiculo[] maior = new Veiculo[(int) (this.listaCont.length * 1.5)];
			for (int i = 0; i < this.listaCont.length; i++) {
				maior[i] = this.listaCont[i];
			}
			this.listaCont = maior;
		}
		if (eVazia()) {
			this.listaCont[pos] = veiculo;
			this.nElem++;
			return true;
		}
		this.listaCont[nElem] = this.listaCont[pos];
		this.listaCont[pos] = veiculo;
		this.nElem++;
		return true;
	}

	public boolean eCheio() {
		return this.listaCont.length == this.nElem;
	}

	public boolean eVazia() {
		return nElem == 0;
	}

	public Veiculo getVeiculo(int pos) {
		return this.listaCont[pos];
	}

	public void insereFim(Veiculo veiculo) {
		if (eCheio()) {
			Veiculo[] maior = new Veiculo[(int) (this.listaCont.length * 1.5)];
			for (int i = 0; i < this.listaCont.length; i++) {
				maior[i] = this.listaCont[i];
			}
			this.listaCont = maior;
		}
		this.listaCont[nElem] = veiculo;
		this.nElem++;
	}

	public void remove(int pos) {
		this.listaCont[pos] = this.listaCont[nElem];
		this.nElem--;
	}
	
	public void remove(String placa) {
		int pos = 0;
		boolean encontrou = false;
		for (int i = 0; i < this.nElem; i++) {
			if (this.listaCont[i].getPlaca().equals(placa)) {
				pos = i;
				encontrou = true;
			}
		}
		if (encontrou) {
			remove(pos);
		}
	}

	public Veiculo pesquisa(String placa) {
		for (int i = 0; i < this.nElem; i++) {
			if (this.listaCont[i].getPlaca().equals(placa)) {
				return this.listaCont[i];
			}
		}
		return null;
	}

	public Veiculo[] pesquisaMarca(String marca) {
		Veiculo[] aux = new Veiculo[this.nElem];
		int cont = 0;
		for (int i = 0; i < this.nElem; i++) {
			if (this.listaCont[i].getMarca().equals(marca)) {
				aux[cont] = this.listaCont[i];
				cont++;
			}
		}
		return aux;
	}

}
