package br.com.bibliotecavirtual.lib.main;

import java.sql.SQLException;
import java.text.ParseException;

import br.com.bibliotecavirtual.fachada.Fachada;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class main {

	/**
	 * @param args
	 * @throws SQLException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws SQLException, ParseException {

		Aluno aluno = new Aluno(4, "", "", "");
		Livro livro = new Livro(2, "", "", "", "", 1998, "");
		Exemplar exemplar = new Exemplar(3, livro, 0);
		Fachada fachada = Fachada.getInstance();
		Funcionario funcionario = new Funcionario("Funcionario", "098", 1);

		try {
			fachada.alugar(aluno, funcionario, exemplar);

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}
}
