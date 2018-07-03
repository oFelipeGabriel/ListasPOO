package seis;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String email;
	private int telefone;
	private String endereco;
	private ArrayList<Gastos> gastos;
	
	public Cliente(String nome, String email, int telefone, String endereco) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEndereco() {
		return endereco;
	}
	public void addGastos(Gastos gasto) {
		gastos.add(gasto);
	}
	public ArrayList<Gastos> getGastos() {
		return gastos;
	}
}
