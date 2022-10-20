package unidade4.classeAbstrataXInterface;

public class Radio extends Eletrodomestico{
	private int banda, volume;
	private double sintonia;
	
	public final static int AM=1, FM=2;
	/**
	 * @param voltagem
	 * @param banda
	 * @param volume
	 * @param sintonia
	 */
	public Radio(int voltagem) {
		super(voltagem);
	}
	public int getBanda() {
		return banda;
	}
	public void setBanda(int banda) {
		this.banda = banda;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public double getSintonia() {
		return sintonia;
	}
	public void setSintonia(double sintonia) {
		this.sintonia = sintonia;
	}
	@Override
	public String toString() {
        String str = super.toString();
        if (super.isLigado()){
            str += "\nBanda: " + this.banda + "  Sintonia: " + this.sintonia +
                    "   Volume: " + this.volume;
        }
        return str;	}
	@Override
	public void ligar() {
		super.setLigado(true);
		this.banda = FM;
		this.sintonia = 88.1;
		this.volume = 10;
	}
	@Override
	public void desligar() {
		this.sintonia = 0;
		this.volume = 0;
		super.setLigado(false);
	}
}
