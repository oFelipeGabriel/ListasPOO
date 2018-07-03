package AtividadeII;

public class cincoCliente {
	//número da conta, saldo no início do mês, total
	//de todos os itens cobrados desse cliente no mês, total de créditos aplicados ao cliente
	//no mês e limite de crédito autorizado
	public int numConta;
	public double saldoInicio;
	public double novoItem;
	public double totalItens;
	public double creditoTotal;
	public double limiteCredito;
	public double saldoFinal;
	
	public void extrato(){
		System.out.println("Numero da conta: "+numConta);
		System.out.println("Saldo inicio do mes: "+saldoInicio);
		System.out.println("Itens Cobrados: "+totalItens);
		System.out.println("Total de credito utilizado: "+creditoTotal);
		System.out.println("Limite de credito autorizado: "+limiteCredito);
	 }
	
	public void compra(){
		totalItens = totalItens + novoItem;
	}
	
	public void saldo(){
		saldoFinal = saldoInicio + totalItens - creditoTotal;
		System.out.println("Saldo: " +saldoFinal);
	}
}
