package tres;

import java.util.Scanner;

public class Diamente {
	static String[] alfabeto = {"A","B","C","D","E","F","G","H","I","J","K","L","M",
			"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	static int a = 0;
	static int b = 0;
	static int atual = 0;
	static int p;
	static String letra1;
	

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		
		System.out.println("Letra: ");
		letra1 = x.next().toUpperCase();
		for(int i=0;i<alfabeto.length;i++) {
			if(letra1.equals(alfabeto[i])) b=i;
		}
		p=b;
		while(p>=0) {
		for(int k=0;k<=b;k++) {
			if(k==p) {System.out.print(alfabeto[atual]);atual++;}
			else System.out.print(" ");
		}
		for(int k=b;k>a;k--) {
			if(b-k+2==atual)System.out.print(alfabeto[atual-1]);
			else System.out.print(" ");
		}
		System.out.println("");
		p--;
		}
		atual -= 1;
		p += 2;
		while(p<b+1) {
			for(int k=0;k<=b;k++) {
				if(k==p) {System.out.print(alfabeto[--atual]);}
				else System.out.print(" ");
			}
			for(int k=b-1;k>a;k--) {
				if(b-k==atual)System.out.print(alfabeto[atual]);
				else System.out.print(" ");
			}
			System.out.println("");
			p++;
		}
	}

}
