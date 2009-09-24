package testes;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TesteAluguelLivro extends TestCase 
{
	private MockControladorExemplar controladorExemplaresVazio = new MockControladorExemplar();
	
	private MockControladorExemplar controladorComExemplarProcurado = new MockControladorExemplar();
	
	MockControladorExemplar controladorComExemplarProcurado = new MockControladorExemplar();

	private void setUp()
	{

	}


	public void testExemplarDisponivelEmColecaoVazia()
	{
		
		String nomeLivroProcuradoEmColecaoVazia = "LivroProcurado1";

		Livro livroProcuradoEmColecaoVazia = new Livro(nomeLivroProcuradoEmColecaoVazia);

		boolean existeExemplar = controladorExemplaresVazio.exemplarDisponivel(livroProcuradoEmColecaoVazia);

		assertFalse("Um exemplar n�o est� dispon�vel se a cole��o de exemplares est� vazia", existeExemplar);

	}

	public void testExemplarDisponivelExiste()
	{
		

		Livro livroProcurado1 = new Livro("LivroProcurado1");

		Livro livroProcurado2 = new Livro("LivroProcurado2");

		controladorComExemplarProcurado.cadastrar(livroProcurado1);

		controladorComExemplarProcurado.cadastrar(livroProcurado1);

		controladorComExemplarProcurado.cadastrar(livroProcurado1);

		controladorComExemplarProcurado.cadastrar(livroProcurado2);

		controladorComExemplarProcurado.alugar(livroProcurado1);

		controladorComExemplarProcurado.alugar(livroProcurado1);

		assertTrue("Se existe ao menos um exemplar com status disponivel, ent�o o exemplar est� dispon�vel", controladorComExemplarProcurado.exemplarDisponivel(livroProcurado1));
	}

	public void testExemplarDisponivelNaoExiste()
	{
		

		Livro livroProcurado1 = new Livro("LivroProcurado1");

		Livro livroProcurado2 = new Livro("LivroProcurado2");

		controladorComExemplarProcurado.cadastrar(livroProcurado1);

		controladorComExemplarProcurado.cadastrar(livroProcurado1);

		controladorComExemplarProcurado.cadastrar(livroProcurado1);

		controladorComExemplarProcurado.cadastrar(livroProcurado2);

		controladorComExemplarProcurado.alugar(livroProcurado1);

		controladorComExemplarProcurado.alugar(livroProcurado1);

		controladorComExemplarProcurado.alugar(livroProcurado1);

		assertFalse("Se n�o existe ao menos um exemplar com status disponivel, ent�o o exemplar n�o est� dispon�vel", controladorComExemplarProcurado.exemplarDisponivel(livroProcurado1));

	}

	public void testSituacaoFinanceiraNegativa(){

		String nome = "Aluno";
		Aluno alunoAlvo = new Aluno(nome);
		alunoAlvo.setDivida(2);
		assertTrue("Aluno devendo.", validarSituacaoFinanceira(alunoAlvo)>0);


	}

	public void testSituacaoFinanceiraOK(){

		String nome = "Aluno";
		Aluno alunoAlvo = new Aluno(nome);
		alunoAlvo.setDivida(0);
		assertTrue("Aluno com situa��o financeira correta.", validarSituacaoFinanceira(alunoAlvo)==0);

	}
	
	public void testSituacaoCadastralOK()
	{
		String nome = "Aluno";
		Aluno alunoAlvo = new Aluno(nome);
		MockControlador control = new MockControlador();
		control.add(alunoAlvo);
		
		assertTrue(control.validarSituacaoCadastral(alunoAlvo));
	}
	
	public void testSituacaoCadastralInvalida()
	{
		String nome = "Aluno";
		Aluno alunoAlvo = new Aluno(nome);
		MockControlador control = new MockControlador();
		
		assertFalse(control.validarSituacaoCadastral(alunoAlvo));
	}


	public static void main(String[] args) 
	{
		junit.textui.TestRunner.run(TesteAluguelLivro.class);
	}
}
