package br.com.bibliotecavirtual.dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Conexao {
	private static String _user = "leitura";

	private String _password = "leitur@";

	private String _serverName = "localhost";

	private String _instanceName = "sqlexpress";

	private String _dataBase = "biblioteca";

	private Connection _connection;

	private SQLServerDataSource _dataSource;

	public Conexao() {
		this._dataSource = new SQLServerDataSource();

		this._dataSource.setUser(this._user);

		this._dataSource.setPassword(this._password);

		this._dataSource.setServerName(this._serverName);

		this._dataSource.setDatabaseName(this._dataBase);

		this._dataSource.setInstanceName(this._instanceName);

		this._connection = null;
	}

	public void abrirConexao() {
		try {
			this._connection = _dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void fecharConexao() {
		try {
			this._connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Statement criarStatement() {
		try {
			return this._connection.createStatement();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public ResultSet executarQuery(String sql) {

		try {
			return this.criarStatement().executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public int executarNonQuery(String sql) {
		try {
			return this.criarStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}

}
