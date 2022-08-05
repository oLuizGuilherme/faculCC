package c3a2;

import io.InOut;

public class AppArvore {

	private static String menuMsg = "1- Votar \n2- Resultados \n3- Sair";
	private static ArvorePessoa arvore;

	public static void main(String[] args) {
		arvore = new ArvorePessoa();

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
		String nome = InOut.leString("Informe o nome do eleitor.");
		long cpf = InOut.leLong("Informe o cpf do eleitor.");
		Pessoa pessoa = new Pessoa(nome, cpf);
		NoPessoa pesquisar = arvore.pesquisar(pessoa);
		boolean votou = pesquisar != null;

		if (votou) {
			InOut.msgDeErro("Voto já computado",
					"O voto de " + pesquisar.getPessoa().getNome() + " com o cpf " + cpf + " já foi computado.\nNão é possível votar mais de uma vez.");
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
				pessoa.setVoto(1);
				arvore.inserir(pessoa);

				break;
			case 2:
				valido = true;
				pessoa.setVoto(2);
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

		int votosSim = contaVotosSim();

		InOut.msgDeInformacao("RESULTADO DA VOTAÇÃO",
				"Quantidade de votos\nVotos sim: " + votosSim + ".\nVotos não: " + (arvore.getnElem() - votosSim) + ".");

	}

	private static int contaVotosSim() {
		if (arvore.eVazia()) {
			return 0;
		}

		LCPessoa vetor = new LCPessoa(arvore.getnElem());
		vetor = camArvoreInOrdem(vetor, arvore.getRaiz());

		return vetor.getnElem();
	}

	private static LCPessoa camArvoreInOrdem(LCPessoa vetor, NoPessoa no) {
		if (no != null) {
			vetor =  camArvoreInOrdem(vetor, no.getEsq());
			if (no.getPessoa().getVoto() == 1) {
				vetor.insereFim(no.getPessoa());
			}
			vetor = camArvoreInOrdem(vetor, no.getDir());
		}
		return vetor;
	}

}
