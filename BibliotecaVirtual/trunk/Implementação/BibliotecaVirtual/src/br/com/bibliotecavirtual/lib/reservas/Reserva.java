package br.com.bibliotecavirtual.lib.reservas;

import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;


public class Reserva {
	private int id;
	private Date data;
	private Aluno aluno;
	private Livro livro;
	private Funcionario funcionario;
	
	public Reserva(Date data, Aluno aluno, Livro livro, Funcionario funcionario) {
		super();
		this.data = data;
		this.aluno = aluno;
		this.livro = livro;
		this.funcionario = funcionario;
	}
	public Reserva(int id, Date data, Aluno aluno, Livro livro,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.data = data;
		this.aluno = aluno;
		this.livro = livro;
		this.funcionario = funcionario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Aluno getAluno() {
		return aluno;
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