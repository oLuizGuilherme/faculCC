package c1a2.renato;

import java.util.LinkedList;

/*Implemente uma classe FilaInteiro, cujo atributo � uma LinkedList,
que vai armazenar uma fila de inteiros com as opera��es:
1. Verificar se a fila est� vazia
2. Enqueue (Inserir um elemento no fim da fila)
3. Dequeue (Remover o elemento do in�cio da fila)
4. Retornar o tamanho da fila
5. Retorna o primeiro*/

public class FilaInteiro {

	private LinkedList<Integer> fila;
	
	public FilaInteiro() {
		fila = new LinkedList<>();
	}

	public boolean filaVazia() {
		return fila.isEmpty();
	}
	
	public void enqueue(int numero) {
		fila.addLast(numero);
	}
	
	public Integer dequeue() {
		return fila.removeFirst();
	}
	
	public Integer tamanhoFila() {
		return fila.size();
	}
	
	public Integer primeiroFila() {
		return fila.peekFirst();
	}
	
}
