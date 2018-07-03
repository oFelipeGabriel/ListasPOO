package dois;

import java.util.Scanner;

public class Buraco {

	public static void main(String[] args) {
		String[] umBuraco = {"A","D","O","P","Q","R"};
		String[] doisBuracos = {"B"};
		String[] semBuracos = {"C","E","F","G","H","I","J","K","L","M","N","S","T","U","V","W","X","Y","Z"}; 
		Scanner x = new Scanner(System.in);
		int total = 0;
		String saida = "";
		
		System.out.println("Digite o texto");
		String texto = x.next();
		for(int i = 0; i < texto.length(); i++) {
			String letra = Character.toString(Character.toUpperCase(texto.charAt(i)));
		    for(int j=0;j<umBuraco.length;j++) {
		    	if(letra.equals(umBuraco[j])) total++;
		    	break;
		    }
		 for(int j=0;j<doisBuracos.length;j++) {
		   	if(letra.equals(doisBuracos[j])) total=total+2;
		 }
		 	saida += letra;
		}
		System.out.println(saida+" \nTotal: "+total);
	}
}