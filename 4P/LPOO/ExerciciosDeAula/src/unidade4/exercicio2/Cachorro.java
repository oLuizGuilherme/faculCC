package unidade4.exercicio2;

public class Cachorro extends Animal {

	public Cachorro(String nome, String raca) {
		super(nome, raca);
	}

	@Override
	public void caminha() {
		System.out.println(getNome() + " está correndo.");
	}

	public void late() {
		System.out.println("Au au");
	}

}
