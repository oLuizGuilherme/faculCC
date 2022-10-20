package unidade4.classeAbstrataXInterface;

public class Tv extends Eletrodomestico{
	private int canal, volume, tamanho;

	/**
	 * @param voltagem
	 * @param canal
	 * @param volume
	 * @param tamanho
	 */
	public Tv(int voltagem, int tamanho) {
		super(voltagem);
		this.tamanho = tamanho;
	}

	public int getCanal() {
		return canal;
	}

	public void setCanal(int canal) {
		this.canal = canal;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getTamanho() {
		return tamanho;
	}

	@Override
	public String toString() {
        String str = super.toString() + "\nTamanho: " + this.tamanho;
        if (super.isLigado())
        {
        	str += "\nCanal: " + this.canal + "  Volume: " + this.volume;
        }
        return str;	
	}

    /* implementacao dos metodos abstratos 
     * da classe Eletrodomestico*/

	@Override
	public void ligar() {
		super.setLigado(true);
		this.canal = 1;
		this.volume = 10;
	}

	@Override
	public void desligar() {
		this.canal = 0;
		this.volume = 0;
		super.setLigado(false);
	}
	
	

}
