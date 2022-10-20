package unidade4.controleremoto;

import unidade4.classeAbstrataXInterface.Tv;

public class TvSDX extends Tv implements ControleRemoto {

	public TvSDX(int voltagem, int tamanho) {
		super(voltagem, tamanho);
	}

	@Override
	public void mudarDeCanal(int canal) {
		setCanal(canal);
	}

	@Override
	public void aumentarVolume() {
		setVolume(getVolume() + 1);
	}

	@Override
	public void diminuirVolume() {
		setVolume(getVolume() - 1);
	}

	@Override
	public void ligarOuDesligar() {
		if (isLigado()) {
			System.out.println("Tchau balau!");
			setLigado(false);
		}
		else {
			setLigado(true);
			System.out.println("Salve!");
		}
	}
	
	@Override
	public void aumentarCanal() {
		if (isLigado())
			setCanal(getCanal() + 1);
	}
	
	@Override
	public void diminuirCanal() {
		if (isLigado())
			setCanal(getCanal() - 1);
	}

}
