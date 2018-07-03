package um;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda implements Runnable{
	Contato contato;
	ArrayList<Contato> contatos = new ArrayList<>();
	
	public void gravacao() throws FileNotFoundException{
		FileOutputStream arquivo = new FileOutputStream("contatos.cts");
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(arquivo);
			out.writeObject(contatos);
			out.flush();
			out.close();
		} catch (IOException e) {}
	}
	
	public void leitura() throws FileNotFoundException, ClassNotFoundException{
		FileInputStream arquivo = new FileInputStream("contatos.cts");
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(arquivo);
			this.contatos = (ArrayList<Contato>) in.readObject();
		} catch (IOException e) {}
	}
	
	public void adiciona(Contato c) {
		contatos.add(c);
	}
	
	public void alterar(String nome) {
		Scanner x = new Scanner(System.in);
		String email;
		String telefone;
		for(int i=0;i<contatos.size();i++) {
			Contato c = contatos.get(i);
			if(c.getNome().equals(nome)) {
				System.out.print("E-Mail: ");
				c.setEmail(x.next());
				System.out.print("Telefone: ");
				c.setTelefone(x.next());
				break;
			}
		}
	}
	public void remove(String c) {
		for(int i=0;i<contatos.size();i++) {
			Contato cont = contatos.get(i);
			if(contato.getNome().equals(c)) {
				contatos.remove(cont);
				break;
			}
		}
	}

	public void listaContatos() {
		for(int k=0;k<contatos.size();k++) {
			System.out.println("Nome: "+contatos.get(k).getNome());
			System.out.println("Email: "+contatos.get(k).getEmail());
			System.out.println("Telefone: "+contatos.get(k).getTelefone());
		}
	}
	@Override
	public void run() {
		try {
			gravacao();
		} catch (FileNotFoundException e) {}
		try {
			leitura();
		} catch (FileNotFoundException | ClassNotFoundException e) {}
		
	}
}
