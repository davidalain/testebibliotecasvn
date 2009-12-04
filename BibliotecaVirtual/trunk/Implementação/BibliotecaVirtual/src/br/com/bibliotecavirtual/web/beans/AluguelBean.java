package br.com.bibliotecavirtual.web.beans;

import org.apache.struts.action.ActionForm;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class AluguelBean extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAluno;
	private int idExemplar;

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public int getIdExemplar() {
		return idExemplar;
	}

	public void setIdExemplar(int idExemplar) {
		this.idExemplar = idExemplar;
	}

	public Aluno getAluno() {
		Aluno retorno = new Aluno(idAluno, "", "", "");

		return retorno;
	}

	public Exemplar getExemplar(Livro livro) {
		Exemplar retorno = new Exemplar(idExemplar, livro, 0);

		return retorno;
	}

}
