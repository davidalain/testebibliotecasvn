package br.com.bibliotecavirtual.dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Conexao 
{
	private static String _user = "leitura";
	
	private String _password = "leitur@";
	
	private String _serverName = "localhost";
	
	private String _instanceName = "biblioteca";
	
	private String _dataBase = "sqlexpress";
	
	private Connection _connection;
	
	private SQLServerDataSource _dataSource ;
	
	public Conexao()
	{
		this._dataSource = new SQLServerDataSource();
		
		this._dataSource.setUser(this._user);
		
		this._dataSource.setPassword(this._password);
		
		this._dataSource.setServerName(this._serverName);
		
		this._dataSource.setDatabaseName(this._dataBase);
		
		this._dataSource.setInstanceName(this._instanceName);
		
		this._connection = null;
	}
	
	public void abrirConexao()
	{
		try
		{
			this._connection = _dataSource.getConnection();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void fecharConexao()
	{
		try
		{
			this._connection.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Statement criarStatement()
	{		
		try
		{
			return  this._connection.createStatement();
		}
		catch(SQLException e)
		{
			throw new RuntimeException();
		}
	}
	
	
}
