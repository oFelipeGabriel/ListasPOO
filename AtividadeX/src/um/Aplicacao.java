package um;

import java.util.Scanner;

public class Aplicacao {
	static Agenda ag = new Agenda();
	static Contato c;
	
	public static void novo() {
		Scanner x = new Scanner(System.in);
		String nome;
		String email;
		String telefone;
		System.out.print("Nome: ");	nome = x.next();
		System.out.print("E-Mail: ");	email = x.next();
		System.out.print("Telefone: ");	telefone = x.next();
		c = new Contato(nome,email,telefone);
		ag.adiciona(c);
	}
	
	public static void alterar() {
		Scanner x = new Scanner(System.in);
		String nome;
		System.out.print("Nome: ");	nome = x.next();
		ag.alterar(nome);
	}
	
	public static void remover() {
		Scanner x = new Scanner(System.in);
		String nome;
		System.out.print("Nome: ");	nome = x.next();
		ag.remove(nome);
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(ag);
		t1.start();
		
		int opcao = 0;
		Scanner leitor = new Scanner(System.in);		
		
		while(opcao!=5) {
			System.out.println("Digite: \n1 - Adicionar\n2 - Alterar\n3 - Apagar"
					+ "\n4 - Ver contatos\n5 - Sair");
			opcao = leitor.nextInt();
			switch(opcao) {				
				case 1: novo();break;
				case 2: alterar();break;
				case 3: remover();break;
				case 4: ag.listaContatos();break;
				case 5: System.out.println("Saindo...");break;
			}
		}
	}

}
