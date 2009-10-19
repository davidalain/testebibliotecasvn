package br.com.bibliotecavirtual.lib.reservas;

import java.sql.SQLException;
import java.util.List;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.Data;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class ControladorReserva {
	private IReservaDAO repositorioReserva;

	public ControladorReserva(){
		DAOFactory factory = DAOFactory.getDAOFactory();
		this.repositorioReserva = factory.getReservaDAO();
	}


	public boolean possuiReserva(Livro livro) throws SQLException{

		return this.repositorioReserva.existeReserva(livro);
	}

	public void entrarReserva(Data date,Aluno aluno, Livro livro, Funcionario funcionario) throws SQLException{

		this.repositorioReserva.inserir(date, aluno, livro, funcionario);

	}











}
