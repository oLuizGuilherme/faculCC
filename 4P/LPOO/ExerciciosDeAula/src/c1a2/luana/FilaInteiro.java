package c1a2.luana;

import java.util.LinkedList;

/*
 * Verificar se a fila está vazia (isEmpty)
 * Enfileirar (enqueue): Inserir um elemento no final da fila
 * Desenfileirar (dequeue): Remover o elemento do início da fila
 * Retornar o tamanho da fila (size)
 * Retorna o elemento do início da fila (peek)
 */
public class FilaInteiro {

	private LinkedList<Integer> fila;

	public FilaInteiro() {
		fila = new LinkedList<Integer>();
	}

	public boolean isEmpty() {
		return fila.isEmpty();
	}

	public void enqueue(Integer elem) {
		fila.addLast(elem);
	}

	public void dequeue() {
		fila.removeFirst();
	}

	public Integer size() {
		return fila.size();
	}

	public Integer peek() {
		return fila.peek();
	}
}
