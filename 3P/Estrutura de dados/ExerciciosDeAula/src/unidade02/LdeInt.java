package unidade02;

public class LdeInt {

	private NoDuplaInt prim;
	private NoDuplaInt ult;
	private int nElem;

	public LdeInt() {
	}

	public NoDuplaInt getPrim() {
		return prim;
	}

	public void setPrim(NoDuplaInt prim) {
		this.prim = prim;
	}

	public NoDuplaInt getUlt() {
		return ult;
	}

	public void setUlt(NoDuplaInt ult) {
		this.ult = ult;
	}

	public int getnElem() {
		return nElem;
	}

	public boolean eVazia() {
		return nElem == 0;
	}

	public void insereUltimo(int info) {
		NoDuplaInt novoNo = new NoDuplaInt(info);
		if (eVazia()) {
			setPrim(novoNo);
			setUlt(novoNo);
			nElem++;
			return;
		}
		getUlt().setProx(novoNo);
		novoNo.setAnt(getUlt());
		setUlt(novoNo);
		nElem++;
	}

	public void insereInicio(int info) {
		NoDuplaInt novoNo = new NoDuplaInt(info);
		if (eVazia()) {
			setPrim(novoNo);
			setUlt(novoNo);
			nElem++;
			return;
		}
		getPrim().setAnt(novoNo);
		novoNo.setProx(getPrim());
		setPrim(novoNo);
		nElem++;
	}

	public NoDuplaInt pesquisa(int info) {
		NoDuplaInt aux = getPrim();
		while (aux != null && aux.getInfo() != info) {
			aux = aux.getProx();
		}
		return aux;
	}

	public boolean remove(int info) {
		NoDuplaInt aux = pesquisa(info);
		if (aux == null) {
			return false;
		}
		if (nElem == 1) {
			setPrim(null);
			setUlt(null);
		} else if (aux == getPrim()) {
			setPrim(aux.getProx());
			aux.getProx().setAnt(null);
		} else if (aux == getUlt()) {
			setUlt(aux.getAnt());
			aux.getAnt().setProx(null);
		} else {
			aux.getAnt().setProx(aux.getProx());
			aux.getProx().setAnt(aux.getAnt());
		}
		nElem--;
		return true;
	}

	public void concatena(LdeInt lista1) {
		if (!lista1.eVazia()) {
			if (eVazia()) {
				this.setPrim(lista1.getPrim());
				this.setUlt(lista1.getUlt());
				this.nElem = lista1.getnElem();
			}
			this.getUlt().setProx(lista1.getPrim());
			lista1.getPrim().setAnt(this.getUlt());
			this.setUlt(lista1.getUlt());
			this.nElem += lista1.getnElem();
		}
	}

}
