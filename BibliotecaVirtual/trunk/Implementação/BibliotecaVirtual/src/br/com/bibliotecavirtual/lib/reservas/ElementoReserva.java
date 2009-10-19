package br.com.bibliotecavirtual.lib.reservas;

import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.livros.Livro;


public class ElementoReserva {
	private Date data;
	private Aluno aluno;
	private Livro livro;
	
	public ElementoReserva(Date data, Aluno aluno, Livro livro) {
		super();
		this.data = data;
		this.aluno = aluno;
		this.livro = livro;
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