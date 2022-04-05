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
	
	public NoDuplaInt pesquisaAoContrario(int info) {
		NoDuplaInt aux = getUlt();
		while (aux != null && aux.getInfo() != info) {
			aux = aux.getAnt();
		}
		return aux;
	}
	
	public boolean remove(int info) {
		NoDuplaInt aux = getPrim();
		while (aux != null && aux.getInfo() != info) {
			aux = aux.getProx();
		}
		if (aux == null) {
			return false;
		}
		aux.getAnt().setProx(aux.getProx());
		aux.getProx().setAnt(aux.getAnt());
		aux.setProx(null);
		aux.setAnt(null);
		return true;
	}

}
