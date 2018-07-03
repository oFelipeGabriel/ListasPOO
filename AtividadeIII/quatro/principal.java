package quatro;

import java.util.Scanner;

public class principal {
	public static boolean multiplo(int x, int y){
		if(y%x==0) return true;
		else return false;
	}
	public static void main(String[] args) {
		int x;
		int y;
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite o valor de x: ");
		x=leitor.nextInt();
		System.out.println("Digite o valor de y: ");
		y=leitor.nextInt();
		multiplo(x, y);
		leitor.close();
	}

}
