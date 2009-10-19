package br.com.bibliotecavirtual.lib.exemplares;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;

public class ControladorExemplar {

	private IExemplarDAO repositorioExemplares;
	private ControladorAluguel repositorioAlugueis;
	private Controlador repositorioDevolucoes;

	public ControladorExemplar() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		this.repositorioExemplares = factory.getExemplarDAO();
	}

	public int quantidadeExemplares(Exemplar exemplar) {
		int idLivro = exemplar.getLivro().getId();
		return repositorioExemplares.buscarPorIDLivroCount(idLivro);
	}

	public boolean existeExemplarDisponivel(Exemplar exemplar)
			throws SQLException {
		int idLivro = exemplar.getLivro().getId();
		int numExemplares = repositorioExemplares
				.buscarPorIDLivroCount(idLivro);
		int numAlugueis = repositorioAlugueis.buscarPorExemplarCount(exemplar);
		int numDevolucoes = repositorioDevolucoes
				.buscarPorExemplarCount(exemplar);

		return (numAlugueis - numDevolucoes < numExemplares);
	}
}
