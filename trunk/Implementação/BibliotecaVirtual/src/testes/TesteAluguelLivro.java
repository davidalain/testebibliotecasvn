package testes;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TesteAluguelLivro extends TestCase 
{

	private void setUp()
	{

	}


	public void testExemplarDisponivelEmColecaoVazia()
	{
		MockControladorExemplar controladorExemplaresVazio = new MockControladorExemplar();

		String nomeLivroProcuradoEmColecaoVazia = "LivroProcurado1";

		Livro livroProcuradoEmColecaoVazia = new Livro(nomeLivroProcuradoEmColecaoVazia);

		boolean existeExemplar = controladorExemplaresVazio.exemplarDisponivel(livroProcuradoEmColecaoVazia);

		assertFalse("Um exemplar n�o est� dispon�vel se a cole��o de exemplares est� vazia", existeExemplar);

	}

	public void testExemplarDisponivelExiste()
	{
		MockControladorExemplar controladorComExemplarProcurado = new MockControladorExemplar();

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
		MockControladorExemplar controladorComExemplarProcurado = new MockControladorExemplar();

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


	public static void main(String[] args) 
	{
		junit.textui.TestRunner.run(TesteAluguelLivro.class);
	}
}
