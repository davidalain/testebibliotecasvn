package br.com.bibliotecavirtual.lib.alunos;

public class Aluno {

	private int id;
	private String nome;
	private String cpf;
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aluno(String nome, String cpf, String email) {
		super();
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.id = 0;
	}
	
	public Aluno(int id, String nome, String cpf, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
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


}
