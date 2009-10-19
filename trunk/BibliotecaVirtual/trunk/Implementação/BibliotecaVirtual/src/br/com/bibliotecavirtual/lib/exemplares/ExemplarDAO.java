package br.com.bibliotecavirtual.lib.exemplares;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;

public class ExemplarDAO implements IExemplarDAO {
	private static final String INSERIR = "inserir";
	private static final String REMOVER = "remover";
	private static final String ATUALIZAR = "atualizar";
	private static final String BUSCAR = "buscar";
	private static final String QUANTIDADE = "buscarQuantidade";
	private static final String MAPEAMENTO = Exemplar.class.getName();

	private IConexao conexao;

	// comentARIO

	public ExemplarDAO() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		conexao = factory.getConexao();

	}

	public void atualizar(Exemplar exemplar) throws SQLException {
		int id = exemplar.getId();
		int idLivro = exemplar.getLivro().getId();
		String estado = exemplar.getEstado();

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(idLivro);
		parametros.add(estado);
		parametros.add(id);

		this.conexao.executeNonQuery(MAPEAMENTO, ATUALIZAR, parametros);

	}

	public void inserir(Exemplar exemplar) throws SQLException {
		int idLivro = exemplar.getLivro().getId();
		String estado = exemplar.getEstado();

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(idLivro);
		parametros.add(estado);

		conexao.executeNonQuery(MAPEAMENTO, INSERIR, parametros);

	}

	public void remover(int id) throws SQLException {
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(id);

		conexao.executeNonQuery(MAPEAMENTO, REMOVER, parametros);
	}

	public boolean existe(int id) throws SQLException {
		return this.buscarPorID(id) != null;
	}

	public Exemplar buscarPorID(int id) throws SQLException {
		Exemplar exemplarRetorno = null;

		ResultSet retorno = null;

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(id);

		retorno = conexao.executeQuery(MAPEAMENTO, BUSCAR, parametros);

		if (retorno.next()) {

			exemplarRetorno = new Exemplar(retorno.getInt("id"), retorno
					.getInt("idLivro"), retorno.getString("estado"));

		}

		return exemplarRetorno;
	}

	public int quantidade(int idLivro) throws SQLException {
		ResultSet retorno = null;
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(idLivro);

		retorno = conexao.executeQuery(MAPEAMENTO, QUANTIDADE, parametros);

		int cont = 0;

		while (retorno.next()) {
			cont++;
		}

		return cont;
	}
}
