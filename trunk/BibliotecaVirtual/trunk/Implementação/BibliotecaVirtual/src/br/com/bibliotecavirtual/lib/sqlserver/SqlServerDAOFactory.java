package br.com.bibliotecavirtual.lib.sqlserver;

import java.sql.Connection;

import br.com.bibliotecavirtual.lib.alunos.AlunoDAO;
import br.com.bibliotecavirtual.lib.alunos.IAlunoDAO;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;

public class SqlServerDAOFactory extends DAOFactory
{	  
	  public IConexao getConexao() 
	  {
		  return Conexao.getInstance();
	  }
	
	@Override
	public IAlunoDAO getAlunoDAO() {
		// TODO Auto-generated method stub
		return new AlunoDAO();
	}
	  


}
