package dois;

import java.util.Scanner;

public class Aplicativo {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		Menu menu = new Menu();
		Produto novo = new Produto();
		String valor="0";
		int sair = 0;
		menu.CriaMenu();
		
		while(sair==0){
			valor=x.next();
			double v;			
			switch(valor){
			case "p1": {
				v=novo.getP1();
				novo.CalcTotal(v);
				novo.somaPercent(1);
				break;
			}
			case "p2": {
				v=novo.getP2();
				novo.CalcTotal(v);
				novo.somaPercent(2);
				break;
			}
			case "p3": {
				v=novo.getP3();
				novo.CalcTotal(v);
				novo.somaPercent(3);
				break;
			}
			case "p4": {
				v=novo.getP4();
				novo.CalcTotal(v);
				novo.somaPercent(4);
				break;
			}
			case "p5": {
				v=novo.getP5();
				novo.CalcTotal(v);
				novo.somaPercent(5);
				break;
			}
			case "0": {
				sair=1;
				System.out.println("Total de itens: "+novo.getTotal());
				System.out.println("Valor total: R$"+novo.getValorTotal());
				novo.calcPercentTotal();
			}
			}
		}
		x.close();
		
	}
}
