import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor implements Runnable{
	private static ServerSocket socketServidor;
	static InetAddress ip;
	  
	public Servidor() throws IOException{
		
	}
	public static void iniciarEscuta()throws Exception{
		socketServidor = new ServerSocket(1234);
		while(true) {
			Socket socketEscuta = socketServidor.accept();
			InputStreamReader streamReader = new InputStreamReader(socketEscuta.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
			String textoEnviado = reader.readLine();
			System.out.println("Enviado de: "+socketEscuta.getLocalAddress()+"\nTexto: "+textoEnviado);
			reader.close();
		}
	}
		
	public void ServidorTeste() {
		try {

			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());

		  } catch (UnknownHostException e) {

			e.printStackTrace();

		  }
		System.out.println("Iniciar servidor");
		
		
		}
	
	@Override
	public void run() {
		try {
			iniciarEscuta();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
