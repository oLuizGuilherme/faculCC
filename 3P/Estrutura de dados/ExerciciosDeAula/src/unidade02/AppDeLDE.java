package unidade02;

import io.InOut;

public class AppDeLDE {

	public static void main(String[] args) {

		LdeInt l1 = lerLdeInt();
		LdeInt l2 = lerLdeInt();

		String exibir = montaExibicao(l1, l2);

		InOut.msgDeInformacao("Listas Duplamente Encadeadas", exibir);
	}

	public static LdeInt lerLdeInt() {
		LdeInt ldeInt = new LdeInt();

		int tam = InOut.leInt("Informe a quantidade de elementos que deseja adicionar na lista");

		for (int i = 0; i < tam; i++) {
			ldeInt.insereFinal(InOut.leInt("Informe o " + (i + 1) + "º valor da lista"));
		}

		return ldeInt;
	}

	public static LdeInt intercessaoListas(LdeInt l1, LdeInt l2) {
		LdeInt l3 = new LdeInt();

		NoDuplaInt aux = l1.getPrim();
		LdeInt listaAux = new LdeInt();
		while (aux != null) {
			if (!(listaAux.pesquisa(aux.getInfo()) != null)) {
				listaAux.insereFinal(aux.getInfo());
				NoDuplaInt pesquisa = l2.pesquisa(aux.getInfo());
				if (pesquisa != null) {
					l3.insereFinal(pesquisa.getInfo());
				}
			}
			aux = aux.getProx();
		}

		return l3;
	}

	public static LdeInt unirListas(LdeInt l1, LdeInt l2) {
		NoDuplaInt aux = l2.getPrim();
		while (aux != null) {
			if (l1.pesquisa(aux.getInfo()) == null) {
				l1.insereFinal(aux.getInfo());
			}
			aux = aux.getProx();
		}

		return l1;
	}

	private static String montaExibicao(LdeInt l1, LdeInt l2) {
		
		LdeInt intercessao = intercessaoListas(l1, l2);
		LdeInt uniao = unirListas(l1, l2);
		
		String exibir = "";
		
		exibir = "Lista 1: " + l1.toString() + "\n";
		exibir += "Lista 2: " + l2.toString() + "\n";
		exibir += "Intercessão: " + intercessao + "\n";
		exibir += "União: " + uniao + "\n";
		return exibir;
	}

}
