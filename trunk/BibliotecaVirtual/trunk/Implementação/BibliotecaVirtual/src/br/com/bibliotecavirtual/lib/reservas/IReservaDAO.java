package br.com.bibliotecavirtual.lib.reservas;

import java.sql.SQLException;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.Data;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;

public interface IReservaDAO {
	
	public void inserir(Data date, Aluno aluno, Livro livro, Funcionario funcionario) throws SQLException;
	public void remover (String id) throws SQLException;
	public void atualizar (Reserva reserva) throws SQLException;
	public Reserva buscarPorID(int id) throws SQLException;
	public boolean existeReserva(Livro livro) throws SQLException;



}
