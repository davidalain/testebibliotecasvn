package br.com.bibliotecavirtual.lib.alunos;

import java.sql.ResultSet;

import br.com.bibliotecavirtual.dados.Conexao;

public class RepositorioAlunos {

	private Conexao conexao = new Conexao();

	// comentARIO

	public RepositorioAlunos() {
		conexao = new Conexao();
	}

	private void executarQuery(String sql) {
		conexao.abrirConexao();
		conexao.executarQuery(sql);
		conexao.fecharConexao();
	}

	private void executarNon(String sql) {
		conexao.abrirConexao();
		conexao.executarNonQuery(sql);
		conexao.fecharConexao();
	}

	public void inserir(Aluno aluno) {
		String login = aluno.getNome();
		String email = aluno.getEmail();
		String matricula = aluno.getCpf();

		String sql = "INSERT INTO [biblioteca].[dbo].[ALN_ALUNO]"
				+ "([ALN_NM_LOGIN],[ALN_NM_EMAIL],[ALN_CD_MATRICULA],[ALN_ST])"
				+ " VALUES(' " + login + "','" + email + "','" + matricula
				+ "'," + "'OK')";

		this.executarNon(sql);
	}

	public void remover(Aluno aluno) {
		String matricula = aluno.getCpf();

		String sql = "DELETE FROM [biblioteca].[dbo].[ALN_ALUNO]"
				+ "WHERE ALN_CD_MATRICULA = '" + matricula + "' ";

		this.executarNon(sql);
	}

	public void atualizar(Aluno a) {

	}

	public ResultSet buscar(String cpf) {
		return null;
	}
}
