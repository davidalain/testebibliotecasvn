package br.com.bibliotecavirtual.lib.alugados;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.bibliotecavirtual.dados.Conexao;
import br.com.bibliotecavirtual.lib.alunos.Aluno;

public class RepositorioAlgueis {
	private Conexao conexao = new Conexao();

	// comentARIO

	public RepositorioAlgueis() {
		conexao = new Conexao();
	}

	private void executarNonQuery(String sql) {
		conexao.abrirConexao();
		conexao.executarNonQuery(sql);
		conexao.fecharConexao();
	}

	public void inserir(Aluguel aluguel) {
		String idAluno = aluguel.getIdAluno();
		String idFuncionario = aluguel.getIdFuncionario();
		String idLivro = aluguel.getIdLivro();
		String dataAluguel = aluguel.getDataAluguel().toString();
		String dataDevolucao = aluguel.getDataDevolucao().toString();

		String sql = "INSERT INTO [biblioteca].[dbo].[ALG_ALUGUEL]([EXP_ID],[ALN_ID],[FUN_ID],[ALG_DT],[ALG_DT_DEVOLUCAO])"
     "VALUES(<EXP_ID, int,>,<ALN_ID, int,>
           ,<FUN_ID, int,>
           ,<ALG_DT, datetime,>
           ,<ALG_DT_DEVOLUCAO, nvarchar(4000),>)";

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
