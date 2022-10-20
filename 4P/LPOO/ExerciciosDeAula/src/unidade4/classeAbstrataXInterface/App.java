package unidade4.classeAbstrataXInterface;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
		
		List<Eletrodomestico> eletrodomesticos = new ArrayList<>();
		
		eletrodomesticos.add(new Tv(110, 29));
		eletrodomesticos.add(new Radio(110));
		eletrodomesticos.add(new MaquinaDeLavar(110));
		
		
		eletrodomesticos.forEach(e -> ligarEletrodomestico(e));
		
		eletrodomesticos.forEach(e -> {
			if (e instanceof Radio) {
				Radio r = (Radio) e;
				r.setVolume(15);
				r.setSintonia(101.5);
				r.setVoltagem(220);
			}
		});
		
		eletrodomesticos.forEach(e -> {
			if (e instanceof Tv) {
				((Tv) e).setCanal(12);
			}
		});
		
		eletrodomesticos.forEach(e -> System.out.println(e));
		
		eletrodomesticos.forEach(e -> {
			if (e instanceof MaquinaDeLavar) {
				e.desligar();
			}
		});
		
	}
	
	private static void ligarEletrodomestico(Eletrodomestico e) {
		e.ligar();
	}

}
