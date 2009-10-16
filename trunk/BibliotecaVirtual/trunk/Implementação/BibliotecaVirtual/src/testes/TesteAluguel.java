package testes;

import junit.framework.TestCase;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.alunos.ControladorAluno;

public class TesteAluguel extends TestCase
{
	public void testSituacaoCadastralOK() {
		
		Aluno alunoAlvo = new Aluno("Diego", "07178992417", "diegompin@gmail.com" );
		
		ControladorAluno controlador = new ControladorAluno();

		try {
			controlador.cadastrarAluno(alunoAlvo);
			
			assertTrue(controlador.validarSituacaoCadastral(alunoAlvo.getCpf()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(TesteAluguelLivro.class);
	}

}
