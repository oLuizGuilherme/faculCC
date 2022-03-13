package unidade02;

public class Veiculo {

	private String nome;
	private String marca;
	private String cor;
	private String placa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa.toUpperCase();
	}

	@Override
	public String toString() {
		return "[ " + this.marca + " | " + this.nome + " | " + this.cor + " | " + this.placa + " ]";
	}

}
