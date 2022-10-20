package unidade4.classeAbstrataXInterface;
/*
 * Classes Abstratas podem ter metodos construtores,
 * porem, nao podem ser usados para instanciar um 
 * objeto diretamente
 */
public abstract class Eletrodomestico {
	private boolean ligado;
	private int voltagem;
	/**
	 * @param voltagem
	 */
	public Eletrodomestico(int voltagem) {
		this.ligado = false;
		this.voltagem = voltagem;
	}
    // metodos concretos
    /*
     * Uma classe abstrata pode possuir metodos nao abstratos
     */
	public boolean isLigado() {
		return ligado;
	}
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	public int getVoltagem() {
		return voltagem;
	}
	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}
 	@Override
	public String toString() {
        String aux = "Voltagem: " + this.voltagem;
        if (this.ligado)
        {
            aux += "   ligado";
        }
        else
        {
            aux += "   desligado";
        }
        return aux;
    }
    // metodos abstratos //
    /*
    * nao possuem corpo, so sao declarados seus 
    * cabecalhos
    */
	public abstract void ligar();
	public abstract void desligar();
	

	
}
