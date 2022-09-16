package c1a2;

import io.InOut;

public class LinkedListApp {

	public static void main(String[] args) {

		FilaInteiro fila = new FilaInteiro();
		PilhaInteiro pilha = new PilhaInteiro();

		int leInt = InOut.leInt("Insira um número");

		while (leInt != 0) {
			if (leInt % 2 == 0) {
				pilha.push(leInt);
			} else {
				fila.enqueue(leInt);
			}
			leInt = InOut.leInt("Insira um número");
		}
		
		String msgPilha;
		String msgFila;

		if (!pilha.eVazia()) {
			msgPilha = "O valor no topo da pilha é " + pilha.top();
		} else {
			msgPilha = "A pilha está vazia.";
		}
		if (!fila.eVazia()) {
			msgFila = "O valor no início da fila é " + fila.primeiro();
		} else {
			msgFila = "A fila está vazia.";
		}
		
		InOut.msgDeInformacao("Informação", msgPilha + "\n" + msgFila);

	}

}
