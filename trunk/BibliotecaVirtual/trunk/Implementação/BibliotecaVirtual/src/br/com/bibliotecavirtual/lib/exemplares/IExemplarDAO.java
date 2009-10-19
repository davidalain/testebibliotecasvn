package br.com.bibliotecavirtual.lib.exemplares;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.livros.Livro;

public interface IExemplarDAO {
	public Exemplar buscarPorID(int id) throws SQLException;

	public void atualizar(Exemplar e) throws SQLException;

	public void remover(int id) throws SQLException;

	public void inserir(Exemplar e) throws SQLException;

	public boolean existe(int id) throws SQLException;

	public int buscarPorIDLivroCount(int idLivro) throws SQLException;
	
	public Exemplar buscarPorLivro(Livro livro) throws SQLException;
}
