package AtividadeII;

import java.util.Scanner;

public class um {
	public static void main(String args[]) {
		Scanner leitor = new java.util.Scanner(System.in);
		int numero1;
		int numero2;
		System.out.println("Digite o primeiro numero: ");
		numero1 = leitor.nextInt();
		System.out.println("Digite o segundo numero: ");
		numero2 = leitor.nextInt();
		// Soma
		System.out.println("Soma = " + (numero1+numero2) + "\n");
		// Subtração
		System.out.println("Subtracao = " + (numero1-numero2) + "\n");
		// Divisão
		System.out.println("Divisao = " + (numero1/numero2) + "\n");
		//Multiplicação
		System.out.println("Multiplicacao = " + (numero1*numero2) + "\n");
		leitor.close();
	}
}
