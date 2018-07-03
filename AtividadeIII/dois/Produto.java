package dois;

public class Produto {
	private final double p1 = 1.00;
	private final double p2 = 2.98;
	private final double p3 = 9.98;
	private final double p4 = 4.49;
	private final double p5 = 6.87;
	private int percentp1=0;
	private int percentp2=0;
	private int percentp3=0;
	private int percentp4=0;
	private int percentp5=0;
	private int total=0;
	private double valorTotal=0;
	
	public double getP1() {
		return p1;
	}
	public double getP2() {
		return p2;
	}
	public double getP3() {
		return p3;
	}
	public double getP4() {
		return p4;
	}
	public double getP5() {
		return p5;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public void CalcTotal(double p){
		total++;
		valorTotal = valorTotal+p;
	}
	public void somaPercent(int p){
		switch(p){
		case 1: {percentp1++; break;}
		case 2: {percentp2++; break;}
		case 3: {percentp3++; break;}
		case 4: {percentp4++; break;}
		case 5: {percentp5++; break;}
		}
	}
	public void calcPercentTotal(){
		if(percentp1>0){
			System.out.println("Total de P1: "+percentp1);
			System.out.println("Valor Percentual de P1: "+((percentp1*p1)*100/valorTotal)+"%");
		}
		if(percentp2>0){
			System.out.println("Total de P2: "+percentp2);
			System.out.println("Valor Percentual de P2: "+((percentp2*p2)*100/valorTotal)+"%");
		}
		if(percentp3>0){
			System.out.println("Total de P3: "+percentp3);
			System.out.println("Valor Percentual de P3: "+((percentp3*p3)*100/valorTotal)+"%");
		}
		if(percentp4>0){
			System.out.println("Total de P4: "+percentp4);
			System.out.println("Valor Percentual de P4: "+((percentp4*p4)*100/valorTotal)+"%");
		}
		if(percentp5>0){
			System.out.println("Total de P5: "+percentp5);
			System.out.println("Valor Percentual de P5: "+((percentp5*p5)*100/valorTotal)+"%");
		}
	}
}
