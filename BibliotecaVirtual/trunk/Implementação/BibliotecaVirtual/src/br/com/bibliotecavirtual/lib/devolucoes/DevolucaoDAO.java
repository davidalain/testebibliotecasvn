package br.com.bibliotecavirtual.lib.devolucoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class DevolucaoDAO implements IDevolucaoDAO {

	private static final String BUSCAR_POR_EXEMPLAR = "buscarPorExemplar";
	private static final String MAPEAMENTO = Devolucao.class.getName();
	private IConexao conexao;

	public DevolucaoDAO() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		conexao = factory.getConexao();
	}

	public int buscarPorLivroCount(Livro livro) throws SQLException {
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(livro.getId());

		ResultSet retorno = this.conexao.executeQuery(MAPEAMENTO,
				BUSCAR_POR_EXEMPLAR, parametros);

		if (retorno.next()) {
			return retorno.getInt("QUANTIDADE");
		}
		return 0;
	}

	public void buscarPorID(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	public Collection<Devolucao> buscarPorPeriodo(Date dataInicial,
			Date dataFinal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int buscarPorPeriodoCount(Date dataInicial, Date dataFinal)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void inserir(Devolucao devolucao) throws SQLException {
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(devolucao.getAluguel());
		parametros.add(devolucao.getData());
		parametros.add(devolucao.getFuncionario());

		this.conexao.executeNonQuery(MAPEAMENTO, "INSERIR", parametros);
	}

	public void remover(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void atualizar(Devolucao devolucao) throws SQLException {
		// TODO Auto-generated method stub

	}

	public int buscarPorAlunoCount(Aluno aluno) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<Devolucao> buscarPorFuncionario(Funcionario funcionario)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Devolucao> buscarPorLivro(Livro livro)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
