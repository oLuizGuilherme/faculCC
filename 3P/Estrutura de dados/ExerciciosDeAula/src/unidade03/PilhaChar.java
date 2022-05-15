package unidade03;

public class PilhaChar {

	private NoChar top;
	private int nElem;
	
	public PilhaChar() {
	}
	
	public boolean isEmpty() {
		if (nElem == 0)
			return true;
		else
			return false;
	}

	public void push(char num) {
		NoChar nodo = new NoChar(num);

		if (!this.isEmpty()) {
			nodo.setProx(this.top);
		}
		this.top = nodo;
		this.nElem++;
	}

	public NoChar pop() {
		NoChar aux = this.top;
		if (!this.isEmpty()) {
			this.top = aux.getProx();
			aux.setProx(null);
			this.nElem--;
		}
		return aux;
	}

	public int size() {
		return nElem;
	}

	public NoChar top() {
		return top;
	}

	public String toString() {
		String str = "";
		NoChar aux = this.top;
		for (int i = 0; i < this.nElem; i++) {
			str = str + aux.getInfo() + "  |  ";
			aux = aux.getProx();
		}
		return str;
	}

}
