package br.com.bibliotecavirtual.lib.comum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IConexao 
{
	public ResultSet executeQuery(String caminho, String chave, ArrayList<Object> parametros) throws SQLException;
	
	public void executeNonQuery(String caminho, String chave, ArrayList<Object> parametros) throws SQLException;
}
