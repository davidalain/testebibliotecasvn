package br.com.bibliotecavirtual.lib.funcionarios;

public class Funcionario {
	private String nome;
	private String cpf;
	private int id;

	public Funcionario(String nome, String cpf, int id) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
