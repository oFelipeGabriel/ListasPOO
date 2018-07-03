import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socketCliente;
		System.out.println("Fazendo Conexão");
		socketCliente = new Socket("127.0.1.1",1234);
		
		PrintWriter escritor = new PrintWriter(socketCliente.getOutputStream());
		System.out.println("Enviando...");
		String n1 = JOptionPane.showInputDialog("Digite o texto");
		StringBuilder sb = new StringBuilder();
		sb.append(n1);
		JOptionPane.showMessageDialog(null, sb.toString());
		
		escritor.write(sb.toString());
		escritor.close();
	}

}
