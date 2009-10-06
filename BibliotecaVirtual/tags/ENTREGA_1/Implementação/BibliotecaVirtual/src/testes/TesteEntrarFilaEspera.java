package testes;

import java.util.List;

import junit.framework.TestCase;

public class TesteEntrarFilaEspera extends TestCase {
	
	public void testEntrarFilaEspera()
	{
		ControladorFilaEspera cFilas = new ControladorFila();
		Livro livro = new Livro();
		Aluno alunoAlvo = new Aluno();
		cFilas.inserirAluno(alunoAlvo, livro);
		assertTrue("Não existe lista de espera", cFilas.contemAluno(alunoAlvo, livro));
	}
	
	
	public static void main(String[] args) 
	{
		junit.textui.TestRunner.run(TesteEntrarFilaEspera.class);
	}
}
