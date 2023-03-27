package unidade4.calculo;

public class Retangulo extends ElementoGeometrico {

	private double lado1;
	private double lado2;

	public Retangulo(double x, double y) {
		super(x, y);
	}

	public double getLado1() {
		return lado1;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}

	@Override
	public String desenhar() {
		return "Retângulo está sendo desenhado.";
	}

	@Override
	public void redimendionar(double fator) {
		lado1 = (lado1 * fator);
		lado2 = (lado2 * fator);
	}

	@Override
	public double area() {
		return lado1 * lado2;
	}

	@Override
	public double perimetro() {
		return (2 * lado1) + (2 * lado2);
	}

}
