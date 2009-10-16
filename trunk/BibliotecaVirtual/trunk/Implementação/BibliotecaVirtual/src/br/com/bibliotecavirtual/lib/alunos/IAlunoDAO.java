package br.com.bibliotecavirtual.lib.alunos;

import java.sql.SQLException;

public interface IAlunoDAO 
{
	public Aluno obterAlunoPorID(int id) throws SQLException;
	
	public Aluno obterAlunoPorMatricula(String matricula) throws SQLException;
	
	public void atualizarAluno(Aluno a) throws SQLException;
	
	public void removerAluno(int id) throws SQLException;
	
	public void inserirAluno(Aluno a) throws SQLException;
	

}
