package br.com.bibliotecavirtual.lib.alunos;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		String senha = aluno.getSenha();

		String sql = "INSERT INTO [biblioteca].[dbo].[ALN_ALUNO]"
				+ "([ALN_NM_LOGIN],[ALN_NM_EMAIL],[ALN_CD_MATRICULA],[ALN_NM_SENHA])"
				+ " VALUES(' " + login + "','" + email + "','" + matricula
				+ "','" + senha + "')";

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
		String senha = aluno.getSenha();

		String sql = "UPDATE [biblioteca].[dbo].[ALN_ALUNO]"
				+ "SET [ALN_NM_LOGIN] = '" + login + "', [ALN_NM_EMAIL] = '"
				+ email + "', [ALN_NM_SENHA] = '" + senha
				+ "' WHERE ALN_CD_MATRICULA = '" + matricula + "' ";

		this.executarNonQuery(sql);
	}

	public Aluno buscar(Aluno aluno) throws SQLException {
		Aluno alunoRetorno = null;
		String matricula = aluno.getCpf();
		ResultSet retorno = null;

		String sql = "SELECT * FROM [biblioteca].[dbo].[ALN_ALUNO]"
				+ "WHERE ALN_CD_MATRICULA = '" + matricula + "' ";

		conexao.abrirConexao();
		retorno = conexao.executarQuery(sql);
		if (retorno.next()) {
			alunoRetorno = new Aluno(retorno.getString("ALN_NM_LOGIN"), retorno
					.getString("ALN_CD_MATRICULA"), retorno
					.getString("ALN_NM_SENHA"), retorno
					.getString("ALN_NM_EMAIL"));

		}
		conexao.fecharConexao();

		return alunoRetorno;
	}
}
