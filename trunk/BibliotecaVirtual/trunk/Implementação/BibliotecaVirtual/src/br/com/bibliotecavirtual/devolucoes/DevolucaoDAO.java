package br.com.bibliotecavirtual.devolucoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import br.com.bibliotecavirtual.lib.alugueis.Aluguel;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;

public class DevolucaoDAO implements IDevolucaoDAO {

	private static final String BUSCAR_POR_EXEMPLAR = "buscarPorExemplar";
	private static final String MAPEAMENTO = Devolucao.class.getName();
	private IConexao conexao;

	public DevolucaoDAO() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		conexao = factory.getConexao();
	}

	public void atualizar(Aluguel aluguel) throws SQLException {
		// TODO Auto-generated method stub

	}

	public int buscarPorAlunoCount(Aluguel aluguel) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<Devolucao> buscarPorExemplar(Exemplar exemplar)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int buscarPorExemplarCount(Exemplar exemplar) throws SQLException {
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(exemplar.getLivro().getId());

		ResultSet retorno = this.conexao.executeQuery(MAPEAMENTO,
				BUSCAR_POR_EXEMPLAR, parametros);

		if (retorno.next()) {
			return retorno.getInt("QUANTIDADE");
		}
		return 0;
	}

	public Collection<Devolucao> buscarPorFuncionario(Aluno aluno)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
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

	public void inserir(Aluguel aluguel) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void remover(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
