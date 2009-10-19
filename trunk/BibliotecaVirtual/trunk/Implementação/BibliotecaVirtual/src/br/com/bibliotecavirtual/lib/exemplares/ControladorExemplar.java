package br.com.bibliotecavirtual.lib.exemplares;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;

public class ControladorExemplar {

	private IExemplarDAO repositorioExemplares;

	public ControladorExemplar() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		this.repositorioExemplares = factory.getExemplarDAO();
	}

	public int quantidadeExemplares(Exemplar exemplar) throws SQLException {
		int idLivro = exemplar.getLivro().getId();
		return repositorioExemplares.buscarPorIDLivroCount(idLivro);
	}

}
