package c1a2;

import java.util.LinkedList;

public class PilhaInteiro {

    private LinkedList<Integer> pilha;
    
    public PilhaInteiro() {
    	pilha = new LinkedList<>();
    }
    
    public boolean eVazia() {
    	return pilha.isEmpty();
    }
    
    public void push(int num) {
    	pilha.addLast(num);
    }
    
    public Integer pop() {
    	return pilha.removeLast();
    }
    
    public int tamanho() {
    	return pilha.size();
    }
    
    public Integer top() {
    	return pilha.getLast();
    }
    
    // toString vou deixar o da super classe "Object"

}