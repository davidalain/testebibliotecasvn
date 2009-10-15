package br.com.bibliotecavirtual.lib.exemplares;

import java.sql.ResultSet;

import br.com.bibliotecavirtual.dados.Conexao;

public class RepositorioExemplares {
	private Conexao conexao = new Conexao();

	public RepositorioExemplares() {
		conexao = new Conexao();
	}

	private void executarNonQuery(String sql) {
		conexao.abrirConexao();
		conexao.executarNonQuery(sql);
		conexao.fecharConexao();
	}

	public void inserir(Exemplar exemplar) {

		String sql = "INSERT INTO [biblioteca].[dbo].[EXP_EXEMPLAR]([LIV_ID],[EXP_ST])"
				+ "VALUES(<LIV_ID, int,>,<EXP_ST, int,>)";

		this.executarNonQuery(sql);
	}

	public void remover(Exemplar exemplar) {

		String sql = "";

		this.executarNonQuery(sql);
	}

	public void atualizar(Exemplar exemplar) {

		String sql = "";

		this.executarNonQuery(sql);
	}

	public Exemplar buscar(Exemplar exemplar) {
		ResultSet retorno = null;

		String sql = "";

		conexao.abrirConexao();
		retorno = conexao.executarQuery(sql);
		conexao.fecharConexao();
		return retorno;
	}

}
