package c1a1;

public class Cliente {

	private static int senhaGeral = 0;
	private static int geradorDeSenha = 1;
	
	private int senha;
	private String nome;

	public Cliente(String nome) {
		this.nome = nome;
		this.senha = geradorDeSenha;
		geradorDeSenha++;
	}

	public static int getSenhaGeral() {
		return senhaGeral;
	}

	public int getSenha() {
		return senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome + " " + senha;
	}

	public static void proximo(){
		if (senhaGeral == 999) {
			senhaGeral = 1;
		}
		else {
			senhaGeral++;
		}
	}
	
	
}