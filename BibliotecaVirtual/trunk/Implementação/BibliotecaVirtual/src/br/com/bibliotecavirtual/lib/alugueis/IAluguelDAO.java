package br.com.bibliotecavirtual.lib.alugueis;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;

public interface IAluguelDAO 
{
	public void inserir(Aluguel aluguel) throws SQLException;
	
	public void remover(int id) throws SQLException;
	
	public void atualizar(Aluguel aluguel) throws SQLException;
	
	public void buscarPorID(int id) throws SQLException;
	
	public Collection<Aluguel> buscarPorPeriodo(Date dataInicial, Date dataFinal) throws SQLException;
	
	public Collection<Aluguel> buscarPorAluno(Aluno aluno) throws SQLException;

	public Collection<Aluguel> buscarPorExemplar(Exemplar exemplar) throws SQLException;
	
	public int buscarPorPeriodoCount(Date dataInicial, Date dataFinal) throws SQLException;
	
	public int buscarPorAlunoCount(Aluguel aluguel) throws SQLException;
	
	public int buscarPorExemplarCount(Exemplar exemplar) throws SQLException;
	
}
