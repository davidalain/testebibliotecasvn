package br.com.bibliotecavirtual.lib.exemplares;

import java.sql.SQLException;

public interface IExemplarDAO {
	public Exemplar buscarPorID(int id) throws SQLException;

	public void atualizar(Exemplar e) throws SQLException;

	public void remover(int id) throws SQLException;

	public void inserir(Exemplar e) throws SQLException;

	public boolean existe(int id) throws SQLException;

	public int quantidade(int idLivro) throws SQLException;
}
