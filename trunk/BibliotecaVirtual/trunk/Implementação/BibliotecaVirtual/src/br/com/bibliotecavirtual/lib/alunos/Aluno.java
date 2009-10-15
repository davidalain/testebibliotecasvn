package br.com.bibliotecavirtual.lib.alunos;

public class Aluno {

	private String nome;
	private String cpf;
	private String senha;
	private String email;
	
	public Aluno(String nome, String cpf, String senha, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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


}
