package br.com.bibliotecavirtual.lib.filaEspera;

import java.sql.ResultSet;
import java.util.Date;

import br.com.bibliotecavirtual.dados.Conexao;
import br.com.bibliotecavirtual.lib.alunos.Aluno;

public class RepositorioElementosEspera {
	private Conexao conexao = new Conexao();

	// comentARIO

	public RepositorioElementosEspera() {
		conexao = new Conexao();
	}

	private void executarNonQuery(String sql) {
		conexao.abrirConexao();
		conexao.executarNonQuery(sql);
		conexao.fecharConexao();
	}

	public void inserir(FilaEspera fila) {
		String alunoId = fila.getAlunoId();
		Date data = fila.getData();
		String livroId = fila.getLivroId();

		String sql = "INSERT INTO [biblioteca].[dbo].[FIL_FILA_ESPERA]"
				+ "([LIV_ID],[ALN_ID],[FIL_DT])" + "VALUES( '" + livroId
				+ "', '" + alunoId + "', '" + data.toString() + "'";

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

		String sql = "SELECT [ALU_ID],[ALN_NM_LOGIN],[ALN_NM_EMAIL],[ALN_CD_MATRICULA] FROM [biblioteca].[dbo].[ALN_ALUNO]"
				+ "WHERE ALN_CD_MATRICULA = '" + matricula + "' ";

		conexao.abrirConexao();
		retorno = conexao.executarQuery(sql);
		conexao.fecharConexao();

		return retorno;
	}
}
