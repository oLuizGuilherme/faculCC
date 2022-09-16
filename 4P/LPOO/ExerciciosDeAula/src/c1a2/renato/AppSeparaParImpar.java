package c1a2.renato;

import java.util.Scanner;

/*Fa�a um aplicativo que vai armazenar v�rios valores inteiros (o
programa p�ra de armazenar quando o usu�rio digitar 0 � zero). 
Se o valor digitado for par ele deve ser armazenado em um pilha. 
Se for �mpar, ele deve ser armazenado em uma fila.
Imprima o valor que est� no topo da pilha e no in�cio da fila.*/

public class AppSeparaParImpar {

	public static void main(String[] args) {
	
		int n;
		FilaInteiro fila = new FilaInteiro();
		PilhaInteiro pilha = new PilhaInteiro();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informa um numero:\n");
		n = scanner.nextInt();
		while (n != 0) {
			if (n % 2 == 0) {
				pilha.push(n);
			}	
			else {
				fila.enqueue(n);
			}
			System.out.println("Informa um numero:\n");
			n = scanner.nextInt();
		}
		
		System.out.println("No topo da pilha est� o " + pilha.topoPilha() + " e o primeiro da fila � o " + fila.primeiroFila());
	}

}
