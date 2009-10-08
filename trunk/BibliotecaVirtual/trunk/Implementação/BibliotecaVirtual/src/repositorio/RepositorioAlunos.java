package repositorio;

import basicas.Aluno;

public class RepositorioAlunos {

	public RepositorioAlunos(BancoDados bancoDados) {
		super();
		this.bancoDados = bancoDados;
	}

	private BancoDados bancoDados;
	
	public void inserir (Aluno aluno){
		bancoDados.inserir(aluno);
		
	}
	
	public void remover (Aluno aluno){
		bancoDados.remover(aluno);
	}
	
	public Aluno buscar (Aluno aluno){
		return bancoDados.buscar(aluno);
		
	}
	
	public void atualizar (Aluno aluno){
		bancoDados.atualizar(aluno);
		
	}
	
	
	
	

	
	
}
