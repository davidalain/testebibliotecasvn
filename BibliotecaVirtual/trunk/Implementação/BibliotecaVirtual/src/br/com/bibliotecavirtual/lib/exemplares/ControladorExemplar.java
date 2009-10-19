package br.com.bibliotecavirtual.lib.exemplares;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class ControladorExemplar {

	private IExemplarDAO repositorioExemplares;

	public ControladorExemplar() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		this.repositorioExemplares = factory.getExemplarDAO();
	}

	public int quantidadeExemplares(Livro livro) throws SQLException {
		int idLivro = livro.getId();
		return repositorioExemplares.buscarPorIDLivroCount(idLivro);
	}
<<<<<<< .mine
	
	public Exemplar buscar(Livro livro) throws SQLException
	{
		return this.repositorioExemplares.buscarPorLivro(livro);
	}
=======
	
	public void cadastrar (Exemplar exemplar) throws SQLException{
		repositorioExemplares.inserir(exemplar);
	}
>>>>>>> .r264

}
