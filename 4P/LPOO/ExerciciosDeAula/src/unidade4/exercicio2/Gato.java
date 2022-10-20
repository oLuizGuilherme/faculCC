package unidade4.exercicio2;

public class Gato extends Animal{

	public Gato(String nome, String raca) {
		super(nome, raca);
	}
	
	@Override
	public void caminha() {
		System.out.println(getNome() + " está saltando.");
	}
	
	public void mia() {
		System.out.println("Miau");
	}

}
