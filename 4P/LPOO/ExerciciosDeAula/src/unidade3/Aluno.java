package unidade3;
/*1) a) Faça uma classe que define um objeto Aluno com os seguintes 
 * atributos: nome, matricula (int), duas notas e média. 
 * Faça o construtor, os métodos gets e sets, toString e compareTo 
 * (que compara o nome de dois alunos e devolve o resultado da 
 * comparação deste atributo nome)
 * */
public class Aluno {
	private String nome;
	private int matricula;
	private double nota1, nota2, media;
	public Aluno(String nome, int matricula, double nota1, double nota2) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = this.calculaMedia();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
		this.media = this.calculaMedia();
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
		this.media = this.calculaMedia();
	}

	public double getMedia() {
		return media;
	}

	private double calculaMedia () {
		return (this.nota1+this.nota2)/2;
	}

	@Override
	public String toString() {
		return "nome= " + nome + "  matricula= " + matricula + 
				"  nota1= " + nota1 + "  nota2= " + nota2 + 
				"  media= " + media ;
	}

	public int compareTo (Aluno novo) {
		return (this.getNome().compareToIgnoreCase(novo.getNome()));
	}
	
	
	

}
