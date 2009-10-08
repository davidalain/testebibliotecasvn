package fachada;

import basicas.*;
import controlador.*;
import exceptions.*;

public class Fachada {
	private ControladorAluno ctrlAlunos;
	private ControladorExemplares ctrlExemplares;
	
	public void Alugar(Aluno a, Exemplar e) throws AlunoNaoCadastradoException, AlunoDevendoException
	{
		if(!ctrlAlunos.validarSituacaoCadastral(a))
			throw new AlunoNaoCadastradoException();
		
		if(!ctrlAlunos.validarSituacaoFinanceira(a))
			throw new AlunoDevendoException(a.getDivida());
		
		if()
	}
	
	
}
