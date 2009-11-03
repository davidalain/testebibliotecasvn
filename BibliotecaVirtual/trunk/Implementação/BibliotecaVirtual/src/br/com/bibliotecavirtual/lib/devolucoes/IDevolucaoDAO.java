package br.com.bibliotecavirtual.lib.devolucoes;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;

public interface IDevolucaoDAO {
	public void inserir(Devolucao devolucao) throws SQLException;

	public void remover(int id) throws SQLException;

	public void atualizar(Devolucao devolucao) throws SQLException;

	public void buscarPorID(int id) throws SQLException;

	public Collection<Devolucao> buscarPorPeriodo(Date dataInicial,
			Date dataFinal) throws SQLException;

	public Collection<Devolucao> buscarPorFuncionario(Funcionario funcionario)
			throws SQLException;

	public Collection<Devolucao> buscarPorLivro(Livro livro)
			throws SQLException;

	public int buscarPorPeriodoCount(Date dataInicial, Date dataFinal)
			throws SQLException;

	public int buscarPorAlunoCount(Aluno aluno) throws SQLException;

	public int buscarPorLivroCount(Livro livro) throws SQLException;

}
