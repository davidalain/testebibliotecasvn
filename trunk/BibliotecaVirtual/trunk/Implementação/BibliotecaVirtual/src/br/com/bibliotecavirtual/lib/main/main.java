package br.com.bibliotecavirtual.lib.main;

import java.sql.SQLException;
import java.text.ParseException;

import br.com.bibliotecavirtual.fachada.Fachada;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;
import br.com.bibliotecavirtual.lib.exemplares.ExemplarNaoDisponivelException;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class main {

	/**
	 * @param args
	 * @throws SQLException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws SQLException, ParseException {

		Fachada fachada = Fachada.getInstance();
		Aluno aluno = new Aluno(1, "Aluno", "123", "alunomail");
		Funcionario funcionario = new Funcionario("Funcionario", "098", 1);

		Livro livro = new Livro(1, "Livro", "autor", "isbn", "area", 1998,
				"resumo");
		Exemplar exemplar = new Exemplar(3, livro, 0);

		try {
			fachada.alugar(aluno, funcionario, exemplar);
		} catch (ExemplarNaoDisponivelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
