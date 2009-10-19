package br.com.bibliotecavirtual.lib.reservas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.bibliotecavirtual.lib.alugueis.AluguelDAO;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.alunos.AlunoDAO;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.Data;
import br.com.bibliotecavirtual.lib.comum.IConexao;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.funcionarios.FuncionarioDAO;
import br.com.bibliotecavirtual.lib.livros.Livro;
import br.com.bibliotecavirtual.lib.livros.LivroDAO;


public class ReservaDAO implements IReservaDAO {
	private static final String INSERIR = "inserir";
	private static final String REMOVER = "remover";
	private static final String ATUALIZAR = "atualizar";
	private static final String BUSCARPORID = "buscarPorID";
	private static final String BUSCAR_POR_LIVRO = "buscarPorLivro";
	private static final String BUSCAR_POR_FUNCIONARIO = "buscarPorFuncionario";
	private static final String EXISTE_LIVRO = "existeLivro";
	
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
	
	private Reserva materializar (ResultSet rs) throws SQLException{
		
		AlunoDAO repositorioAluno = new AlunoDAO();
		FuncionarioDAO repositorioFuncionario = new FuncionarioDAO();
		LivroDAO repositorioLivro = new LivroDAO();
		
		
		int alunoID = 0;
		int funcionarioID = 0;
		int livroID = 0;
		
		Aluno aluno = null;
		Funcionario funcionario = null;
		Livro livro = null;
		String dataStr = null;
		Data date = null;
		
		if(rs.next()){
			alunoID = rs.getInt("ALUNOID");
			System.out.println(alunoID);
			aluno = repositorioAluno.buscarPorID(alunoID);
			
			funcionarioID = rs.getInt("FUNCIONARIOID");
			funcionario = repositorioFuncionario.buscarPorID(funcionarioID);
			
			livroID = rs.getInt("LIVROID");
			livro = repositorioLivro.buscarPorID(livroID);
			
			dataStr = rs.getString("DATA");
			try {
				date = new Data(dataStr);
			} 
			catch (ParseException e) {
				
			}
		}
		
		Reserva retorno = new Reserva(date, aluno, livro, funcionario);
		return retorno;
		
	}
	
	public Reserva buscarPorID(int id) throws SQLException{
		
		Reserva retorno = new Reserva();
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(id);
		
		ResultSet rs = this.conexao.executeQuery(MAPEAMENTO, ReservaDAO.BUSCARPORID, parametros);
		retorno = materializar(rs);
		return retorno;
	}
	
	public boolean existeReserva(Livro livro) throws SQLException{
		
		int livroID = livro.getId();
		ArrayList<Object> parametros = new ArrayList<Object>();
		parametros.add(livroID);
		
		ResultSet rs = this.conexao.executeQuery(MAPEAMENTO, ReservaDAO.EXISTE_LIVRO, parametros);
		
		if (rs.next()){
			return true;
		}
		return false;
		
	}
	
	
	
	
	

	
	
	
}
