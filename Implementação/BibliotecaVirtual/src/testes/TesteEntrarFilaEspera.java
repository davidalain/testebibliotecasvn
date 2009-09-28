package testes;

import java.util.List;

public class TesteEntrarFilaEspera {
	
	public void testEntrarFilaEspera()
	{
		ControladorFilaEspera filas = new ControladorFila();
		Livro livros = new Livro();
		Aluno alunoAlvo = new Aluno();
		filas.getLista(livros).add(alunoAlvo);
		assertTrue("Não existe lista de espera", filas.getLista(livros).contains(alunoAlvo));
	}
	
}
