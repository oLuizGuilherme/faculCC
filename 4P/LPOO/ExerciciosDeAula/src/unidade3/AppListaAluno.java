package unidade3;

import java.util.ArrayList;

import io.InOut;

public class AppListaAluno {

	public static void main(String[] args) {
		ArrayList<Aluno> alunoLst = new ArrayList<>();

		String menu = "1. Insere Aluno\n2. Remove Aluno\n3. Altera Nota\n4. Mostra Aluno\n5. Imprime Todos\n6. Sair";

		menu(alunoLst, menu);
	}
	
	private static void menu(ArrayList<Aluno> alunoLst, String menu) {
		
		int opcao = 0;
		do {
			opcao = InOut.leInt(menu);
			switch (opcao) {
			case 1:
				insereAluno(alunoLst);
				break;
			case 2:
				removeAluno(alunoLst);
				break;
			case 3:
				alteraNota(alunoLst);
				break;
			case 4:
				mostraAluno(alunoLst);
				break;
			case 5:
				imprimeNomes(alunoLst);
				break;
			case 6:
				System.exit(0);
			default:
				break;
			}
		} while (opcao != 6);
		
	}

	private static void insereAluno(ArrayList<Aluno> alunoLst) {
		String nome = InOut.leString("Informe o nome do aluno");
		int matricula = InOut.leInt("Informe a matrícula do aluno");
		int nota1 = InOut.leInt("Informe a nota 1 do aluno");
		int nota2 = InOut.leInt("Informe a nota 2 do aluno");

		Aluno aluno = new Aluno(nome, matricula, nota1, nota2);
		alunoLst.add(aluno);
	}

	private static void removeAluno(ArrayList<Aluno> alunoLst) {
		String nome = InOut.leString("Informe o nome do aluno que deseja remover");

		Aluno alunoARemover = buscaAluno(alunoLst, nome);

		if (alunoARemover != null) {
			alunoLst.remove(alunoARemover);
			InOut.msgDeInformacao("", "Aluno " + nome + " removido com sucesso.");
		} else {
			InOut.msgDeInformacao("", "Não foi possivel encontrar um aluno com nome de " + nome);
		}
	}

	private static void alteraNota(ArrayList<Aluno> alunoLst) {
		String nome = InOut.leString("Informe o nome do aluno que deseja remover");
		Aluno aluno = buscaAluno(alunoLst, nome);

		if (aluno != null) {
			aluno.setNota1(InOut.leDouble("Informe a nova nota 1"));
			aluno.setNota2(InOut.leDouble("Informe a nova nota 2"));
		} else {
			InOut.msgDeInformacao("", "Não foi possivel encontrar um aluno com nome de " + nome);
		}
	}

	private static void mostraAluno(ArrayList<Aluno> alunoLst) {
		String nome = InOut.leString("Informe o nome do aluno que deseja remover");

		Aluno aluno = buscaAluno(alunoLst, nome);

		if (aluno != null)
			InOut.msgDeInformacao("", aluno.toString());
		else
			InOut.msgDeInformacao("", "Não foi possivel encontrar um aluno com nome de " + nome);

	}

	private static void imprimeNomes(ArrayList<Aluno> alunoLst) {
		String nomes = "";
		for (Aluno aluno : alunoLst) {
			nomes += aluno.getNome();
		}
		
		InOut.msgDeInformacao("", nomes);
	}

	private static Aluno buscaAluno(ArrayList<Aluno> alunoLst, String nome) {
		Aluno alunoEncontrado = null;
		for (Aluno aluno : alunoLst) {
			if (aluno.getNome().equalsIgnoreCase(nome)) {
				alunoEncontrado = aluno;
			}
		}
		return alunoEncontrado;
	}
}
