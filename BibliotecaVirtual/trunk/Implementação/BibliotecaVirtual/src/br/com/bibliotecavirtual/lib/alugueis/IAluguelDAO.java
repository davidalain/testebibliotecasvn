package br.com.bibliotecavirtual.lib.alugueis;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.livros.Livro;

public interface IAluguelDAO 
{
	public void inserir(Aluguel aluguel) throws SQLException;
	
	public void remover(int id) throws SQLException;
	
	public void atualizar(Aluguel aluguel) throws SQLException;
	
	public Aluguel buscarPorID(int id) throws SQLException;
	
	public Collection<Aluguel> buscarPorPeriodo(Date dataInicial, Date dataFinal) throws SQLException;
	
	public Collection<Aluguel> buscarPorAluno(Aluno aluno) throws SQLException;

	public Collection<Aluguel> buscarPorLivro(Livro livro) throws SQLException;
	
	public int buscarPorPeriodoCount(Date dataInicial, Date dataFinal) throws SQLException;
	
	public int buscarPorAlunoCount(Aluno aluno) throws SQLException;
	
	public int buscarPorLivroCount(Livro livro) throws SQLException;
	
}
