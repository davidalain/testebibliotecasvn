package br.com.bibliotecavirtual.lib.main;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;
import br.com.bibliotecavirtual.lib.exemplares.ExemplarNaoDisponivelException;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;
import fachada.Fachada;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Fachada fachada = Fachada.getInstance();
		Aluno aluno = new Aluno("Aluno", "123", "alunomail");
		Funcionario funcionario = new Funcionario("Funcionario", "098");
		Livro livro = new Livro("Livro", "autor", "isbn", "area", "ano",
				"resumo");
		Exemplar exemplar = new Exemplar(livro, 0);

		try {
			fachada.cadastrarAluno(aluno);
			fachada.cadastrarFuncionario(funcionario);
			fachada.cadastrarLivro(livro);
			fachada.cadastrarExemplar(exemplar);
			fachada.alugar(aluno, funcionario, exemplar);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExemplarNaoDisponivelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
