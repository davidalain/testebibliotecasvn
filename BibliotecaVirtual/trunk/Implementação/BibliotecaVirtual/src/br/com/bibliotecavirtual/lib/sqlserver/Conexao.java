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

	private Properties configuracao;

	private Properties mapeamento;

	private Connection _connection;

	private SQLServerDataSource _dataSource;

	private Conexao() {

		try {
			this.configuracao = new Properties();
			this.configuracao.load(new FileInputStream(
					"configuracao.properties"));

			this.mapeamento = new Properties();
			this.mapeamento.load(new FileInputStream(this.configuracao
					.getProperty("mapeamentoXml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this._dataSource = new SQLServerDataSource();

		this._dataSource.setUser(configuracao.getProperty("BD_user"));

		this._dataSource.setPassword(configuracao.getProperty("BD_password"));

		this._dataSource.setServerName(configuracao
				.getProperty("BD_serverName"));

		this._dataSource.setDatabaseName(configuracao
				.getProperty("BD_dataBase"));

		this._dataSource.setInstanceName(configuracao
				.getProperty("BD_instanceName"));

		this._connection = null;
	}

	public void executeNonQuery(String mapeamento, String chave,
			ArrayList<Object> parametros) throws SQLException {
		Properties prop = new Properties();

		try {
			String caminho = this.mapeamento.getProperty(mapeamento);
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

	public ResultSet executeQuery(String mapeamento, String chave,
			ArrayList<Object> parametros) throws SQLException {
		Properties prop = new Properties();

		try {
			String caminho = this.mapeamento.getProperty(mapeamento);
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

		this.abrirConexao();

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
