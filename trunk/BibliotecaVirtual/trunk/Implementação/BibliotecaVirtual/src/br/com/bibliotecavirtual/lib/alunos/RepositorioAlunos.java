package br.com.bibliotecavirtual.lib.alunos;

import java.sql.ResultSet;

import br.com.bibliotecavirtual.dados.Conexao;

public class RepositorioAlunos {

	private Conexao conexao = new Conexao();

	// comentARIO

	public RepositorioAlunos() {
		conexao = new Conexao();
	}

	private void executarNonQuery(String sql) {
		conexao.abrirConexao();
		conexao.executarNonQuery(sql);
		conexao.fecharConexao();
	}

	public void inserir(Aluno aluno) {
		String login = aluno.getNome();
		String email = aluno.getEmail();
		String matricula = aluno.getCpf();

		String sql = "INSERT INTO [biblioteca].[dbo].[ALN_ALUNO]"
				+ "([ALN_NM_LOGIN],[ALN_NM_EMAIL],[ALN_CD_MATRICULA])"
				+ " VALUES(' " + login + "','" + email + "','" + matricula
				+ "')";

		this.executarNonQuery(sql);
	}

	public void remover(Aluno aluno) {
		String matricula = aluno.getCpf();

		String sql = "DELETE FROM [biblioteca].[dbo].[ALN_ALUNO]"
				+ "WHERE ALN_CD_MATRICULA = '" + matricula + "' ";

		this.executarNonQuery(sql);
	}

	public void atualizar(Aluno aluno) {
		String login = aluno.getNome();
		String email = aluno.getEmail();
		String matricula = aluno.getCpf();

		String sql = "UPDATE [biblioteca].[dbo].[ALN_ALUNO]"
				+ "SET [ALN_NM_LOGIN] = '" + login + "', [ALN_NM_EMAIL] = '"
				+ email + "' WHERE ALN_CD_MATRICULA = '" + matricula + "' ";

		this.executarNonQuery(sql);
	}

	public ResultSet buscar(Aluno aluno) {
		String matricula = aluno.getCpf();
		ResultSet retorno = null;

		String sql = "SELECT * FROM [biblioteca].[dbo].[ALN_ALUNO]"
				+ "WHERE ALN_CD_MATRICULA = '" + matricula + "' ";

		conexao.abrirConexao();
		retorno = conexao.executarQuery(sql);
		conexao.fecharConexao();

		return retorno;
	}
}
