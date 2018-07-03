package seis;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		ArrayList<Cliente> cliente = new ArrayList<Cliente>();
		Cliente c = new Cliente("Felipe", "felipe@gmail.com", 5551234, "Rua Cesare Lattes s/n");
		c.addGastos(new Gastos(2018,04,25,30));
		cliente.add(c);
	}

}
