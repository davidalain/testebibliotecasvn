package br.com.bibliotecavirtual.lib.reservas;

import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.Data;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;


public class Reserva {
	private int id;
	private Data data;
	private Aluno aluno;
	private Livro livro;
	private Funcionario funcionario;
	
	
	public Reserva(Data data, Aluno aluno, Livro livro, Funcionario funcionario) {
		super();
		this.data = data;
		this.aluno = aluno;
		this.livro = livro;
		this.funcionario = funcionario;
	}
	public Reserva(int id, Data data, Aluno aluno, Livro livro,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.data = data;
		this.aluno = aluno;
		this.livro = livro;
		this.funcionario = funcionario;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	

	
	
	
}