package dois;

import java.util.Scanner;
public class escrever {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int n;
		System.out.println("Tamanho do Quadrado: ");
		n=ler.nextInt();
		for(int i=0;i<n;i++){
			for(int k=0;k<n;k++){
				if(i==0||k==0 ||i==n-1 ||k==n-1) System.out.print("*");
				else System.out.print(" ");
			}
		System.out.print("\n");
		}
		
	}

}
