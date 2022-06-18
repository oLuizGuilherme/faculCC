package c3a2;

public class NoPessoa {

	private Pessoa pessoa;
	private NoPessoa esq;
	private NoPessoa dir;

	public NoPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public NoPessoa getEsq() {
		return esq;
	}

	public void setEsq(NoPessoa prox) {
		this.esq = prox;
	}

	public NoPessoa getDir() {
		return dir;
	}

	public void setDir(NoPessoa dir) {
		this.dir = dir;
	}

}
