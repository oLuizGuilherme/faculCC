package unidade4.calculo;

public class Quadrado extends Retangulo {

	public Quadrado(double x, double y) {
		super(x, y);
	}

	@Override
	public void setLado1(double lado1) {
		super.setLado1(lado1);
		super.setLado2(lado1);
	}

	/**
	 * Método depreciado porque no quadrado 
	 * os lados precisam ser iguais, por isso
	 * utilizase apenas lado 1
	 */
	@Deprecated
	@Override
	public void setLado2(double lado2) {
	}
	
	@Override
	public String desenhar() {
		return "Quadrado sendo desenhado.";
	}

}
