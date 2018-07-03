package fatec.modelo;

public class Professor extends Pessoa{
	private String numeroRegistro;
	private String quantidadeHoraAula;
	
	public Professor(String nome, String telefone, String email, String numeroRegistro, String quantidadeHoraAula){
		super(nome, telefone, email);
		this.numeroRegistro = numeroRegistro;
		this.quantidadeHoraAula = quantidadeHoraAula;
	}
	@Override
	public String dadosFormatados(){
		String dadosFormatados = super.dadosFormatados();
		dadosFormatados = dadosFormatados+"\nRegistro "+this.getNumeroRegistro();
		dadosFormatados = dadosFormatados+"\nHora/Aula: "+this.getQuantidadeHoraAula();
		return dadosFormatados();
	}
	public String getNumeroRegistro(){
		return numeroRegistro;
	}
	public void setNumeroRegistro(String numeroRegistro){
		this.numeroRegistro = numeroRegistro;
	}
	public String getQuantidadeHoraAula(){
		return quantidadeHoraAula;
	}
	public void setQuantidadeHoraAula(String quantidadeHoraAula){
		this.quantidadeHoraAula = quantidadeHoraAula;
	}
}