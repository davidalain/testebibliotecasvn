package br.com.bibliotecavirtual.lib.reservas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.Data;
import br.com.bibliotecavirtual.lib.comum.IConexao;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;


public class ReservaDAO implements IReservaDAO {
	private static final String INSERIR = "inserir";
	private static final String REMOVER = "remover";
	private static final String ATUALIZAR = "atualizar";
	private static final String BUSCARPORID = "buscarPorID";
	private static final String BUSCARPORLIVRO = "buscarPorLivro";
	private static final String BUSCARPORFUNCIONARIO = "buscarPorFuncionario";
	private static final String MAPEAMENTO = Reserva.class.getName();
	private IConexao conexao;
	
	public ReservaDAO(){
		DAOFactory factory = DAOFactory.getDAOFactory();
		this.conexao = factory.getConexao();
	}
	
	public void inserir(Data date, Aluno aluno, Livro livro, Funcionario funcionario) throws SQLException{
		
		int alunoID = aluno.getId();
		int funcionarioID = funcionario.getId();
		int livroID = livro.getId();
		ArrayList<Object> parametros = new ArrayList<Object>();
		
		parametros.add(livroID);
		parametros.add(funcionarioID);
		parametros.add(date.toString());
		parametros.add(alunoID);
		conexao.executeNonQuery(MAPEAMENTO, ReservaDAO.INSERIR, parametros);
	}
	
	public void remover (String id) throws SQLException{
		
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(id);
		conexao.executeNonQuery(MAPEAMENTO, ReservaDAO.REMOVER, parametros);
	}
	
	public void atualizar (Reserva reserva) throws SQLException{
		
		Aluno aluno = reserva.getAluno();
		Funcionario funcionario = reserva.getFuncionario();
		Livro livro = reserva.getLivro();
		Data date = reserva.getData();
		
		int alunoID = aluno.getId();
		int funcionarioID = funcionario.getId();
		int livroID = livro.getId();
		int exemplarID = reserva.getId();
		
		ArrayList<Object> parametros = new ArrayList<Object>();
		
		parametros.add(livroID);
		parametros.add(funcionarioID);
		parametros.add(date.toString());
		parametros.add(alunoID);
		parametros.add(exemplarID);
		
		this.conexao.executeNonQuery(MAPEAMENTO, ReservaDAO.ATUALIZAR, parametros);
		
	}
	
	public Reserva buscarPorID(int id) throws SQLException{
		
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(id);
		
		
		
		Aluno aluno = null;
		int alunoID = 0;
		int funcionarioID = 0;
		int livroID = 0;
		
		Funcionario funcionario = null;
		Data date = null;
		Livro livro = null;
		
		ResultSet rs = this.conexao.executeQuery(MAPEAMENTO, ReservaDAO.BUSCARPORID, parametros);
		
		while (rs.next()){
		
			alunoID = rs.getInt("ALUNOID");
			funcionarioID = rs.getInt("FUNCIONARIOID");
			livroID = rs.getInt("LIVROID");
		}
		
		return null;
	}
	
	
	
	
	

	
	
	
}
