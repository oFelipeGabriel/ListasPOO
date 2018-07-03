package fatec.modelo;

public class Aluno extends Pessoa{
	private String numeroMatricula;
	
	public Aluno(String nome, String telefone, String email, String numeroMatricula){
		super(nome, telefone, email);
		this.numeroMatricula = numeroMatricula;		
	}
	@Override
	public String dadosFormatados(){
		String dadosFormatados = super.dadosFormatados();
		dadosFormatados = dadosFormatados+"\nMatricula: "+this.getNumeroMatricula();
		return dadosFormatados;
	}
	public String getNumeroMatricula(){
		return numeroMatricula;
	}
	public void setNumeroMatricula(String numeroMatricula){
		this.numeroMatricula = numeroMatricula;
	}
	public String getAlunos(){
		return getNome();
	}
}