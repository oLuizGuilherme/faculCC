package unidade4.exercicio2;

public class Ave extends Animal {

	public Ave(String nome, String raca) {
		super(nome, raca);
	}
	
	@Override
	public void caminha() {
		System.out.println(getNome() + " está voando.");
	}
	
	public void canta() {
		System.out.println("Canta");
	}

}
