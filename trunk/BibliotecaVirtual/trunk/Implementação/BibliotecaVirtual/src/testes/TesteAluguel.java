package testes;

import fachada.Fachada;
import junit.framework.TestCase;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.alunos.ControladorAluno;

public class TesteAluguel extends TestCase
{
	public void testSituacaoCadastralOK() {
		
		Aluno alunoAlvo = new Aluno("Diego", "07178992417", "diegompin@gmail.com" );
		
		Fachada fachada = Fachada.getInstance();

		try {
			fachada.cadastrarAluno(alunoAlvo);
			
			assertTrue(fachada.validarSituacaoCadastralAluno(alunoAlvo.getCpf()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(TesteAluguelLivro.class);
	}

}
