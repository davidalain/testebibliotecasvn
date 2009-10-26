package br.com.bibliotecavirtual.lib.livros;

import java.sql.SQLException;

public interface ILivroDAO {



	public void inserir (Livro livro) throws SQLException;
	public void remover (String isbn) throws SQLException;
	public void atualizar (Livro livro) throws SQLException;
	public Livro buscarPorISBN (String isbn) throws SQLException;
	public boolean existe (String isbn) throws SQLException;
	public Livro buscarPorID (int id) throws SQLException;



}
