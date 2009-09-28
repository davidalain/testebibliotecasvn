package testes;

import java.util.List;

public class TesteEntrarFilaEspera {
	
	public void testEntrarFilaEspera()
	{
		ControladorFilaEspera cFilas = new ControladorFila();
		Livro livro = new Livro();
		Aluno alunoAlvo = new Aluno();
		cFilas.inserirAluno(alunoAlvo, livro);
		assertTrue("Não existe lista de espera", cFilas.contemAluno(alunoAlvo, livro));
	}
	
}
