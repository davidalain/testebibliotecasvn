package br.com.bibliotecavirtual.devolucoes;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;

public class ControladorDevolucao {
	private IDevolucaoDAO repositorioDevolucao;

	public ControladorDevolucao() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		this.repositorioDevolucao = factory.getDevolucaoDAO();
	}

	public int quantidadeDevolucao(Exemplar exemplar) throws SQLException {
		return repositorioDevolucao.buscarPorExemplarCount(exemplar);
	}
}
