package basicas;

public class Aluno {

	private String nome;
	private String cpf;
	private String senha;
	private Endereco endereco;
	private String telefone;
	private double divida;
	
	public Aluno(String nome, String cpf, String senha, Endereco endereco,
			String telefone, double divida) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;
		this.divida = divida;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public double getDivida() {
		return divida;
	}
	public void setDivida(double divida) {
		this.divida = divida;
	}
	
	
	
}
