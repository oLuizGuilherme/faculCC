package arvore;

public class Main {
	
	public static void main(String[] args) {
		
		Arvore arvore = new Arvore();
		
		arvore.inserir(12);
		arvore.inserir(10);
		arvore.inserir(14);
		arvore.inserir(9);
		arvore.inserir(11);
		arvore.inserir(13);
		arvore.inserir(15);
		
		NoArv pesquisar = arvore.pesquisar(13);
		
		System.out.println(pesquisar.getInfo());
		
		
		
	}

}
