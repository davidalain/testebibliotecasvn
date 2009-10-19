package br.com.bibliotecavirtual.lib.funcionarios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;

public class FuncionarioDAO implements IFuncionarioDAO{

	private static final String INSERIR = "inserir";
	private static final String REMOVER = "remover";
	private static final String ATUALIZAR = "atualizar";
	private static final String BUSCARPORMATRICULAR = "buscarPorMatricula";
	private static final String MAPEAMENTO = Funcionario.class.getName();
	private static final String BUSCARPORID = "buscarPorID";
	
	private IConexao conexao;
	
	public FuncionarioDAO(){
		DAOFactory factory = DAOFactory.getDAOFactory();
		this.conexao = factory.getConexao();
	}
	
	public void atualizar (Funcionario funcionario) throws SQLException{
		String nome = funcionario.getNome();
		String cpf = funcionario.getCpf();
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(nome);
		parametros.add(cpf);
		parametros.add(cpf);
		conexao.executeNonQuery(MAPEAMENTO, FuncionarioDAO.ATUALIZAR, parametros);
		
	}
	
	public void inserir (Funcionario funcionario) throws SQLException{
		String nome = funcionario.getNome();
		String cpf = funcionario.getCpf();
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(nome);
		parametros.add(cpf);
		this.conexao.executeNonQuery(MAPEAMENTO, FuncionarioDAO.INSERIR, parametros);
	}
	
	public Funcionario buscarPorMatricula (String matricula) throws SQLException{
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(matricula);
		ResultSet rs = conexao.executeQuery(MAPEAMENTO, FuncionarioDAO.BUSCARPORMATRICULAR, parametros);
		Funcionario funcionarioRetorno = null;
		if (rs.next()){
			funcionarioRetorno = new Funcionario(rs.getString("NOME"), rs.getString("matricula"), rs.getInt("ID"));
		}
		return funcionarioRetorno;	
	}
	
	public void remover (String matricula) throws SQLException{
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(matricula);
		this.conexao.executeNonQuery(MAPEAMENTO, FuncionarioDAO.REMOVER, parametros);
		
	}
	
	public boolean existe (String matricula) throws SQLException{
		return this.buscarPorMatricula(matricula) != null;
	}

	public Funcionario buscarPorID(int id) throws SQLException {
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(id);
		ResultSet rs = conexao.executeQuery(MAPEAMENTO, FuncionarioDAO.BUSCARPORID, parametros);
		Funcionario funcionarioRetorno = null;
		if (rs.next()){
			funcionarioRetorno = new Funcionario(rs.getString("NOME"), rs.getString("matricula"), rs.getInt("ID"));
		}
		return funcionarioRetorno;
	}
	
}
