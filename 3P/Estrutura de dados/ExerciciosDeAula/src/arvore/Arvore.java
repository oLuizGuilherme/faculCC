package arvore;

import unidade02.LCInteiro;

public class Arvore {
	private NoArv raiz;
	private int nElem; // opcional
	/**
	 * 
	 */
	public Arvore() {
		this.nElem = 0;
	}
	public boolean eVazia() {
		if (this.raiz==null) {// this.nElem==0
			return true;
		}else{
			return false;
		}
	}
	public NoArv getRaiz() {
		return raiz;
	}
	public int getnElem() {
		return nElem;
	}
	
	public NoArv pesquisar (int elem) {
		return pesquisar (elem, this.raiz);
	}
	private NoArv pesquisar (int elem, NoArv no) {
		if (no == null) {
			return null;
		}else {
			if (elem < no.getInfo()) {
				no = pesquisar(elem, no.getEsq());
			}else if (elem > no.getInfo()) {
				no = pesquisar(elem, no.getDir());
			}
			return no;
		}
	}
	
	/*
	 * inserir elemento na arvore
	 */
	public boolean inserir (int elem) {
		if (this.pesquisar(elem) != null) {
			return false;
		}else {
			this.raiz = inserir (elem, this.raiz);
			this.nElem++;
			return true;
		}
	}
	private NoArv inserir (int elem, NoArv no) {
		if (no == null) {
			NoArv novo = new NoArv(elem);
			return novo;
		}else {
			String nome;
			// Se o arvore fosse de String
			//if (nome.compareToIgnoreCase(no.getInfo())>0)
			if (elem > no.getInfo()) {
				no.setDir(inserir(elem, no.getDir()));
			}else {
				no.setEsq(inserir(elem, no.getEsq()));
			}
			return no;
		}
	}
	
	public boolean remover (int elem) {
		if (remover(elem, this.raiz) == null) {
			return false;
		}
		return true;
	}
	private  NoArv remover (int elem, NoArv no) {
		if (no == null) {
			return null;
		}else if (elem > no.getInfo()) {
			no.setDir(remover(elem, no.getDir()));
		}else if (elem < no.getInfo()) {
			no.setEsq(remover (elem, no.getEsq()));
		}else if (no.getDir() == null){
			this.nElem--;
			return no.getEsq();
		}else if (no.getEsq() == null) {
			this.nElem--;
			return no.getDir();
		}else {
			no.setEsq(arruma (no, no.getEsq()));
			this.nElem--;
		}
		return no;
	}
	private NoArv arruma (NoArv no, NoArv maior) {
		if (maior.getDir() != null) {
			maior.setDir(arruma(no, maior.getDir()));
			return maior;
		} else {
			no.setInfo(maior.getInfo());
			return maior.getEsq();
		}
	}
	public LCInteiro CamCentral () {
		LCInteiro vetor = new LCInteiro(this.nElem);
		return (fazCamCentral(vetor, this.raiz));
	}
	private LCInteiro fazCamCentral (LCInteiro vetor, NoArv no) {
		if (no != null) {
			vetor = fazCamCentral(vetor, no.getEsq());
			vetor.insereFim(no.getInfo());
			vetor = fazCamCentral(vetor, no.getDir());
		}
		return vetor;
	}
	
	public LCInteiro CamPreOrdem () {
		LCInteiro vetor = new LCInteiro(this.nElem);
		return (fazCamPreOrdem(vetor, this.raiz));
	}
	private LCInteiro fazCamPreOrdem (LCInteiro vetor, NoArv no) {
		if (no != null) {
			vetor.insereFim(no.getInfo());
			vetor = fazCamPreOrdem(vetor, no.getEsq());
			vetor = fazCamPreOrdem(vetor, no.getDir());
		}
		return vetor;
	}
	public LCInteiro CamPosOrdem () {
		LCInteiro vetor = new LCInteiro(this.nElem);
		return (fazCamPosOrdem(vetor, this.raiz));
	}
	private LCInteiro fazCamPosOrdem (LCInteiro vetor, NoArv no) {
		if (no != null) {
			vetor = fazCamPosOrdem(vetor, no.getEsq());
			vetor = fazCamPosOrdem(vetor, no.getDir());
			vetor.insereFim(no.getInfo());
		}
		return vetor;
	}
	
	public Arvore balancear () {
		Arvore arv = new Arvore();
		LCInteiro vetor = CamCentral();
		balancear (vetor, arv, 0, vetor.getNElem()-1);
		return arv;
	}
	
	private void balancear (LCInteiro vetor, Arvore arv, 
			int inicio, int fim) {
		int meio;
		if (fim >= inicio) {
			meio = (fim+inicio)/2;
			arv.inserir(vetor.getNum(meio));
			balancear (vetor, arv, inicio, meio-1 );
			balancear (vetor, arv, meio + 1, fim);
		}
	}	
}
