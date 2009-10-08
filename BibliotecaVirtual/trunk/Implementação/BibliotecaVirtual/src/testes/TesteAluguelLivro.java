package testes;

import junit.framework.TestCase;


public class TesteAluguelLivro extends TestCase 
{
	private MockControladorExemplar controladorExemplaresVazio = new MockControladorExemplar();
	
	private MockControladorExemplar controladorComExemplarProcuradoDisponivel = new MockControladorExemplar();
	
	private MockControladorExemplar controladorComExemplarProcuradoNaoDisponivel = new MockControladorExemplar();

	@Override
	protected void setUp() throws Exception 
	{
		String nomeLivroProcuradoEmColecaoVazia = "LivroProcurado1";
		
		Livro livroProcuradoEmColecaoVazia = new Livro(nomeLivroProcuradoEmColecaoVazia);
		
		controladorExemplaresVazio.cadastrar(livroProcurado1);

		controladorExemplaresVazio.cadastrar(livroProcurado1);

		controladorExemplaresVazio.cadastrar(livroProcurado1);
	}


	public void testExemplarDisponivelEmColecaoVazia()
	{
		boolean existeExemplar = controladorExemplaresVazio.exemplarDisponivel(livroProcuradoEmColecaoVazia);

		assertFalse("Um exemplar n�o est� dispon�vel se a cole��o de exemplares est� vazia", existeExemplar);

	}

	public void testExemplarDisponivel()
	{
		
		Livro livroProcurado = new Livro("LivroProcurado1");

		Livro livroProcurado2 = new Livro("LivroProcurado2");

		controladorComExemplarProcuradoDisponivel.alugar(livroProcurado1);

		controladorComExemplarProcuradoDisponivel.alugar(livroProcurado1);
		
		controladorComExemplarProcuradoDisponivel.cadastrar(livroProcurado2);

		assertTrue("Se existe ao menos um exemplar com status disponivel, ent�o o exemplar est� dispon�vel", controladorComExemplarProcurado.exemplarDisponivel(livroProcurado1));
	}

	public void testExemplarNaoDisponivel()
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
		assertTrue("Aluno devendo.", validarSituacaoFinanceira(alunoAlvo) == false);


	}

	public void testSituacaoFinanceiraOK(){

		String nome = "Aluno";
		Aluno alunoAlvo = new Aluno(nome);
		alunoAlvo.setDivida(0);
		assertTrue("Aluno com situa��o financeira correta.", validarSituacaoFinanceira(alunoAlvo)== true);

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
