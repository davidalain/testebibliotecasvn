package br.com.bibliotecavirtual.lib.alunos;

public class AlunoDevendoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlunoDevendoException(double divida)
	{
		super("Aluno est� devendo: " + divida);
	}
}
