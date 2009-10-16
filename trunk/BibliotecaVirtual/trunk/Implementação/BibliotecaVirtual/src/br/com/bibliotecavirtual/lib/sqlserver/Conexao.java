package br.com.bibliotecavirtual.lib.sqlserver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import br.com.bibliotecavirtual.lib.comum.IConexao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Conexao implements IConexao {
	private static String _user = "leitura";
	
	private static Conexao instance;

	private String _password = "leitur@";

	private String _serverName = "localhost";

	private String _instanceName = "sqlexpress";

	private String _dataBase = "biblioteca";

	private Connection _connection;

	private SQLServerDataSource _dataSource;

	
	private Conexao() {
		
		
		this._dataSource = new SQLServerDataSource();

		this._dataSource.setUser(this._user);

		this._dataSource.setPassword(this._password);

		this._dataSource.setServerName(this._serverName);

		this._dataSource.setDatabaseName(this._dataBase);

		this._dataSource.setInstanceName(this._instanceName);

		this._connection = null;
	}
	
	public void executeNonQuery(String caminho, String chave, ArrayList<Object> parametros) throws SQLException
	{
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(caminho));
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String consulta = prop.getProperty(chave);
		
		PreparedStatement comando = this._connection.prepareStatement(consulta);
		
		int indice = 0;
		for(Object o : parametros)
		{
			comando.setObject(indice, o);
			indice++;
		}
		
		abrirConexao();
		
		comando.executeUpdate();
		
		fecharConexao();
		
	}
	
	public ResultSet executeQuery(String caminho, String chave, ArrayList<Object> parametros) throws SQLException
	{
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(caminho));
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String consulta = prop.getProperty(chave);
		
		PreparedStatement comando = this._connection.prepareStatement(consulta);
		
		int indice = 0;
		for(Object o : parametros)
		{
			comando.setObject(indice, o);
			indice++;
		}
		
		abrirConexao();
		
		ResultSet retorno  = comando.executeQuery();
		
		fecharConexao();
		
		return retorno;
	}
	
	
	public static synchronized Conexao getInstance()
	{
		if(instance == null)
		{
			instance = new Conexao();
		}
		
		return instance;
	}

	private void abrirConexao() {
		try {
			this._connection = _dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void fecharConexao() {
		try {
			this._connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
