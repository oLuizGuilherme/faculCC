package unidade03;

import io.InOut;

public class AppContato {

	static private FilaContato fila = new FilaContato();
	static private final String ENUNCIADO_MENU = "Atendimento\nOpções\n1 - Inserir contato na fila de atendimentos.\n2 - Exibir informações para começar atendimento.\n3 - Sair.";

	public static void main(String[] args) {
		
		menu();

	}
	
	private static void menu() {
		int escolha = 0;
		
		while (escolha != 3) {
			escolha = InOut.leInt(ENUNCIADO_MENU);
			
			switch (escolha) {
				case 1:
					lerContato();
					break;
				case 2: 
					efetuarContato();
					break;
				default:
					break;
			}
			
			
		}
		
		
	}

	private static void lerContato() {

		String nome = InOut.leString("Informe o nome");
		String cpf = InOut.leString("Informe o cpf");
		String celular = InOut.leString("Informe o celular");

		Contato contato = new Contato(nome, cpf, celular);
		
		fila.enqueue(contato);

	}

	private static void efetuarContato() {
		
		Contato contato = pegarContato();
		
		if (contato != null) {
			InOut.msgDeInformacao("ATENDIMENTO", "O próximo contato da fila é\n" + contato.toString());
		} else {
			InOut.msgDeAviso("ATENDIMENTO", "Não existe mais contatos a serem atendidos.");
		}

	}

	private static Contato pegarContato() {
		
		if (fila.isEmpty())
			return null;

		return fila.dequeue().getInfo();
	}

}
