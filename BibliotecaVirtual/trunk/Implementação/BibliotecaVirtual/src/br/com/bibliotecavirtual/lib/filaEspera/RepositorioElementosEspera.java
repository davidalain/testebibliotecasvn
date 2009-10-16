package br.com.bibliotecavirtual.lib.filaEspera;

import java.sql.ResultSet;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.sqlserver.Conexao;

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

	public void inserir(ElementoEspera elemento) {
		String alunoId = elemento.getAlunoId();
		String data = elemento.getData().toString();
		String livroId = elemento.getLivroId();

		String sql = "INSERT INTO [biblioteca].[dbo].[FIL_FILA_ESPERA]"
				+ "([LIV_ID],[ALN_ID],[FIL_DT_DATA])" + "VALUES( '" + livroId
				+ "', '" + alunoId + "', '" + data + "')";

		this.executarNonQuery(sql);
	}

	public void remover(ElementoEspera elemento) {
		String idLivro = elemento.getLivroId();

		String sql = "DELETE FROM [biblioteca].[dbo].[FIL_FILA_ESPERA]"
				+ "WHERE LIV_ID = '" + idLivro + "' ";

		this.executarNonQuery(sql);
	}

	public void atualizar(ElementoEspera elemento) {
		String alunoId = elemento.getAlunoId();
		String data = elemento.getData().toString();
		String livroId = elemento.getLivroId();

		String sql = "UPDATE [biblioteca].[dbo].[FIL_FILA_ESPERA]"
				+ "SET [ALN_ID] = '" + alunoId + "', [FIL_DT_DATA] = '" + data
				+ "' WHERE LIV_ID = '" + livroId + "' ";

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
