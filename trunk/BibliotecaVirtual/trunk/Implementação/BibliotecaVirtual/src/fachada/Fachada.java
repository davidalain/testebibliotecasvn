package fachada;

import basicas.*;
import controlador.*;
import exceptions.*;

public class Fachada {
	private ControladorAluno ctrlAlunos;
	private ControladorExemplares ctrlExemplares;
	
	public void Alugar(Aluno a, Exemplar e)
	{
		if(!ctrlAlunos.validarSituacaoFinanceira(a))
			throw new AlunoNaoCadastradoException();
	}
	
	
}
