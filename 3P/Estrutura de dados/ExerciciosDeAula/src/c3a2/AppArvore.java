package c3a2;

import io.InOut;

public class AppArvore {

	private static String menuMsg = "1- Votar \n2- Resultados \n3- Sair";
	private static ArvorePessoa arvore;
	private static int votosSim, votosNao;

	public static void main(String[] args) {
		arvore = new ArvorePessoa();
		votosNao = 0;
		votosSim = 0;
		
		menu();

	}

	private static void menu() {
		boolean valido = false;
		while (!valido) {
			int op = InOut.leInt(menuMsg);
			switch (op) {
			case 1:
				votar();
				break;
			case 2:
				resultados();
				break;
			case 3:
				valido = true;
				break;
			default:
				InOut.msgDeErro("OPÇÃO INVÁLIDA", "Por favor escolha uma opção válida.");
				break;
			}

		}
	}

	private static void votar() {
		long cpf = InOut.leLong("Por favor informe o cpf do eleitor.");
		Pessoa pessoa = new Pessoa("", cpf);
		boolean votou = arvore.pesquisar(pessoa) != null;

		if (votou) {
			InOut.msgDeErro("Voto já computado",
					"Voto do cpf " + cpf + " já computado.\nNão é possível votar mais de uma vez.");
			return;
		}

		computarVotacao(pessoa);

	}

	private static void computarVotacao(Pessoa pessoa) {

		boolean valido = false;

		while (!valido) {
			int op = InOut.leInt("1- SIM. \n2- NÃO. \n3- CANCELAR.");
			switch (op) {
			case 1:
				valido = true;
				votosSim++;
				arvore.inserir(pessoa);

				break;
			case 2:
				valido = true;
				votosNao++;
				arvore.inserir(pessoa);

				break;
			case 3:
				valido = true;
				break;
			default:
				InOut.msgDeErro("OPÇÃO INVÁLIDA", "Por favor escolha uma opção válida.");
				break;
			}
		}
	}

	private static void resultados() {

		InOut.msgDeInformacao("RESULTADO DA VOTAÇÃO",
				"Quantidade de votos\nVotos sim: " + votosSim + ".\nVotos não: " + votosNao + ".");

	}

}
