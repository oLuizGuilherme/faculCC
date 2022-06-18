package arvore;

public class ListaArvore {

	public static void main(String[] args) {
		Arvore arv = new Arvore();
		int[] cont = new int[1];
		cont[0] = 0;
		
		inserir (arv);
		System.out.println("Nos nao terminais  "+
						   quantNosNaoTerminais(arv.getRaiz()));
		quantNosNaoTerminaisV2(arv.getRaiz(), cont);
		System.out.println("Nos nao terminais  "+ cont[0]);
		if (!arv.eVazia()) {
			System.out.println ("V1 Maior valor da ABB = "+ 
								maior (arv.getRaiz()));
		}else {
			System.out.println("Arvore vazia");
		}
		if (!arv.eVazia()) {
			System.out.println ("V2 Maior valor da ABB = "+ 
								maiorV2 (arv.getRaiz()));
		}else {
			System.out.println("Arvore vazia");
		}
		if (!arv.eVazia()) {
			System.out.println ("V3 Maior valor da ABB = "+ 
								maiorV3 (arv.getRaiz()));
		}else {
			System.out.println("Arvore vazia");
		}
		System.out.println ("Soma dos elementos da ABB = "+ 
				soma (arv.getRaiz()));
		System.out.println ("Valores Pares Ordenados da ABB = "+ 
				paresOrdenados(arv.getRaiz()));
	}

	private static void inserir(Arvore arv) {
		arv.inserir(33);
		arv.inserir(15);
		arv.inserir(41);
		arv.inserir(20);
		arv.inserir(38);
		arv.inserir(47);
		arv.inserir(34);
		arv.inserir(43);
		arv.inserir(49);
	}
	 public static int quantNosNaoTerminais (NoArv no) {
		 int cont = 0;
		 if (no == null) {
			 return 0;
		 }else if (no.getEsq() != null || no.getDir() != null) {
			 cont=1;
			 cont += quantNosNaoTerminais(no.getEsq());
			 cont += quantNosNaoTerminais(no.getDir());
		 }
		 return cont;
	 }
	
	 public static void quantNosNaoTerminaisV2 (NoArv no, int[] cont) {
		 if (no == null) {
			 return;
		 }if (no.getEsq() != null || no.getDir() != null) {
			 cont[0]++;
			 quantNosNaoTerminaisV2(no.getEsq(), cont);
			 quantNosNaoTerminaisV2(no.getDir(), cont);
		 }
	 }
	 public static Integer maior (NoArv no) {
		 NoArv noAux = no;
		 int maior = noAux.getInfo();
		 if (no == null) {
			 return null;
		 }
		 if(noAux.getDir()!=null) {
			 maior = maior(noAux.getDir());
			 return maior;
		 }
		 return maior;
	 }
	 public static Integer maiorV2 (NoArv no) {
		 if (no ==null) {
			 return null;
		 }else if (no.getDir() != null) {
			 return maiorV2(no.getDir());
		 }
		 return no.getInfo();
	 }

	 public static Integer maiorV3 (NoArv no) {
		 if (no == null) {
			 return null;
		 }else {
			 while (no.getDir() != null) {
				 no = no.getDir();
			 }
			 return no.getInfo();
		 }
	 }
	 
	 public static int soma (NoArv no) {
		 int soma =0;
		 if (no == null) {
			 return 0;
		 }else {
			 soma += no.getInfo();
			 soma += soma (no.getEsq());
			 soma += soma (no.getDir());
		 }
		 return soma;
	 }
	 
	 public static String paresOrdenados (NoArv no) {
		 String aux = "";
		 if (no == null) {
			 return aux;
		 } else {
			 aux += paresOrdenados(no.getEsq());
			 if (no.getInfo()%2 == 0) {
				aux += " "+no.getInfo()+" "; 
			 }
			 aux += paresOrdenados(no.getDir());
		 }
		 return aux;
	 }
}
