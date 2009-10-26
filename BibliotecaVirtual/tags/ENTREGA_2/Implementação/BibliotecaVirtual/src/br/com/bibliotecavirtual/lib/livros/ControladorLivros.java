package br.com.bibliotecavirtual.lib.livros;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;

public class ControladorLivros {
	private ILivroDAO repositorioLivros;
	
	public ControladorLivros(){
		DAOFactory factory = DAOFactory.getDAOFactory();
		this.repositorioLivros= factory.getLivroDAO();
		
	}
	
	public void cadastrar (Livro livro) throws SQLException{
		if (this.repositorioLivros.existe(livro.getIsbn())){
			
		}
		else {
			this.repositorioLivros.inserir(livro);
		}
		
		
	}
	
	
	
}
