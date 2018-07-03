package tres;

import java.util.Scanner;
import java.lang.*;

public class calcular {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		double l1, l2, l3;
		l1 = ler.nextInt();
		l2 = ler.nextInt();
		l3 = ler.nextInt();
		if(Math.pow(l1, 2)+Math.pow(l2, 2)==Math.pow(l3, 2)){
			System.out.println("É um triangulo retangulo");
		}
		else System.out.println("Não é um triangulo retangulo");
		
	}

}
