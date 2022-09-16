package c1a2;

import java.util.LinkedList;

public class FilaInteiro {
	
	private LinkedList<Integer> fila;
	
	public FilaInteiro() {
		fila = new LinkedList<>();
	}
	
	public boolean eVazia() {
		return fila.isEmpty();
	}
	
	public void enqueue(int num) {
		fila.addLast(num);
	}
	
	public Integer dequeue() {
		return fila.removeFirst();
	}
	
	public int tamanho() {
		return fila.size();
	}
	
	public Integer primeiro() {
		return fila.getFirst();
	}

}
