package unidade03;

public class FilaChar {
	
	private int nElem;
	private NoChar head, tail;
	
	public FilaChar() {
	}
	
	public boolean isEmpty() {
		if (nElem==0) {
			return true;
		}
		return false;
	}
	 
	// Retornar o tamanho da fila (size)
	public int size() {
		return nElem;
	}
	
	// Retorna o elemento do inicio da fila (peek)
	public NoChar peek () {
		return head;
	}
	
	// Enfileirar (enqueue): Inserir um elemento no final da fila
	public void enqueue (char info) {
		NoChar aux = new NoChar(info);
		
		if (this.isEmpty()) {
			this.head = aux;
			this.tail = aux;
		} else {
			this.tail.setProx(aux);
			this.tail = aux;
		}
		this.nElem++;
	}
	
	// Desenfileirar (dequeue): Remover o elemento do inicio da fila
	public NoChar dequeue () {
		NoChar aux;
		if (this.isEmpty()) {
			return null;
		} else if (this.nElem==1) {
			aux = this.head;
			this.head = null;
			this.tail = null;
		} else {
			aux = this.head;
			this.head = this.head.getProx();
		}
		this.nElem--;
		return aux;
	}
	
	public String toString() {
		String str = "";
		NoChar aux = this.head;
		
		while (aux!= null) {
			str += aux.getInfo()+"   ";
			aux = aux.getProx();
		}
		return str;
	}

}
