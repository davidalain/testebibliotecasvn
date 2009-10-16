package br.com.bibliotecavirtual.lib.sqlserver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import br.com.bibliotecavirtual.lib.comum.IConexao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Conexao implements IConexao {
	private static Conexao instance;

	private Properties props = new Properties();

	private Connection _connection;

	private SQLServerDataSource _dataSource;

	private Conexao() {

		try {
			this.props.load(new FileInputStream("aplicacao.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this._dataSource = new SQLServerDataSource();

		this._dataSource.setUser(props.getProperty("BD_user"));

		this._dataSource.setPassword(props.getProperty("BD_password"));

		this._dataSource.setServerName(props.getProperty("BD_serverName"));

		this._dataSource.setDatabaseName(props.getProperty("BD_dataBase"));

		this._dataSource.setInstanceName(props.getProperty("BD_instanceName"));

		this._connection = null;
	}

	public void executeNonQuery(String caminho, String chave,
			ArrayList<Object> parametros) throws SQLException {
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
		
		this.abrirConexao();

		PreparedStatement comando = this._connection.prepareStatement(consulta);

		int indice = 1;
		for (Object o : parametros) {
			comando.setObject(indice, o);
			indice++;
		}

		abrirConexao();

		comando.executeUpdate();

		fecharConexao();

	}

	public ResultSet executeQuery(String caminho, String chave,
			ArrayList<Object> parametros) throws SQLException {
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

		int indice = 1;
		for (Object o : parametros) {
			comando.setObject(indice, o);
			indice++;
		}

		abrirConexao();

		ResultSet retorno = comando.executeQuery();

		fecharConexao();

		return retorno;
	}

	public static synchronized Conexao getInstance() {
		if (instance == null) {
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
