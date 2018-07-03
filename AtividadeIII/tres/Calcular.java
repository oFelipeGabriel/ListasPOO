package tres;

import java.util.Scanner;

public class Calcular {
	public static void main(String[] args) {
		Scanner valor = new Scanner(System.in);
		tempo tempo = new tempo();
		float t;
		System.out.println("Tempo: ");
		t=valor.nextInt();
		tempo.calcularTaxa(t);
	}

}
