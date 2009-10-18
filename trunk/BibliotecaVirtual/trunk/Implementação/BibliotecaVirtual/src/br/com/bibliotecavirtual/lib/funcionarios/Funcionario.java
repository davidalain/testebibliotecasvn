package br.com.bibliotecavirtual.lib.funcionarios;

public class Funcionario {
	private String nome;
	private String cpf;
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Funcionario(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCpf() {
		return cpf;
	}
	
	
}
