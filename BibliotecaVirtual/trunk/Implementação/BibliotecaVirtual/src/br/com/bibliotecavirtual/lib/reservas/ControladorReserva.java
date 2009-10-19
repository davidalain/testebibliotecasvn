package br.com.bibliotecavirtual.lib.reservas;

import java.util.List;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class ControladorReserva {
	private IReservaDAO repositorioReserva;
	
	public ControladorReserva(){
		DAOFactory factory = DAOFactory.getDAOFactory();
		this.repositorioReserva = factory.getReservaDAO();
	}
	
	
	public boolean possuiReserva(Livro livro){
		
		
		
		
		
	}
	
	
	

	

	
	

}
