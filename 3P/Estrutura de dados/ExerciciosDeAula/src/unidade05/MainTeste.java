package unidade05;

public class MainTeste {
	
	public static void main(String[] args) {
		
		PilhaContigua pilha = new PilhaContigua();
		
		System.out.println(pilha.eCheia());
		
		pilha.push(10);
		pilha.push(3);
		pilha.push(6);
		pilha.push(1);
		pilha.push(8);
		
		System.out.println(pilha.topo());
		System.out.println(pilha.pop());
		System.out.println(pilha.topo());
		System.out.println(pilha.toString());
		
		FilaContigua fila = new FilaContigua();
		
		System.out.println(fila.eCheia());
		System.out.println(fila.eVazia());
		
		fila.enqueue(10);
		fila.enqueue(3);
		fila.enqueue(6);
		fila.enqueue(1);
		fila.enqueue(8);
		
		System.out.println(fila.tail());
		System.out.println(fila.dequeue());
		System.out.println(fila.tail());
		System.out.println(fila.toString());
		
	}

}
