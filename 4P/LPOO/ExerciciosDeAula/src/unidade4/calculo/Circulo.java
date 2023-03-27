package unidade4.calculo;

public class Circulo extends ElementoGeometrico {

	private double raio;

	public Circulo(double x, double y) {
		super(x, y);
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	@Override
	public String desenhar() {
		return "Circulo está sendo desenhado";
	}

	@Override
	public void redimendionar(double fator) {
		this.raio = this.raio * fator;
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(raio, 2);
	}

	@Override
	public double perimetro() {
		return 2 * Math.PI * raio;
	}

}
