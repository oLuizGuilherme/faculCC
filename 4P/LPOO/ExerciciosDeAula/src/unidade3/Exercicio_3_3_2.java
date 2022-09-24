package unidade3;

import java.util.Set;
import java.util.TreeSet;

import io.InOut;

public class Exercicio_3_3_2 {
	
	public static void main(String[] args) {
		
		TreeSet<Integer> ts1 = new TreeSet<>();
		int n;
		
		leLista(ts1);
		
		n = InOut.leInt("Informe um número");
		
		TreeSet<Integer> tailSet = (TreeSet<Integer>) ts1.tailSet(n, false);
		
		InOut.msgDeInformacao("", n + "\n" + ts1.toString() + "\n" + tailSet);
		
		
		
	}
	
	private static void leLista(Set<Integer> lst) {
		int n = 5;
		for (int i = 0; i < n; i++) {
			lst.add(InOut.leInt("Informe um inteiro"));
		}

	}

}
