package br.com.bibliotecavirtual.lib.devolucoes;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.Data;
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

	@SuppressWarnings("deprecation")
	public Data calcularDataDevolucao(Data data) {
		Data retorno = (Data) data.clone();
		retorno.setDate(retorno.getDate() + 7);
		return retorno;
	}

	public void devolver(Devolucao devolucao) throws SQLException {
		Data dataDevolucao = devolucao.getAluguel().getDataDevolucao();
		Data atual = new Data();
		if (dataDevolucao.before(atual))
			this.repositorioDevolucao.inserir(devolucao);
	}
}
