package br.com.bibliotecavirtual.lib.alunos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;

public class AlunoDAO implements IAlunoDAO{

	private static final String INSERIR = "inserir";
	private static final String REMOVER = "removerPorID";
	private static final String ATUALIZAR = "atualizar";
	private static final String BUSCAR = "buscar";
	private static final String CAMINHO = "src\\br\\com\\bibliotecavirtual\\lib\\alunos\\alunos.xml";
	private static final String REMOVER_POR_MATRICULA = "removerPorMatricula";
	private IConexao conexao ;

	// comentARIO

	public AlunoDAO()  
	{
		DAOFactory factory = DAOFactory.getDAOFactory();

		conexao = factory.getConexao();
	}

	public void atualizarAluno(Aluno aluno) throws SQLException {
		String login = aluno.getNome();
		String email = aluno.getEmail();
		String matricula = aluno.getCpf();

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(login);
		parametros.add(email);
		parametros.add(matricula);

		this.conexao.executeNonQuery(CAMINHO, AlunoDAO.ATUALIZAR, parametros);

	}

	public void inserirAluno(Aluno aluno) throws SQLException {
		String login = aluno.getNome();
		String email = aluno.getEmail();
		String matricula = aluno.getCpf();

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(login);
		parametros.add(email);
		parametros.add(matricula);

		conexao.executeNonQuery(CAMINHO, AlunoDAO.INSERIR, parametros);

	}

	public Aluno obterAlunoPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Aluno obterAlunoPorMatricula(String matricula) throws SQLException 
	{

		Aluno alunoRetorno = null;

		ResultSet retorno = null;

		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(matricula);

		retorno = conexao.executeQuery(CAMINHO, BUSCAR, parametros);

		if (retorno.next()) 
		{
			alunoRetorno = new Aluno(retorno.getString("ALN_NM_LOGIN"), retorno
					.getString("ALN_CD_MATRICULA"), retorno
					.getString("ALN_NM_SENHA"), retorno
					.getString("ALN_NM_EMAIL"));

		}

		return alunoRetorno;
	}

	public void removerAluno(int id) throws SQLException 
	{
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(id);

		conexao.executeNonQuery(CAMINHO, AlunoDAO.REMOVER, parametros);
	}

	public void removerAluno(String matricula) throws SQLException {
		
		ArrayList<Object> parametros = new ArrayList<Object>();

		parametros.add(matricula);

		conexao.executeNonQuery(CAMINHO, AlunoDAO.REMOVER_POR_MATRICULA, parametros);
		// TODO Auto-generated method stub

	}

}
