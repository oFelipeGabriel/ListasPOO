package um.array;


import java.util.Scanner;
import java.util.ArrayList;

public class AgendaTelefonica {
	private ArrayList<Pessoa> pessoas;
	private Scanner scanner;

	public AgendaTelefonica(){
		pessoas = new ArrayList<Pessoa>();
		scanner = new Scanner(System.in);
	}
	public void cadastrarPessoa(){
			System.out.println("\nInsira um nome para pessoa: ");
			String nome = scanner.next();
			System.out.println("\nnsira um telefone para a pessoa: ");
			String telefone = scanner.next();
			System.out.println("\nInsira um email paa a pessoa: ");
			String email = scanner.next();
			Pessoa nova = new Pessoa(nome, telefone, email);
			pessoas.add(nova);
			System.out.println("\nNovo contato adicionado\n");
	}
	public void imprimirOpcoes(){
			System.out.println("\nEscolha uma das opções: \n");
			System.out.println("1 - Listar contatos \n");
			System.out.println("2 - Incluir contatos \n");
			System.out.println("3 - Sair");
	}
	public void imprimirPessoas(){
		for(Pessoa pessoa:pessoas){
			if(pessoa!=null){
				System.out.println("\nNome: "+pessoa.getNome()+
						"\nTelefone: "+pessoa.getTelefone()+
						"\nEmail: "+pessoa.getEmail());
			}			
		}
	}
	public ArrayList<Pessoa> getPessoa(){
		return pessoas;
	}
	public void setPessoas(ArrayList<Pessoa> pessoas){
		this.pessoas = pessoas;
	}
	
}
