import java.io.File;

public class Um {
	public static void lerArquivos(File file) {
		File[] arquivos = file.listFiles();
		for(File arquivo:arquivos) {
		if(arquivo.isDirectory()) {
			if(arquivo.canRead()) {
			System.out.println("Pasta: "+arquivo);
			lerArquivos(arquivo);	}		
		}else {
			if(file.canRead()) System.out.println("arquivo: "+file);}
		}
	}
	public static void main(String[] args) {
		lerArquivos(new File("/"));
	}

}
