package testes;

import java.sql.Date;
import java.util.List;

import junit.framework.TestCase;

public class TesteRenovarLivro extends TestCase {
	
	
	
	public void testLivroEstaAtrasadoVerdadeiro(){
		ControladorLivrosAlugados cLivros = new ControladorLivrosAlugados();
		Exemplar ex = new Exemplar();
		Date devolucao = cLivros.dataDevolucao(ex);
		Date atual = Date.this.getDate();
		
		assertTrue( devolucao.after(atual));
	}
	
	public void testLivroEstaAtrasadoFalso(){
		ControladorLivrosAlugados cLivros = new ControladorLivrosAlugados();
		Exemplar ex = new Exemplar();
		Date devolucao = cLivros.dataDevolucao(ex);
		Date atual = Date.this.getDate();
		
		assertTrue( devolucao.before(atual));
	}
	
	public void testPossuiFilaEsperaVerdadeiro(){
		ControladorFilaEspera cFilas = new ControladorFila();
		Livro livroAlvo = new Livro();
		Aluno alunoAlvo = new Aluno();
		cFilas.criarLista(new List(alunoAlvo));
		assertTrue("Existe lista de espera não vazia", possuiFilaEspera(livroAlvo));
	}
	
	public void testPossuiFilaEsperaFalso(){
		ControladorFilaEspera cFilas = new ControladorFila();
		Livro livroAlvo = new Livro();
		cFilas.removerLista(livroAlvo);
		assertTrue("Não existe lista de espera", possuiFilaEspera(livroAlvo)==0);

	}
	
	public void testBuscarMeusExemplaresOk(){
		Aluno alunoAlvo = new Aluno();
		Exemplar exemplarAlvo1 = new Exemplar();
		Exemplar exemplarAlvo2 = new Exemplar();
		controlador.alugar(alunoAlvo,exemplarAlvo1);
		controlador.alugar(alunoAlvo,exemplarAlvo2);
		assertTrue("Exemplar1 alugado", buscarMeusExemplares(alunoAlvo).size()==2);
		
	}
	
	public void testBuscarMeusExemplaresVazio(){
		Aluno alunoAlvo = new Aluno();
		Exemplar exemplarAlvo1 = new Exemplar();
		Exemplar exemplarAlvo2 = new Exemplar();
		assertFalse("Não terá exemplar alugado", buscarMeusExemplares(alunoAlvo).size()==0);
	}
	
	public void testRenovarExemplarPossivel(){
		Aluno alunoAlvo = new Aluno();
		Exemplar exemplarAlvo = new Exemplar();
		aluno.setDivida(0);
		controlador.alugar(alunoAlvo,exemplarAlvo);
		assertTrue("Buscar meus exemplares contem o livro que eu quero renovar", buscarMeusExemplares(alunoAlvo).contains(exemplarAlvo));
		assertTrue("Checar a situação financeira do aluno", validarSituacaoFinanceira(alunoAlvo) == 0);
		assertFalse("Chechar se o livro não está na fila de espera",possuiFilaEspera(exemplarAlvo));
		assertTrue("Livro renovado com sucesso", renovarExemplar(alunoAlvo,exemplarAlvo));
		
	}
	public void testRenovarExemplarNaoPossivel(){
		
		Aluno alunoAlvo = new Aluno();
		Exemplar exemplarAlvo = new Exemplar();
		Exemplar exemplarNaoAlvo = new Exemplar();
		aluno.setDivida(2);
		controlador.alugar(alunoAlvo,exemplarNaoAlvo);
		assertFalse("Buscar meus exemplares não contem o livro que eu quero renovar", buscarMeusExemplares(alunoAlvo).contains(exemplarAlvo));
		assertFalse("Checar a situação financeira do aluno", validarSituacaoFinanceira(alunoAlvo) == 0);
		assertTrue("Chechar se o livro está na fila de espera",possuiFilaEspera(exemplarAlvo));
		assertFalse("Livro não pode ser renovado", renovarExemplar(alunoAlvo,exemplarAlvo));
	}
	
	public static void main(String[] args) 
	{
		junit.textui.TestRunner.run(TesteRenovarLivro.class);
	}

}
