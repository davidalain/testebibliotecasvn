package br.com.bibliotecavirtual.lib.exemplares;

import java.sql.SQLException;

import br.com.bibliotecavirtual.devolucoes.IDevolucaoDAO;
import br.com.bibliotecavirtual.lib.alugueis.IAluguelDAO;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;

public class ControladorExemplares {

	private IExemplarDAO repositorioExemplares;
	private IAluguelDAO repositorioAlugueis;
	private IDevolucaoDAO repositorioDevolucoes;

	public ControladorExemplares() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		this.repositorioExemplares = factory.getExemplarDAO();
	}

	public boolean existeExemplarDisponivel(Exemplar exemplar)
			throws SQLException {
		int idLivro = exemplar.getLivro().getId();
		int numExemplares = repositorioExemplares
				.buscarPorIDLivroCount(idLivro);
		int numAlugueis = repositorioAlugueis.buscarPorExemplarCount(exemplar);
		int numDevolucoes = repositorioDevolucoes
				.buscarPorExemplarCont(exemplar);

		return (numAlugueis - numDevolucoes < numExemplares);
	}
}
