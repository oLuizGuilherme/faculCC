package unidade4.controleremoto;

import unidade4.classeAbstrataXInterface.Tv;

public class Tv001 extends Tv implements ControleRemoto {

	public Tv001(int voltagem, int tamanho) {
		super(voltagem, tamanho);
	}

	@Override
	public void mudarDeCanal(int canal) {
		if (isLigado())
			setCanal(canal);
	}

	@Override
	public void aumentarVolume() {
		if (isLigado() && getVolume() <= 100)
			setVolume(getVolume() + 1);
	}

	@Override
	public void diminuirVolume() {
		if (isLigado() && getVolume() >= 0)
			setVolume(getVolume() - 1);
	}

	@Override
	public void ligarOuDesligar() {
		if (isLigado())
			setLigado(false);
		else
			setLigado(true);
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
