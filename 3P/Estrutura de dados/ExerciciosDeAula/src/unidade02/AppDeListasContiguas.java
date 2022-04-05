package unidade02;

import io.InOut;

public class AppDeListasContiguas {
	
	public static void main(String[] args) {
		
		LCInteiroV2 l1 = leLCInteiro();
		LCInteiroV2 l2 = leLCInteiro();
		
		
		boolean comparaIguais = comparaIguais(l1, l2);
		if (comparaIguais) {
			InOut.msgDeInformacao("Exibir lista" , l1.toString() + "\n" + l2.toString() + "\nAs listas são iguais." );
		} else {
			InOut.msgDeInformacao("Exibir lista" , l1.toString() + "\n" + l2.toString() + "\nAs listas não são iguais." );
		}
		
		InOut.msgDeInformacao("Lista concatenada", concatenar(l1, l2).toString());
	}
	

	public static LCInteiroV2 leLCInteiro() {
		int tam = InOut.leInt("Informe o tamanho da lista que deseja inserir.");
		LCInteiroV2 listaC = new LCInteiroV2(tam);
		
		for (int i = 0; i < tam; i++) {
			listaC.insereFim(InOut.leInt("Informe o valor da posição " + (i + 1) + " da lista."));
		}
		
		return listaC;
	}
	
	 public static boolean comparaIguais(LCInteiroV2 l1, LCInteiroV2 l2){
	        
	        if(l1.getNElem() == l2.getNElem()) {
	            
	            for(int i = 0; i < l1.getNElem(); i++) {
	                
	                if(l1.getNum(i) != l2.getNum(i)){
	                    return false;
	                }
	                
	            }
	            return true;
	        }
	        return false;
	    }
	
	public static LCInteiroV2 concatenar(LCInteiroV2 l1, LCInteiroV2 l2) {
		int soma = l1.getNElem()+l2.getNElem();
		LCInteiroV2 l3 = new LCInteiroV2(soma); //instanciar
		 
        for (int i=0; i<l1.getNElem(); i++ ){
            l3.insereFim(l1.getNum(i));
        }
        for (int i=0; i<l2.getNElem(); i++){
            l3.insereFim(l2.getNum(i));
        }
        return l3;
    }

}
