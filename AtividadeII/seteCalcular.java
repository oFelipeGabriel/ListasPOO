package AtividadeII;

import java.util.Scanner;

public class seteCalcular {
	public double salarioHora;
	public double horasTrab;
	public double horasExtras;
	public double totalSalario;

	public void calcularSalario() {
		Scanner leitor = new java.util.Scanner(System.in);
		
		System.out.println("Valor do salario: ");		
		salarioHora =  Integer.parseInt(leitor.nextLine());
		
		System.out.println("Quantidade de horas trabalhadas: ");
		horasTrab =  Integer.parseInt(leitor.nextLine());
		
		horasExtras = horasTrab - 40;
		totalSalario = (salarioHora*40)+(horasExtras*1.5*salarioHora);
		System.out.println("Salario total: "+totalSalario);
		
		leitor.close();
	}
}
