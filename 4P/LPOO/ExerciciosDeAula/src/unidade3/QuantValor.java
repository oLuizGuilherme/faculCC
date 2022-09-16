package unidade3;

import java.util.ArrayList;

import io.InOut;

/**
 * 
 * @author lauana.nakasuga
 *
 */
public class QuantValor {
	/*
	 * Faça um programa que 1 - preencha um ArrayList ou uma LinkedList com
	 * números inteiros, 2 - mostre essa lista na tela, 3 - peça ao usuário um
	 * número 4 - mostre na tela a quantidade de vezes que esse número aparece na
	 * lista.
	 */
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(2);
		lista.add(8);
		lista.add(2);
		lista.add(10);
		lista.add(5);
		lista.add(5);
		lista.add(10);
		lista.add(10);
		lista.add(5);
		lista.add(5);
		String menu = "1 - Imprimir a lista.\n2 - Quantidade que aparece.\n3 - Sair.";
		int opcao = 0;
		do {
			opcao = InOut.leInt(menu);
			switch (opcao) {
			case 1:
				imprimir(lista);
				break;
			case 2:
				quantidade(lista);
				break;
			case 3:
				break;
			default:
				break;
			}

		} while (opcao != 3);
	}

	private static void imprimir(ArrayList<Integer> lista) {
		InOut.msgDeInformacao("LISTA", lista + "");
	}

	private static void quantidade(ArrayList<Integer> lista) {
		Integer quant = 0;
		Integer numero = InOut.leInt("Digite o n�mero a ser pesquisado na lista:\n");
		for (Integer i : lista) {
			if (i == numero) {
				quant++;
			}
		}
		InOut.msgDeInformacao("LISTA", "O n�mero aparece: " + quant + " vezes.");
	}

}
