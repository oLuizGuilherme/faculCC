package c1a2.luana;

import io.InOut;

public class AppPilhaFila {
//Imprima o valor que est� no topo da pilha e no in�cio da fila.

	public static void main(String[] args) {
		PilhaInteiro pilha = new PilhaInteiro();
		FilaInteiro fila = new FilaInteiro();
		Integer elemento;

		elemento = InOut.leInt("Entre com um inteiro ou 0 para sair: ");

		while (elemento != 0) {

			if (elemento % 2 == 0) {
				pilha.push(elemento);
			} else {
				fila.enqueue(elemento);
			}
			elemento = InOut.leInt("Entre com um inteiro ou 0 para sair: ");
		}

		InOut.msgDeInformacao("IMPRESS�O", "PILHA: " + pilha.top());
		InOut.msgDeInformacao("IMPRESS�O", "FILA: " + fila.peek());

	}

}
