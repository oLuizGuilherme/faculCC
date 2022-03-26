package unidade02;

import io.InOut;

public class AppDeListasContiguas {
	
	public static void main(String[] args) {
		
		LCInteiroV2 l1 = leLCInteiro();
		LCInteiroV2 l2 = leLCInteiro();
		
		InOut.msgDeInformacao("Exibir lista" , l1.toString() + "\n" + l2.toString());
		
//		comparaLcInt(lcInteiro1, lcInteiro2);
		
		InOut.msgDeInformacao("MORRA", concatenar(l1, l2).toString());
	}
	

	public static LCInteiroV2 leLCInteiro() {
		int tam = InOut.leInt("Informe o tamanho da lista que deseja inserir.");
		LCInteiroV2 listaC = new LCInteiroV2(tam);
		
		for (int i = 0; i < tam; i++) {
			listaC.insereFim(InOut.leInt("Informe o valor da posição " + (i + 1) + " da lista."));
		}
		
		return listaC;
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
