package br.com.bibliotecavirtual.lib.sqlserver;

import java.sql.Connection;

import br.com.bibliotecavirtual.lib.alunos.IAlunoDAO;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;

public class SqlServerDAOFactory extends DAOFactory
{
	public static final String DRIVER=
	    "COM.cloudscape.core.RmiJdbcDriver";
	  public static final String DBURL=
	    "jdbc:cloudscape:rmi://localhost:1099/CoreJ2EEDB";

	  
	  public IConexao getConexao() 
	  {
		  return Conexao.getInstance();
	  }
	
	@Override
	public IAlunoDAO getCustomerDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	  


}
