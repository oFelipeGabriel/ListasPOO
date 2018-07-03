package tres;

public class tempo {
	public void calcularTaxa(double x){
		double tempo;
		double total;
		tempo = x;
		if(tempo>3){
			total=(tempo-3)*0.5+2;
		}
		else total=2;
		System.out.println("Total a pagar: R$"+total);
	}
}
