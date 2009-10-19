package br.com.bibliotecavirtual.lib.devolucoes;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class ControladorDevolucao {
	private IDevolucaoDAO repositorioDevolucao;

	public ControladorDevolucao() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		this.repositorioDevolucao = factory.getDevolucaoDAO();
	}

	public int quantidadeDevolucao(Livro livro) throws SQLException {
		return repositorioDevolucao.buscarPorLivroCount(livro);
	}
}
