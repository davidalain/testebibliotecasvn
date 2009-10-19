package br.com.bibliotecavirtual.lib.alugueis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.comum.DAOFactory;
import br.com.bibliotecavirtual.lib.comum.IConexao;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;

public class AluguelDAO implements IAluguelDAO
{
	private static final String INSERIR = "inserir";
	private static final String REMOVER_POR_ID = "removerPorID";
	private static final String ATUALIZAR = "atualizar";
	private static final String MAPEAMENTO = Aluguel.class.getName();
	private static final String BUSCAR_POR_ID = "buscarPorID";
	private static final String BUSCAR_POR_PERIODO = "buscarPorPeriodo";
	private static final String BUSCAR_POR_ALUNO = "buscarPorAluno";
	private static final String BUSCAR_POR_EXEMPLAR = "buscarPorExemplar";
	
	private IConexao conexao;
	
	public AluguelDAO()
	{
		DAOFactory factory = DAOFactory.getDAOFactory();
		
		conexao = factory.getConexao();
	}
	
	public void atualizar(Aluguel aluguel) 
	{

		ArrayList<Object> parametros = new ArrayList<Object>();
		
		parametros
	}

	public Collection<Aluguel> buscarPorAluno(Aluno aluno) {
		// TODO Auto-generated method stub
		return null;
	}

	public void buscarPorID(int id) {
		// TODO Auto-generated method stub
		
	}

	public Collection<Aluguel> buscarPorPeriodo(Date dataInicial, Date dataFinal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void inserir(Aluguel aluguel) {
		// TODO Auto-generated method stub
		
	}

	public void remover(int id) {
		// TODO Auto-generated method stub
		
	}

	public Collection<Aluguel> buscarPorAluno(Aluguel aluguel) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Aluguel> buscarPorExemplar(Exemplar exemplar) {
		// TODO Auto-generated method stub
		return null;
	}

}
