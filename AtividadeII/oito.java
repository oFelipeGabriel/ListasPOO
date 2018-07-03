package AtividadeII;

import java.util.Scanner;

public class oito {
	public static void main(String[] args) {
		int x;
		Scanner leitor = new java.util.Scanner(System.in);
		x = Integer.parseInt(leitor.nextLine());
		oitoCrip num = new oitoCrip();
		num.criptografar(x);
		num.descriptografar();
		leitor.close();

	}

}
