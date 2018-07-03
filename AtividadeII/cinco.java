package AtividadeII;

public class cinco {
	public static void main(String[] args){
		//número da conta, saldo no início do mês, total
		//de todos os itens cobrados desse cliente no mês, total de créditos aplicados ao cliente
		//no mês e limite de crédito autorizado
		cincoCliente cliente = new cincoCliente();
		cliente.numConta = 12345;
		cliente.saldoInicio = 500.00;
		cliente.creditoTotal = 700.00;
		
		cliente.extrato();
		
		cliente.novoItem = 250.00;
		cliente.compra();
		
		cliente.novoItem = 100.00;
		cliente.compra();
		
		cliente.extrato();
		cliente.saldo();
	}
}
