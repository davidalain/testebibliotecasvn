package br.com.bibliotecavirtual.lib.reservas;

import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
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
	
	public void inserir(Date date, Aluno aluno, Livro livro, Funcionario funcionario){
		int alunoID = aluno.getId();
		int funcionarioID = funcionario.ge
		
		
	}
	
	

	
	
	
}
