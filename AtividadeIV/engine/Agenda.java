package fatec.engine;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fatec.modelo.Aluno;
import fatec.modelo.Professor;

public class Agenda {
	private List<Aluno> alunos;
	private List<Professor> professores;
	private Scanner leitor;
	
	public Agenda(){
		alunos = new ArrayList<Aluno>();
		professores = new ArrayList<Professor>();
		leitor = new Scanner(System.in);
	}
	public void cadastrarAluno(){
		System.out.println("\nNome do Aluno: ");
		String nome = leitor.next();
		System.out.println("Telefone do Aluno: ");
		String telefone = leitor.next();
		System.out.println("Email do Aluno: ");
		String email = leitor.next();
		System.out.println("Número da matrícula do Aluno: ");
		String ra = leitor.next();
		Aluno novo = new Aluno(nome, telefone, email, ra);
		alunos.add(novo);
		System.out.println("Novo aluno cadastrado com sucesso");
	}
	
	public void cadastrarProfessor(){
		System.out.println("\nNome do Professor: ");
		String nome = leitor.next();
		System.out.println("Telefone do Professor: ");
		String telefone = leitor.next();
		System.out.println("Email do Professor: ");
		String email = leitor.next();
		System.out.println("Número de Registro do Prefessor: ");
		String rg = leitor.next();
		System.out.println("Quantidade de Horas Aula: ");
		String horasAula = leitor.next();
		Professor novo = new Professor(nome, telefone, email, rg, horasAula);
		professores.add(novo);
		System.out.println("Novo professor cadastrado com sucesso");
	}
	
	public void listarTodos(){
		System.out.println("Lista de contatos de alunos: ");
		for(Aluno aluno:alunos){
			System.out.println("Nome: "+aluno.getNome());
			System.out.println("Telefone: "+aluno.getTelefone());
			System.out.println("Email: "+aluno.getEmail());
			System.out.println("Nº da Matricula: "+aluno.getNumeroMatricula()+"\n");
		}
		System.out.println("Lista de contatos de professores: ");
		for(Professor professor:professores){
			System.out.println("Nome: "+professor.getNome());
			System.out.println("Telefone: "+professor.getTelefone());
			System.out.println("Email: "+professor.getEmail());
			System.out.println("Registro: "+professor.getNumeroRegistro());
			System.out.println("Quantidade Hora: "+professor.getQuantidadeHoraAula()+"\n");
			}
		}
		public List<Aluno> getAlunos(){
			return alunos;
		}
		public void setAlunos(List<Aluno> alunos){
			this.alunos = alunos;
		}
		public List<Professor> getProfessores(){
			return professores;
		}
		public void setProfessores(List<Professor> professores){
			this.professores = professores;
		}
		
}