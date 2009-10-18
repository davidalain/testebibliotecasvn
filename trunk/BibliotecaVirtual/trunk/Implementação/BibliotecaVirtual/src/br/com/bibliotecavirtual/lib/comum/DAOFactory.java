package br.com.bibliotecavirtual.lib.comum;

import br.com.bibliotecavirtual.lib.alunos.IAlunoDAO;
import br.com.bibliotecavirtual.lib.funcionarios.FuncionarioDAO;
import br.com.bibliotecavirtual.lib.funcionarios.IFuncionarioDAO;
import br.com.bibliotecavirtual.lib.sqlserver.SqlServerDAOFactory;

	public abstract class DAOFactory {

		  public static final int SQLSERVER = 1;
		  public static final int MYSQL = 2;
		  
		 
		  public abstract IConexao getConexao();
		  
		  public abstract IAlunoDAO getAlunoDAO();
		  
		  public abstract IFuncionarioDAO getFuncionarioDAO();
		


		  public static DAOFactory getDAOFactory() 
		  {
			  int whichFactory = SQLSERVER;
		  
		    switch (whichFactory) {
		      case SQLSERVER: 
		          return new SqlServerDAOFactory();
		      default           : 
		          return null;
		    }
		  }
		}

