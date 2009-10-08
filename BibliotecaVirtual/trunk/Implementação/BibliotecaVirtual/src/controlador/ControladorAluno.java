package controlador;

import basicas.*;
import repositorio.*;

public class ControladorAluno {
	private RepositorioAlunos repAlunos;
	
	public ControladorAluno(RepositorioAlunos repAlunos) {
		super();
		this.repAlunos = repAlunos;
	}

	
	public boolean validarSituacaoCadastral(Aluno aluno){
		
		if (repAlunos.buscar(aluno)== null){
			return false;
		}
		return true;
	}
	
	public boolean validarSituacaoFinanceira(Aluno aluno){
		
		return !(aluno.getDivida()>0);
		
	}

}
