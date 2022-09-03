package unidade3;

import java.util.ArrayList;
import java.util.List;

import io.InOut;

public class Exercicio5 {
	
	public static void main(String[] args) {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(3);
		lista.add(5);
		lista.add(6);
		lista.add(8);
		lista.add(12);
		lista.add(5);
		lista.add(13);
		lista.add(11);
		lista.add(6);
		
		String string = "";
		for (Integer oi : lista) {
			string += oi + " ";
		}
		InOut.msgDeInformacao("", string);
		
		int leInt = InOut.leInt("Informe o número que deseja pesquisar");
		int cont = 0;
		for (Integer oi : lista) {
			if (leInt == oi) {
				cont++;
			}
		}
		
		InOut.msgDeInformacao("", "O número pesquisado apareceu " + cont + " vezes.");
		
		
		
	}

}
