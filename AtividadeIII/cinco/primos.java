package cinco;

import java.util.ArrayList;

public class primos {
	public static void main(String[] args) {
		ArrayList<Integer> primo = new ArrayList<Integer>();
		int contador;
		int numero = 0;
		for (int k=0;k<999;k++) {
			contador = 0;
			for (int u = 1; u <= k; u++) {
				if (k % u == 0) {
				contador++;
				numero = u;
				}
			}
			if (contador == 2) {
						System.out.println("O Número " + numero + " é primo");
						primo.add(numero);
					}		
				}
		}
	
}
