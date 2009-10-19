package br.com.bibliotecavirtual.lib.comum;

import br.com.bibliotecavirtual.lib.alugueis.IAluguelDAO;
import br.com.bibliotecavirtual.devolucoes.IDevolucaoDAO;
import br.com.bibliotecavirtual.lib.alunos.IAlunoDAO;
import br.com.bibliotecavirtual.lib.exemplares.IExemplarDAO;
import br.com.bibliotecavirtual.lib.funcionarios.IFuncionarioDAO;
import br.com.bibliotecavirtual.lib.livros.ILivroDAO;
import br.com.bibliotecavirtual.lib.sqlserver.SqlServerDAOFactory;

public abstract class DAOFactory {

	public static final int SQLSERVER = 1;
	public static final int MYSQL = 2;

	public abstract IConexao getConexao();

	public abstract IAlunoDAO getAlunoDAO();

	public abstract IFuncionarioDAO getFuncionarioDAO();

	public abstract ILivroDAO getLivroDAO();

	public abstract IExemplarDAO getExemplarDAO();
	
	public abstract IAluguelDAO getAluguelDAO();

	public abstract IDevolucaoDAO getDevolucaoDAO();

	public static DAOFactory getDAOFactory() {
		int whichFactory = SQLSERVER;

		switch (whichFactory) {
		case SQLSERVER:
			return new SqlServerDAOFactory();
		default:
			return null;
		}
	}
}
