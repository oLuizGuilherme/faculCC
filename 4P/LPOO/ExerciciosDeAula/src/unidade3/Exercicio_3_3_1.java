package unidade3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import io.InOut;

public class Exercicio_3_3_1 {

	public static void main(String[] args) {

		HashSet<Integer> hs1 = new HashSet<>();
		HashSet<Integer> hs2 = new HashSet<>();
		HashSet<Integer> hs3 = new HashSet<>();
		
		leLista(hs1);
		leLista(hs2);
		
		hs3.addAll(hs1);
		hs3.addAll(hs2);
		
		ArrayList<Integer> list = new ArrayList<>(hs3);
		Collections.sort(list);
		
		hs3.removeAll(list);
		hs3.addAll(list);
		
		InOut.msgDeInformacao("", hs1.toString() + hs2.toString() + hs3.toString());

	}

	private static HashSet<Integer> leLista(HashSet<Integer> lst) {
		int n = 5;
		for (int i = 0; i < n; i++) {
			lst.add(InOut.leInt("Informe um inteiro"));
		}

		return lst;
	}

}
