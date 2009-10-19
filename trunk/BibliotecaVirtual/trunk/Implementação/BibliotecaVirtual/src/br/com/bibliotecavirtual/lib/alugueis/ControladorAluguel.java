package br.com.bibliotecavirtual.lib.alugueis;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class ControladorAluguel 
{
	private IAluguelDAO alugueis;
	
	public ControladorAluguel()
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		
		this.alugueis = factory.getAluguelDAO();
	}
	
	public int quantidade(Livro livro) throws SQLException
	{
		return alugueis.buscarPorLivroCount(livro);
	}
}
