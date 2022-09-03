package c1a1;

import io.InOut;

public class AppCliente {

	private static Cliente[] vetor = new Cliente[10];

	public static void main(String[] args) {

		menu();

	}

	private static void menu() {
		String menu = "1 - Gerar senha\n2 - Atendimento\n3 - Sair";
		int opcao;

		do {
			opcao = InOut.leInt(menu);

			switch (opcao) {
			case 1:
				gerarSenha();
				break;
			case 2:
				atendimento();
				break;
			}
		} while (opcao != 3);

	}

	private static void gerarSenha() {
		String nome = InOut.leString("Informe seu nome");
		boolean salvou = false;
		Cliente cliente = null;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == null) {
				cliente = new Cliente(nome);
				vetor[i] = cliente;
				salvou = true;
				break;
			}
		}
		if (salvou) {
			InOut.msgDeInformacao("SUA SENHA", cliente.getSenha() + "");
		} else {
			InOut.msgDeAviso("AVISO", "Não existe mais espaço para atendimento. Tente novamente mais tarde.");
		}
	}

	private static void atendimento() {
		Cliente.proximo();
		boolean existe = false;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i]!= null && vetor[i].getSenha() == Cliente.getSenhaGeral()) {
				existe = true;
				Cliente cliente = vetor[i];
				vetor[i] = null;
				InOut.msgDeAviso("AVISO", "O próximo cliente é " + cliente.toString());
				break;
			}
		}
		if (!existe) {
			InOut.msgDeAviso("AVISO", "Não existem clientes para serem atendidos");
		}

	}

}
