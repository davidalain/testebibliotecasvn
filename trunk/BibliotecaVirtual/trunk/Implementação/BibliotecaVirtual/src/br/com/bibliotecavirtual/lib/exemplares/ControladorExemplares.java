package br.com.bibliotecavirtual.lib.exemplares;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;

public class ControladorExemplares {

	private IExemplarDAO repositorioExemplares;

	public ControladorExemplares() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		this.repositorioExemplares = factory.getExemplarDAO();
	}

	public boolean existeExemplarDisponivel(Exemplar exemplar) {
		repositorioExemplares.quantidade(exemplar.getLivro().getId());
		repositorioAlugueis.
	}
}
