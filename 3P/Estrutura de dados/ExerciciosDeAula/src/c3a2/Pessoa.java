package c3a2;

public class Pessoa {

	private String nome;
	private long cpf;

	public Pessoa() {
	}

	public Pessoa(String nome, long cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		if (nome != null && cpf != 0) {
			return nome + " - " + cpf;
		} else if (nome != null) {
			return nome;
		} else if (cpf != 0) {
			return "CPF: " + cpf;
		} else {
			return "";
		}
	}

}
