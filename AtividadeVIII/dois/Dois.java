import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Dois {
	public static void main(String[] args) throws IOException {
		ArrayList<String> emails = new ArrayList<>();
		
		File leitura = new File("emails.txt");
		System.out.println("Abrindo arquivo "+leitura);
		
		FileReader arquivo = new FileReader(leitura);
		BufferedReader bf = new BufferedReader(arquivo);
		System.out.println("Lendo texto");
		String linha = bf.readLine();
		String[] linhas;
		System.out.println("Separando emails");
		while(linha != null) {
			linhas = linha.split(" ");
			for(String l:linhas) {
				if(l.contains("@")) {emails.add(l);	}				
			}linha = bf.readLine();
		}
		arquivo.close();
		File file = new File("emails salvos.txt");
		FileWriter escritor = new FileWriter(file);
		System.out.println("Salvando novo arquivo");
		for(String email:emails) {
			escritor.write(email+"\n");
		}
		escritor.close();
		System.out.println("Finalizado");
		}
}
