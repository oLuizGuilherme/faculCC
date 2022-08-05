package c3a2;

public class Pessoa {

	private String nome;
	private long cpf;
	/**
	 * voto = 1 == sim
	 * voto = 2 == não
	 */
	private int voto;

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

	public int getVoto() {
		return voto;
	}
	
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	@Override
	public String toString() {
		return nome + " - " + cpf;
	}

}
