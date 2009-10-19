package br.com.bibliotecavirtual.lib.alunos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;

public class AlunoDAO implements IAlunoDAO {

	private static final String INSERIR = "inserir";
	private static final String REMOVER = "removerPorID";
	private static final String ATUALIZAR = "atualizar";
	private static final String BUSCAR = "buscar";
	private static final String MAPEAMENTO = Aluno.class.getName();
	private static final String REMOVER_POR_MATRICULA = "removerPorMatricula";
	private IConexao conexao;

	// comentARIO

	public AlunoDAO() {
		DAOFactory factory = DAOFactory.getDAOFactory();

		conexao = factory.getConexao();

	}

	public void atualizar(Aluno aluno) throws SQLException {
		String login = aluno.getNome();
		String email = aluno.getEmail();
		String matricula = aluno.getCpf();

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(login);
		parametros.add(email);
		parametros.add(matricula);

		this.conexao
		.executeNonQuery(MAPEAMENTO, AlunoDAO.ATUALIZAR, parametros);

	}

	public void inserir(Aluno aluno) throws SQLException {
		String login = aluno.getNome();
		String email = aluno.getEmail();
		String matricula = aluno.getCpf();

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(login);
		parametros.add(email);
		parametros.add(matricula);

		conexao.executeNonQuery(MAPEAMENTO, AlunoDAO.INSERIR, parametros);

	}

	public Aluno buscarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Aluno buscarPorMatricula(String matricula) throws SQLException {

		Aluno alunoRetorno = null;

		ResultSet retorno = null;

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(matricula);

		retorno = conexao.executeQuery(MAPEAMENTO, BUSCAR, parametros);

		if (retorno.next()) {
			alunoRetorno = new Aluno(retorno.getInt("ID"),retorno.getString("LOGIN"), 
					retorno.getString("MATRICULA"), retorno.getString("EMAIL"));
		}

		return alunoRetorno;
	}

	public void remover(int id) throws SQLException {
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(id);

		conexao.executeNonQuery(MAPEAMENTO, AlunoDAO.REMOVER, parametros);
	}

	public boolean existe(String matricula) throws SQLException {
		return this.buscarPorMatricula(matricula) != null;
	}

	public void removerAluno(String matricula) throws SQLException {

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(matricula);

		conexao.executeNonQuery(MAPEAMENTO, AlunoDAO.REMOVER_POR_MATRICULA,
				parametros);
		// TODO Auto-generated method stub

	}

	public void remover(String matricula) throws SQLException {
		// TODO Auto-generated method stub

	}

}
