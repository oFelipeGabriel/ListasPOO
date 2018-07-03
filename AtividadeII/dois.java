package AtividadeII;

import java.util.Scanner;

public class dois {
	public static void main(String args[]){
		Scanner leitor = new java.util.Scanner(System.in);
		int n1, n2;
		System.out.println("Digite o primeiro numero: ");
		n1 = leitor.nextInt();
		System.out.println("Digite o segundo numero: ");
		n2 = leitor.nextInt();
		System.out.println("Soma = " + (n1+n2) + "\n");
		System.out.println("Media = " + (n1+n2)/2 + "\n");
		if(n1>n2){
			System.out.println(n1 + " maior que " + n2);
		}
		else System.out.println(n2 + " maior que " + n1);
		leitor.close();
	}
}
