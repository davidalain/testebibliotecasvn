package br.com.bibliotecavirtual.lib.alugueis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.Data;
import br.com.bibliotecavirtual.lib.comum.IConexao;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class AluguelDAO implements IAluguelDAO {
	private static final String MAPEAMENTO = Aluguel.class.getName();
	private static final String BUSCAR_POR_PERIODO = "buscarPorPeriodo";
	private static final String BUSCAR_POR_ALUNO = "buscarPorAluno";
	private static final String BUSCAR_POR_EXEMPLAR = "buscarPorExemplar";

	private IConexao conexao;

	public AluguelDAO() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		conexao = factory.getConexao();
	}

	public void atualizar(Aluguel aluguel) throws SQLException {

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(aluguel.getExemplar().getId());

		parametros.add(aluguel.getAluno().getId());

		parametros.add(aluguel.getFuncionario());

		parametros.add(aluguel.getDataAluguel());

		parametros.add(aluguel.getDataDevolucao());

		this.conexao.executeNonQuery(MAPEAMENTO, "ATUALIZAR", parametros);
	}

	public Collection<Aluguel> buscarPorAluno(Aluno aluno) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Object> parametros = new ArrayList<Object>();

		ArrayList<Aluguel> alugueisEncontrados = new ArrayList<Aluguel>();

		parametros.add(aluno.getId());

		ResultSet retorno = this.conexao.executeQuery(MAPEAMENTO,
				BUSCAR_POR_ALUNO, parametros);

		if (retorno.next()) {
			Aluguel aluguel = materializar(retorno);

			alugueisEncontrados.add(aluguel);
		}

		return alugueisEncontrados;
	}

	public int buscarPorAlunoCount(Aluno aluno) throws SQLException {
		return this.buscarPorAluno(aluno).size();
	}

	public Collection<Aluguel> buscarPorLivro(Livro livro) throws SQLException {
		ArrayList<Object> parametros = new ArrayList<Object>();

		ArrayList<Aluguel> alugueisEncontrados = new ArrayList<Aluguel>();

		parametros.add(livro.getId());

		ResultSet retorno = this.conexao.executeQuery(MAPEAMENTO,
				BUSCAR_POR_EXEMPLAR, parametros);

		while (retorno.next()) {
			Aluguel aluguel = materializar(retorno);

			alugueisEncontrados.add(aluguel);
		}

		return alugueisEncontrados;
	}

	public int buscarPorLivroCount(Livro livro) throws SQLException {
		return this.buscarPorLivro(livro).size();
	}

	public Aluguel buscarPorID(int id) throws SQLException {
		Aluguel aluguelEncontrado = new Aluguel();

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(id);

		ResultSet retorno = this.conexao.executeQuery(MAPEAMENTO, "BUSCAR",
				parametros);

		while (retorno.next()) {
			Aluguel aluguel = materializar(retorno);

			aluguelEncontrado = aluguel;

		}

		return aluguelEncontrado;
	}

	public Collection<Aluguel> buscarPorPeriodo(Data dataInicial, Data dataFinal)
			throws SQLException {
		ArrayList<Object> parametros = new ArrayList<Object>();

		ArrayList<Aluguel> alugueisEncontrados = new ArrayList<Aluguel>();

		parametros.add(dataInicial);

		parametros.add(dataFinal);

		ResultSet retorno = this.conexao.executeQuery(MAPEAMENTO,
				BUSCAR_POR_PERIODO, parametros);

		while (retorno.next()) {
			Aluguel aluguel = materializar(retorno);

			alugueisEncontrados.add(aluguel);
		}

		return alugueisEncontrados;
	}

	public int buscarPorPeriodoCount(Data dataInicial, Data dataFinal)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void inserir(Aluguel aluguel) throws SQLException {
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(aluguel.getExemplar().getId());

		parametros.add(aluguel.getAluno().getId());

		parametros.add(aluguel.getFuncionario());

		parametros.add(aluguel.getDataAluguel());

		parametros.add(aluguel.getDataDevolucao());

		this.conexao.executeNonQuery(MAPEAMENTO, "INSERIR", parametros);
	}

	public void remover(int id) throws SQLException {
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(id);

		this.conexao.executeNonQuery(MAPEAMENTO, "REMOVER", parametros);

	}

	private Aluguel materializar(ResultSet retorno) throws SQLException {
		Aluguel aluguelEncontrado = new Aluguel();

		Data dataAluguel = null;

		Data dataDevolucao = null;
		try {
			int id = Integer.parseInt(retorno.getString("id"));

			int exemplarId = Integer.parseInt(retorno.getString("exemplar"));

			int alunoId = Integer.parseInt(retorno.getString("aluno"));

			int funcionarioId = Integer.parseInt(retorno
					.getString("funcionario"));

			dataAluguel = new Data(retorno.getString("dataAluguel"));

			dataDevolucao = new Data(retorno.getString("dataDevolucao"));

			Exemplar exemplar = DAOFactory.getDAOFactory().getExemplarDAO()
					.buscarPorID(exemplarId);

			Aluno aluno = DAOFactory.getDAOFactory().getAlunoDAO().buscarPorID(
					alunoId);

			Funcionario funcionario = DAOFactory.getDAOFactory()
					.getFuncionarioDAO().buscarPorID(funcionarioId);

			aluguelEncontrado.setAluno(aluno);

			aluguelEncontrado.setDataAluguel(dataAluguel);

			aluguelEncontrado.setDataDevolucao(dataDevolucao);

			aluguelEncontrado.setExemplar(exemplar);

			aluguelEncontrado.setFuncionario(funcionario);

			aluguelEncontrado.setId(id);
		}

		catch (ParseException e) {
		} catch (NumberFormatException e) {
		}

		return aluguelEncontrado;

	}

}
