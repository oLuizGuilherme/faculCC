package unidade03;

public class NoContato {
	
	private Contato contato;
	private NoContato prox;

	public NoContato(Contato contato) {
		this.contato = contato;
	}

	public Contato getInfo() {
		return contato;
	}

	public void setInfo(Contato info) {
		this.contato = info;
	}

	public NoContato getProx() {
		return prox;
	}

	public void setProx(NoContato prox) {
		this.prox = prox;
	}

	public String toString() {
		return this.contato + "";
	}



}
