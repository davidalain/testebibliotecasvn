package br.com.bibliotecavirtual.lib.alunos;

import java.sql.ResultSet;

import br.com.bibliotecavirtual.dados.Conexao;

public class RepositorioAlunos {

	private Conexao conexao = new Conexao();

	public RepositorioAlunos() {
		conexao = new Conexao();
	}

	public void inserir(Aluno aluno) {
		String login = aluno.getNome();
		String email = aluno.getEmail();
		String matricula = aluno.getCpf();

		String sql = "INSERT INTO [biblioteca].[dbo].[ALN_ALUNO]"
				+ "([ALU_ID],[ALN_NM_LOGIN],[ALN_NM_EMAIL],[ALN_CD_MATRICULA],[ALN_ST])"
				+ "VALUES (1, '" + login + "','" + email + "','" + matricula
				+ "','" + "'OK')";

		conexao.abrirConexao();
		conexao.executarNonQuery(sql);
		conexao.fecharConexao();
	}

	public void remover(Aluno a) {

	}

	public void atualizar(Aluno a) {

	}

	public ResultSet buscar(String cpf) {

		return null;
	}

}
