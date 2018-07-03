package um;

import java.util.Scanner;

public class AgendaTelefonica {
	private Pessoa[] pessoas;
	private Scanner scanner;

	public AgendaTelefonica(){
		pessoas = new Pessoa[5];
		scanner = new Scanner(System.in);
	}
	public void cadastrarPessoa(){
		for(int i=0;i<pessoas.length;i++){
			System.out.println("\nInsira um nome para pessoa: ");
			String nome = scanner.next();
			System.out.println("\nnsira um telefone para a pessoa: ");
			String telefone = scanner.next();
			System.out.println("\nInsira um email paa a pessoa: ");
			String email = scanner.next();
			Pessoa nova = new Pessoa(nome, telefone, email);
			pessoas[i] = nova;
			System.out.println("\nNovo contato adicionado\n");
			break;
		}
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
	public Pessoa[] getPEssoa(){
		return pessoas;
	}
	public void setPessoas(Pessoa[] pessoas){
		this.pessoas = pessoas;
	}
	
}
