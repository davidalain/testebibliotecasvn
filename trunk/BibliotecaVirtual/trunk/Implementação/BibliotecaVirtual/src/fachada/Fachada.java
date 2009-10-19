package fachada;

import java.sql.SQLException;
import java.util.Date;

import br.com.bibliotecavirtual.lib.alugueis.Aluguel;
import br.com.bibliotecavirtual.lib.alugueis.ControladorAluguel;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.alunos.ControladorAluno;
import br.com.bibliotecavirtual.lib.comum.Data;
import br.com.bibliotecavirtual.lib.devolucoes.ControladorDevolucao;
import br.com.bibliotecavirtual.lib.exemplares.ControladorExemplar;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;
import br.com.bibliotecavirtual.lib.exemplares.ExemplarNaoDisponivelException;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class Fachada {
	private static Fachada instance;

	private ControladorAluno controladorAluno;
	private ControladorExemplar controladorExemplar;
	private ControladorDevolucao controladorDevolucao;
	private ControladorAluguel controladorAluguel;

	private Fachada() {
		this.controladorAluno = new ControladorAluno();
		this.controladorExemplar = new ControladorExemplar();
		this.controladorDevolucao = new ControladorDevolucao();
		this.controladorAluguel = new ControladorAluguel();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	public boolean validarSituacaoCadastralAluno(String matricula)
			throws SQLException {
		return this.controladorAluno.validarSituacaoCadastral(matricula);
	}

	public void cadastrarAluno(Aluno a) throws SQLException {
		this.controladorAluno.cadastrarAluno(a);
	}

	public boolean existeExemplarDisponivel(Livro livro)
			throws SQLException {
		int numExemplares = controladorExemplar.quantidadeExemplares(livro);
		int numAlugueis = controladorAluguel.quantidade(livro);
		int numDevolucoes = controladorDevolucao.quantidadeDevolucao(livro);

		return (numAlugueis - numDevolucoes < numExemplares);
	}
	
	public void alugar(Aluno aluno, Funcionario funcionario, Exemplar exemplar) throws SQLException, ExemplarNaoDisponivelException
	{
		if(!existeExemplarDisponivel(exemplar.getLivro()))
		{
			throw new ExemplarNaoDisponivelException();
		}
		
		if(this.validarSituacaoCadastralAluno(aluno.getCpf()))
		{
			
		}
		
		Aluguel novoluguel = new Aluguel();
		
		Data dataAluguel = new Data();
		
		Data dataDevolucao = controladorDevolucao.calcularDataDevolucao(dataAluguel);
		
		novoluguel.setAluno(aluno);
		
		novoluguel.setDataAluguel(dataAluguel);
		
		novoluguel.setDataDevolucao(dataDevolucao);
		
		novoluguel.setExemplar(exemplar);
		
		novoluguel.setFuncionario(funcionario);
		
		this.controladorAluguel.alugar(novoluguel);
	}

}
