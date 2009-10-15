package br.com.bibliotecavirtual.lib.livros;

import java.sql.ResultSet;

import br.com.bibliotecavirtual.dados.Conexao;

public class RepositorioLivros {
	private Conexao conexao = new Conexao();

	public RepositorioLivros() {
		conexao = new Conexao();
	}

	private void executarNonQuery(String sql) {
		conexao.abrirConexao();
		conexao.executarNonQuery(sql);
		conexao.fecharConexao();
	}

	public void inserir(Livro livro) {

		String titulo = livro.getTitulo();
		String autor = livro.getAutor();
		String area = livro.getArea();
		String ano = livro.getAno();
		String isbn = livro.getIsbn();

		String sql = "INSERT INTO [biblioteca].[dbo].[LIV_LIVRO]"
				+ "([LIV_NM_TITULO],[LIV_NM_AUTOR],[LIV_SC_AREA],[LIV_NU_ANO],[LIV_NM_ISBN])"
				+ " VALUES('" + titulo + "','" + autor + "','" + area + "','"
				+ ano + "','" + isbn + "')";

		this.executarNonQuery(sql);
	}

	public void remover(Livro livro) {
		String isbn = livro.getIsbn();

		String sql = "DELETE FROM [biblioteca].[dbo].[LIV_LIVRO]"
				+ "WHERE LIV_NM_ISBN = '" + isbn + "'";

		this.executarNonQuery(sql);
	}

	public void atualizar(Livro livro) {
		String titulo = livro.getTitulo();
		String autor = livro.getAutor();
		String area = livro.getArea();
		String ano = livro.getAno();
		String isbn = livro.getIsbn();

		String sql = "UPDATE [biblioteca].[dbo].[LIV_LIVRO]"
				+ "SET [LIV_NM_TITULO] ='" + titulo + "',[LIV_NM_AUTOR] = '"
				+ autor + "',[LIV_SC_AREA] = '" + area + "',[LIV_NU_ANO] = '"
				+ ano + "' WHERE LIV_NM_ISBN = '" + isbn + "'";

		this.executarNonQuery(sql);
	}

	public ResultSet buscar(Livro livro) {
		String isbn = livro.getIsbn();
		ResultSet retorno = null;

		String sql = "SELECT [LIV_ID],[LIV_NM_TITULO],[LIV_NM_AUTOR]"
				+ ",[LIV_SC_AREA],[LIV_NU_ANO],[LIV_NM_ISBN]"
				+ "FROM [biblioteca].[dbo].[LIV_LIVRO]"
				+ "WHERE LIV_NM_ISBN = '" + isbn + "'";

		conexao.abrirConexao();
		retorno = conexao.executarQuery(sql);
		conexao.fecharConexao();

		return retorno;
	}
}
