package AtividadeII;
import java.util.Scanner;

public class tres {
	public static void main(String args[]){
		Scanner leitor = new java.util.Scanner(System.in);
		int n1, n2, n3, n4, n5, maior=0, menor=100;
		System.out.println("Numero 1: ");
		n1 = leitor.nextInt();
		if(n1>maior) maior = n1;
		else if(n1<menor) menor = n1;
		System.out.println("Numero 2: ");
		n2 = leitor.nextInt();
		if(n2>maior) maior = n2;
		else if(n2<menor) menor = n2;
		System.out.println("Numero 3: ");
		n3 = leitor.nextInt();
		if(n3>maior) maior = n3;
		else if(n3<menor) menor = n3;
		System.out.println("Numero 4: ");
		n4 = leitor.nextInt();
		if(n4>maior) maior = n4;
		else if(n4<menor) menor = n4;
		System.out.println("Numero 5: ");
		n5 = leitor.nextInt();
		if(n5>maior) maior = n5;
		else if(n5<menor) menor = n5;
		System.out.println("Maior: " + maior + "\n");
		System.out.println("Menor: " + menor + "\n");
		leitor.close();
	}
}
