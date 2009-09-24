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

		assertFalse("Um exemplar não está disponível se a coleção de exemplares está vazia", existeExemplar);

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

		assertTrue("Se existe ao menos um exemplar com status disponivel, então o exemplar está disponível", controladorComExemplarProcurado.exemplarDisponivel(livroProcurado1));
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

		assertFalse("Se não existe ao menos um exemplar com status disponivel, então o exemplar não está disponível", controladorComExemplarProcurado.exemplarDisponivel(livroProcurado1));

	}


	public static void main(String[] args) 
	{
		junit.textui.TestRunner.run(TesteAluguelLivro.class);
	}
}
