package br.com.bibliotecavirtual.lib.alunos;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;

public class ControladorAluno {
	private IAlunoDAO repositorioAluno;

	public ControladorAluno() 
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		
		this.repositorioAluno = factory.getAlunoDAO();
	}

	public boolean validarSituacaoCadastral(String matricula) throws SQLException 
	{
		
		return this.repositorioAluno.existe(matricula);
	}
	
	public void cadastrarAluno(Aluno a) throws SQLException
	{
		this.repositorioAluno.inserir(a);
	}

	public boolean validarSituacaoFinanceira(Aluno aluno) {
		// TODO
		return true;
	}

}
