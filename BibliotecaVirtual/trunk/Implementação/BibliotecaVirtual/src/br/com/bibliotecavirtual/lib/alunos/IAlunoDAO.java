package br.com.bibliotecavirtual.lib.alunos;

import java.sql.SQLException;

public interface IAlunoDAO 
{
	public Aluno buscarAlunoPorID(int id) throws SQLException;
	
	public Aluno buscarAlunoPorMatricula(String matricula) throws SQLException;
	
	public void atualizarAluno(Aluno a) throws SQLException ;
	
	public void removerAluno(int id) throws SQLException;
	
	public void removerAluno(String matricula) throws SQLException;
	
	public void inserirAluno(Aluno a) throws SQLException;
	
	public boolean existeAluno(String matricula) throws SQLException;
	

}
