package br.com.bibliotecavirtual.lib.alunos;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;

public class ControladorAluno {
	private IAlunoDAO repositorio;

	public ControladorAluno() 
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		
		this.repositorio = factory.getAlunoDAO();
	}

	public boolean validarSituacaoCadastral(String matricula) throws SQLException 
	{
		
		return this.repositorio.existeAluno(matricula);
	}
	
	public void cadastrarAluno(Aluno a) throws SQLException
	{
		this.repositorio.inserirAluno(a);
	}

	public boolean validarSituacaoFinanceira(Aluno aluno) {
		// TODO
		return true;
	}

}
