package repositorio;

import basicas.Exemplar;

public class RepositorioExemplares {
	private BancoDados bancoDados;
	
	public RepositorioExemplares()
	{
		
	}
	
	public void inserir (Exemplar exemplar){
		bancoDados.inserir(exemplar);
		
	}
	
	public void remover (Exemplar exemplar){
		bancoDados.remover(exemplar);
	}
	
	public Exemplar buscar (Exemplar exemplar){
		return bancoDados.buscar(exemplar);
		
	}
	
	public void atualizar (Exemplar exemplar){
		bancoDados.atualizar(exemplar);
		
	}
	
	public boolean existeFilaEspera(Exemplar exemplar){
		//pegar o ISBN
		
		return true;
	}
	
	
}
