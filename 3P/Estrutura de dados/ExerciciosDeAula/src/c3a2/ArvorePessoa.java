package c3a2;

public class ArvorePessoa {

	private NoPessoa raiz;
	private int nElem;

	public ArvorePessoa() {
		this.nElem = 0;
	}

	public boolean eVazia() {
		if (this.raiz == null) {
			return true;
		} else {
			return false;
		}
	}

	public NoPessoa getRaiz() {
		return raiz;
	}

	public int getnElem() {
		return nElem;
	}

	public NoPessoa pesquisar(Pessoa pessoa) {
		return pesquisar(pessoa, this.raiz);
	}

	private NoPessoa pesquisar(Pessoa pessoa, NoPessoa no) {
		if (no == null) {
			return null;
		} else {
			if (pessoa.getCpf() < no.getPessoa().getCpf()) {
				no = pesquisar(pessoa, no.getEsq());
			} else if (pessoa.getCpf() > no.getPessoa().getCpf()) {
				no = pesquisar(pessoa, no.getDir());
			}
			return no;
		}
	}

	public boolean inserir(Pessoa pessoa) {
		if (this.pesquisar(pessoa) != null) {
			return false;
		} else {
			this.raiz = inserir(pessoa, this.raiz);
			this.nElem++;
			return true;
		}
	}

	private NoPessoa inserir(Pessoa pessoa, NoPessoa no) {
		if (no == null) {
			NoPessoa novo = new NoPessoa(pessoa);
			return novo;
		} else {
			if (pessoa.getCpf() > no.getPessoa().getCpf()) {
				no.setDir(inserir(pessoa, no.getDir()));
			} else {
				no.setEsq(inserir(pessoa, no.getEsq()));
			}
			return no;
		}
	}

	public boolean remover(Pessoa pessoa) {
		if (remover(pessoa, this.raiz) == null) {
			return false;
		}
		return true;
	}
	
	private NoPessoa remover(Pessoa pessoa, NoPessoa no) {
		if (no == null) {
			return null;
		} else if (pessoa.getCpf() > no.getPessoa().getCpf()) {
			no.setDir(remover(pessoa, no.getDir()));
		} else if (pessoa.getCpf() < no.getPessoa().getCpf()) {
			no.setEsq(remover(pessoa, no.getEsq()));
		} else if (no.getDir() == null) {
			this.nElem--;
			return no.getEsq();
		} else if (no.getEsq() == null) {
			this.nElem--;
			return no.getDir();
		} else {
			no.setEsq(arruma(no, no.getEsq()));
			this.nElem--;
		}
		return no;
	}
	
	private NoPessoa arruma(NoPessoa no, NoPessoa maior) {
		if (maior.getDir() != null) {
			maior.setDir(arruma(no, maior.getDir()));
			return maior;
		} else {
			no.setPessoa(maior.getPessoa());
			return maior.getEsq();
		}
	}
	
	public LCPessoa camInOrdem() {
		LCPessoa vetor = new LCPessoa(this.nElem);
		return camInOrdem(vetor, this.raiz);
	}
	
	private LCPessoa camInOrdem(LCPessoa vetor, NoPessoa no) {
		if (no != null) {
			vetor =  camInOrdem(vetor, no.getEsq());
			vetor.insereFim(no.getPessoa());
			vetor = camInOrdem(vetor, no.getDir());
		}
		return vetor;
	}

}
