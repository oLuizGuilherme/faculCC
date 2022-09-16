package c1a2.renato;

import java.util.LinkedList;

/*Implemente uma classe PilhaInteiro, cujo atributo � uma LinkedList,
que vai armazenar uma pilha de inteiros com as opera��es:
1. Verificar se a pilha est� vazia
2. Push (Inserir um elemento no topo da pilha)
3. Pop (Remover o elemento do topo da pilha)
4. Retornar o tamanho da pilha
5. Retorna o topo*/

public class PilhaInteiro {

    private LinkedList<Integer> pilha;
    
    public PilhaInteiro() {
    	pilha = new LinkedList<>();
    }
    
    public boolean pilhaVazia() {
    	return pilha.isEmpty();
    }
    
    public void push(int numero) {
    	pilha.addLast(numero);
    }
    
    public Integer pop() {
    	return pilha.removeLast();
    }
	
    public Integer tamanhoPilha() {
    	return pilha.size();
    }
	
    public Integer topoPilha() {
    	return pilha.peekLast();
    }
}
