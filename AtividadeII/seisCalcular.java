package AtividadeII;

import java.util.Scanner;

public class seisCalcular {
	public double salario = 200;
	public double comissao = 0.09;
	public double venda = 0;
	
	public void novaVenda(){
		Scanner leitor = new java.util.Scanner(System.in);
		venda = Integer.parseInt(leitor.nextLine());
		salario = salario+comissao*venda;
		leitor.close();
	}
	public void total(){
		System.out.println("Valor total do salario: "+salario);
	}
}
