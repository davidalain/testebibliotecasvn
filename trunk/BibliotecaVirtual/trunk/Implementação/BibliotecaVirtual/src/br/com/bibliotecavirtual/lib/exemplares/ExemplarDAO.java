package br.com.bibliotecavirtual.lib.exemplares;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;
import br.com.bibliotecavirtual.lib.livros.ILivroDAO;
import br.com.bibliotecavirtual.lib.livros.Livro;
import br.com.bibliotecavirtual.lib.livros.LivroDAO;

public class ExemplarDAO implements IExemplarDAO {
	private static final String INSERIR = "inserir";
	private static final String REMOVER = "remover";
	private static final String ATUALIZAR = "atualizar";
	private static final String BUSCAR = "buscar";
	private static final String QUANTIDADE = "buscarQuantidade";
	private static final String BUSCAR_POR_LIVRO = "buscarPorLivro";
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
		int estado = exemplar.getEstado();

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(idLivro);
		parametros.add(estado);
		parametros.add(id);

		this.conexao.executeNonQuery(MAPEAMENTO, ATUALIZAR, parametros);

	}

	public void inserir(Exemplar exemplar) throws SQLException {
		int idLivro = exemplar.getLivro().getId();
		int estado = exemplar.getEstado();

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
		ILivroDAO livros = new LivroDAO();

		if (retorno.next()) {
			Livro livro = livros.buscarPorID(id);
			exemplarRetorno = new Exemplar(retorno.getInt("id"), livro, retorno
					.getInt("estado"));

		}

		return exemplarRetorno;
	}

	public int buscarPorIDLivroCount(int idLivro) throws SQLException 
	{
		ResultSet retorno = null;
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(idLivro);

		retorno = conexao.executeQuery(MAPEAMENTO, QUANTIDADE, parametros);

		if (retorno.next()) {
			return retorno.getInt("QUANTIDADE");
		}

		return 0;
	}

	public Exemplar buscarPorLivro(Livro livro) throws SQLException 
	{
		Exemplar exemplarEncontrado = new Exemplar();
		
		if(this.buscarPorIDLivroCount(livro.getId()) == 0)
		{
			
		}
		
		ArrayList<Object> parametros = new ArrayList<Object>();
		
		ResultSet retorno = this.conexao.executeQuery(MAPEAMENTO, BUSCAR_POR_LIVRO, parametros);
	
		exemplarEncontrado = materializar(retorno);
		
		return exemplarEncontrado;
	}
	
	private Exemplar materializar(ResultSet retorno) throws SQLException
	{
		Exemplar exemplarRetorno = null;
		
		ILivroDAO livros = new LivroDAO();

		if (retorno.next()) {
			Livro livro = livros.buscarPorID(retorno.getInt("id"));
			exemplarRetorno = new Exemplar(retorno.getInt("id"), livro, retorno
					.getInt("estado"));

		
		
	}
		return exemplarRetorno;
	}

}
