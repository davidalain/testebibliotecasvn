package br.com.bibliotecavirtual.dados;

import java.sql.Date;
import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.alunos.RepositorioAlunos;
import br.com.bibliotecavirtual.lib.filaEspera.ElementoEspera;

public class Principal {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		RepositorioAlunos rep2 = new RepositorioAlunos();
		Date data = new Date(System.currentTimeMillis());

		Aluno aluno = new Aluno("Maria", "135708", "rogerAmor", "mariCrazy");
		ElementoEspera es = new ElementoEspera(data, "12", "345");

		rep2.atualizar(aluno);
	}
}
