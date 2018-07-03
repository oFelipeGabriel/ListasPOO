package AtividadeII;
import java.util.Scanner;

public class quatro {
	public static void main(String args[]){
		int a, b;
		Scanner leitor = new java.util.Scanner(System.in);
		System.out.println("Valor de a: ");
		a = leitor.nextInt();
		System.out.println("Valor de b: ");
		b = leitor.nextInt();
		if(a%b==0) System.out.println(a + " eh multiplo de " + b);
		else System.out.println(a + " nao eh multiplo de " +b);
		leitor.close();
		
	}
}
