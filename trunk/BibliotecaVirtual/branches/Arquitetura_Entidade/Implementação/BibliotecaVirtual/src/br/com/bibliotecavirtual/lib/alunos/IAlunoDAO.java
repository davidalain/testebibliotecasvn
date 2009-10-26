package br.com.bibliotecavirtual.lib.alunos;

import java.sql.SQLException;

public interface IAlunoDAO 
{
	public Aluno buscarPorID(int id) throws SQLException;
	
	public Aluno buscarPorMatricula(String matricula) throws SQLException;
	
	public void atualizar(Aluno a) throws SQLException ;
	
	public void remover(int id) throws SQLException;
	
	public void remover(String matricula) throws SQLException;
	
	public void inserir(Aluno a) throws SQLException;
	
	public boolean existe(String matricula) throws SQLException;
	

}
