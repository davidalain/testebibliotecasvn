package testes;

import fachada.Fachada;
import junit.framework.TestCase;
import br.com.bibliotecavirtual.lib.alunos.Aluno;

public class TesteAluguel extends TestCase
{
	@Override
	protected void setUp() throws Exception {
		
		super.setUp();
	}
	
	public void testSituacaoCadastralOK() {
		
		Aluno alunoAlvo = new Aluno("Diego", "07178992417", "diegompin@gmail.com" );
		
		Fachada fachada = Fachada.getInstance();

		try {
			fachada.cadastrarAluno(alunoAlvo);
			
			assertTrue(fachada.validarSituacaoCadastralAluno(alunoAlvo.getCpf()));
		} catch (Exception e) {
			fail();
		}
	}

	
	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(TesteAluguelLivro.class);
	}

}
