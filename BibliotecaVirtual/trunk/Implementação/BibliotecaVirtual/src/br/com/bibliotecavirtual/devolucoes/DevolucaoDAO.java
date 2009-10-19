package br.com.bibliotecavirtual.devolucoes;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import br.com.bibliotecavirtual.lib.alugueis.Aluguel;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;

public class DevolucaoDAO implements IDevolucaoDAO {

	public int buscarPorExemplarCont(Exemplar exemplar) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void atualizar(Aluguel aluguel) throws SQLException {
		// TODO Auto-generated method stub

	}

	public int buscarPorAlunoCount(Aluguel aluguel) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<Devolucao> buscarPorExemplar(Exemplar exemplar)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int buscarPorExemplarCount(Exemplar exemplar) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<Devolucao> buscarPorFuncionario(Aluno aluno)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void buscarPorID(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	public Collection<Devolucao> buscarPorPeriodo(Date dataInicial,
			Date dataFinal) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int buscarPorPeriodoCount(Date dataInicial, Date dataFinal)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void inserir(Aluguel aluguel) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void remover(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

}
