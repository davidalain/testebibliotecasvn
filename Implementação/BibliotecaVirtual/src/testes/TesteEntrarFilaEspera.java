package testes;

import java.util.List;

public class TesteEntrarFilaEspera {
	
	public void testEntrarFilaEspera()
	{
		ControladorFilaEspera filas = new ControladorFila();
		Livro livro = new Livro();
		Aluno alunoAlvo = new Aluno();
		filas.inserirAluno(alunoAlvo, livro);
		assertTrue("Não existe lista de espera", filas.contemAluno(alunoAlvo, livro));
	}
	
}
