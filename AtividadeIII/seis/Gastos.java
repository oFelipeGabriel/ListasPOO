package seis;

public class Gastos {
	private int ano;
	private int mes;
	private int dia;
	private int valor;
	
	public Gastos(int ano, int mes, int dia, int valor) {
		super();
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
		this.valor = valor;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getAno() {
		return ano;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getMes() {
		return mes;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getDia() {
		return dia;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getValor() {
		return valor;
	}
}
