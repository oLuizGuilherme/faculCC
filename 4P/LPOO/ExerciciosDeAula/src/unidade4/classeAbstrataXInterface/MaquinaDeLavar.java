package unidade4.classeAbstrataXInterface;

public class MaquinaDeLavar extends Eletrodomestico{
	private int opcaoDeLavagem;

	/**
	 * @param voltagem
	 * @param opcaoDeLavagem
	 */
	public MaquinaDeLavar(int voltagem) {
		super(voltagem);
	}

	public int getOpcaoDeLavagem() {
		return opcaoDeLavagem;
	}

	public void setOpcaoDeLavagem(int opcaoDeLavagem) {
		this.opcaoDeLavagem = opcaoDeLavagem;
	}

	@Override
	public String toString() {
		String str = super.toString();
        if (super.isLigado())
        {
            str += "\nLavagem= " + this.opcaoDeLavagem;
        }
        return str;
	}

	@Override
	public void ligar() {
		super.setLigado(true);
		this.opcaoDeLavagem = 1;
		
	}

	@Override
	public void desligar() {
		this.opcaoDeLavagem = 0;
		super.setLigado(false);
	}
	

}
