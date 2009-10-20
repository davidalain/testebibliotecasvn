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
import br.com.bibliotecavirtual.lib.funcionarios.ControladorFuncionario;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.ControladorLivros;
import br.com.bibliotecavirtual.lib.livros.Livro;

public class Fachada {
	private static Fachada instance;

	private ControladorAluno controladorAluno;
	private ControladorExemplar controladorExemplar;
	private ControladorDevolucao controladorDevolucao;
	private ControladorAluguel controladorAluguel;
	private ControladorFuncionario controladorFuncionario;
	private ControladorLivros controladorLivro;
	
	private Fachada() {
		this.controladorAluno = new ControladorAluno();
		this.controladorExemplar = new ControladorExemplar();
		this.controladorDevolucao = new ControladorDevolucao();
		this.controladorAluguel = new ControladorAluguel();
		this.controladorFuncionario = new ControladorFuncionario();
		this.controladorLivro = new ControladorLivros();
		
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
		
		Data dataAluguel = new Data(new Date().toString());
		
		Data dataDevolucao = controladorDevolucao.calcularDataDevolucao(dataAluguel);
		
		novoluguel.setAluno(aluno);
		
		novoluguel.setDataAluguel(dataAluguel);
		
		novoluguel.setDataDevolucao(dataDevolucao);
		
		novoluguel.setExemplar(exemplar);
		
		novoluguel.setFuncionario(funcionario);
		
		this.controladorAluguel.alugar(novoluguel);
	}
	
	public void cadastrarFuncionario (Funcionario funcionario) throws SQLException{
		this.controladorFuncionario.cadastrar(funcionario);
	}
	
	public void cadastrarLivro (Livro livro) throws SQLException{
		this.controladorLivro.cadastrar(livro);
	}
	
	public void cadastrarExemplar (Exemplar exemplar) throws SQLException{
		this.controladorExemplar.cadastrar(exemplar);
	}

}
