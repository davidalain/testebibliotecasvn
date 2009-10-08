package fachada;

import controlador.ControladorAluno;

public class Fachada {
	private ControladorAluno ctrlAlunos;
	private ControladorExemplares ctrlExemplares;
	
	public void Alugar(Aluno a, Exemplar e)
	{
		if(!ctrlAlunos.validarSituacaoFinanceira(a))
			throw
	}
	
	
}
